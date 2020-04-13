package by.gstu.models.dao.domparser;

import by.gstu.models.dao.AccountDAO;
import by.gstu.models.entities.Doctor;
import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.Collection;

public class DOMParserDoctorDAO implements AccountDAO<Doctor> {
    private Document document;

    private static final String DOCTORS = "doctors";
    private static final String DOCTOR = "doctor";

    public DOMParserDoctorDAO(Document document) {
        this.document = document;
    }

    public boolean create(Doctor account) {
        NodeList nodeList = document.getElementsByTagName(DOCTORS);
        Element doctor = document.createElement(DOCTOR);
        doctor.setAttribute("id", String.valueOf(account.getId()));
        doctor.setAttribute("fullName", account.getFullName());

        nodeList.item(0).appendChild(doctor);
        return DOMParserFactory.saveChanges();
    }

    public Doctor read(int id) {
        NodeList nodeList = document.getElementsByTagName(DOCTOR);
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            if (Integer.parseInt(attributes.getNamedItem("id").getNodeValue()) == id) {
                String fullName = attributes.getNamedItem("fullName").getNodeValue();
                return new Doctor(id, fullName);
            }
        }
        return null;
    }

    public Collection<Doctor> readAll() {
        NodeList nodeList = document.getElementsByTagName(DOCTOR);
        Collection<Doctor> doctors = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            int id = Integer.parseInt(attributes.getNamedItem("id").getNodeValue());
            String fullName = attributes.getNamedItem("fullName").getNodeValue();

            doctors.add(new Doctor(id, fullName));
        }
        return doctors;
    }

    public boolean update(Doctor account) {
        NodeList nodeList = document.getElementsByTagName(DOCTOR);
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            if (Integer.parseInt(attributes.getNamedItem("id").getNodeValue()) == account.getId()) {
                attributes.getNamedItem("fullName").setNodeValue(account.getFullName());
                return DOMParserFactory.saveChanges();
            }
        }
        return false;
    }

    public boolean delete(int id) {
        Node doctorsElement = document.getElementsByTagName(DOCTORS).item(0);
        NodeList nodeList = document.getElementsByTagName(DOCTOR);
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            if (Integer.parseInt(attributes.getNamedItem("id").getNodeValue()) == id) {
                doctorsElement.removeChild(nodeList.item(i));
                return DOMParserFactory.saveChanges();
            }
        }
        return false;
    }
}
