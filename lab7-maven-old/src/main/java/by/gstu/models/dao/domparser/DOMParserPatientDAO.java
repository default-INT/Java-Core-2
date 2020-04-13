package by.gstu.models.dao.domparser;

import by.gstu.models.dao.PatientDAO;
import by.gstu.models.entities.Patient;
import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.Collection;

public class DOMParserPatientDAO implements PatientDAO {
    private static final String PATIENTS = "patients";
    private static final String PATIENT = "patient";

    private Document document;

    public DOMParserPatientDAO(Document document) {
        this.document = document;
    }

    @Override
    public boolean createDestination(int patientId, Patient.Destination destination) {
        NodeList nodeList = document.getElementsByTagName(PATIENT);

        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            int id = Integer.parseInt(attributes.getNamedItem("id").getNodeValue());
            if (id == patientId) {
                return createDestination(nodeList.item(i), destination);
            }
        }
        return false;
    }

    private boolean createDestination(Node patientNode, Patient.Destination destination) {
        Node destinationsNode = patientNode.getChildNodes().item(0);

        Element newDestinationNode = document.createElement("destination");
        newDestinationNode.setAttribute("name", destination.getName());
        newDestinationNode.setAttribute("type", destination.getType());

        destinationsNode.appendChild(newDestinationNode);
        return DOMParserFactory.saveChanges();
    }

    public Collection<Patient.Destination> readAllDestination(int patientId) {
        NodeList nodeList = document.getElementsByTagName(PATIENT);

        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            int id = Integer.parseInt(attributes.getNamedItem("id").getNodeValue());
            if (id == patientId) {
                return readAllDestination(nodeList.item(i));
            }
        }
        return null;
    }

    @Override
    public boolean updateDestination(int patientId, int index, Patient.Destination destination) {
        deleteDestination(patientId, index);
        return createDestination(patientId, destination);
    }

    private Collection<Patient.Destination> readAllDestination(Node patientNode) {
        NodeList destinationsNodes = patientNode.getChildNodes().item(0).getChildNodes();
        Collection<Patient.Destination> destinations = new ArrayList<>();
        for (int i = 0; i < destinationsNodes.getLength(); i++) {
            NamedNodeMap attributes = destinationsNodes.item(i).getAttributes();
            String type = attributes.getNamedItem("type").getNodeValue();
            String name = attributes.getNamedItem("name").getNodeValue();
            switch (type) {
                case "drug" -> destinations.add(new Patient.Drug(name));
                case "operation" -> destinations.add(new Patient.Operation(name));
                case "procedure" -> destinations.add(new Patient.Procedure(name));
            }
        }
        return destinations;
    }

    @Override
    public boolean deleteDestination(int patientId, int index) {
        NodeList nodeList = document.getElementsByTagName(PATIENT);
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            if (Integer.parseInt(attributes.getNamedItem("id").getNodeValue()) == patientId) {
                nodeList.item(i).removeChild(nodeList.item(i).getChildNodes().item(index));
                return DOMParserFactory.saveChanges();
            }
        }
        return false;
    }

    public boolean create(Patient account) {
        Node node = document.getElementsByTagName(PATIENTS).item(0);
        Element patientNode = document.createElement("patient");
        patientNode.setAttribute("id",((Integer) account.getId()).toString());
        patientNode.setAttribute("fullName", account.getFullName());
        patientNode.setAttribute("doctorId", ((Integer) account.getDoctorId()).toString());
        patientNode.setAttribute("diagnosis", account.getDiagnosis());

        account.getDestinations().forEach(destination -> {
            Element destinationNode = document.createElement("destination");
            destinationNode.setAttribute("name", destination.getName());
            destinationNode.setAttribute("type", destination.getType());

            patientNode.appendChild(destinationNode);
        });

        node.appendChild(patientNode);
        return DOMParserFactory.saveChanges();
    }

    public Patient read(int id) {
        NodeList nodeList = document.getElementsByTagName(PATIENT);

        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            int patientId = Integer.parseInt(attributes.getNamedItem("id").getNodeValue());
            if (patientId == id) {
                int doctorId = Integer.parseInt(attributes.getNamedItem("doctorId").getNodeValue());
                String fullName = attributes.getNamedItem("fullName").getNodeValue();
                var destinations = readAllDestination(nodeList.item(i));

                return new Patient(patientId, fullName, doctorId, destinations);
            }
        }
        return null;
    }

    public Collection<Patient> readAll() {
        NodeList nodeList = document.getElementsByTagName(PATIENT);
        Collection<Patient> patients = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            int id = Integer.parseInt(attributes.getNamedItem("id").getNodeValue());
            int doctorId = Integer.parseInt(attributes.getNamedItem("doctorId").getNodeValue());
            String fullName = attributes.getNamedItem("fullName").getNodeValue();
            var destinations = readAllDestination(nodeList.item(i));

            patients.add(new Patient(id, fullName, doctorId, destinations));
        }
        return patients;
    }

    public boolean update(Patient account) {
        delete(account.getId());
        create(account);
        return DOMParserFactory.saveChanges();
    }

    public boolean delete(int id) {
        Node patientsElement = document.getElementsByTagName(PATIENTS).item(0);
        NodeList nodeList = document.getElementsByTagName(PATIENT);
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            if (Integer.parseInt(attributes.getNamedItem("id").getNodeValue()) == id) {
                patientsElement.removeChild(nodeList.item(i));
                return DOMParserFactory.saveChanges();
            }
        }
        return false;
    }
}
