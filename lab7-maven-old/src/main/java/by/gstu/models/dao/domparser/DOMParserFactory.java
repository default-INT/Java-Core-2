package by.gstu.models.dao.domparser;

import by.gstu.models.dao.AccountDAO;
import by.gstu.models.dao.DAOFactory;
import by.gstu.models.dao.HospitalDAO;
import by.gstu.models.dao.PatientDAO;
import by.gstu.models.entities.Account;
import by.gstu.models.entities.Doctor;
import by.gstu.models.entities.MedicalStaff;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DOMParserFactory extends DAOFactory {

    private static final String DOCUMENT_PATH = "hospital.xml";
    private static Document document;

    static {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new File(DOCUMENT_PATH));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AccountDAO<MedicalStaff> getMedicalStaffDAO() {
        return null;
    }

    public AccountDAO<Doctor> getDoctorDAO() {
        return null;
    }

    public AccountDAO<Account> getAccountDAO() {
        return null;
    }

    public HospitalDAO getHospitalDAO() {
        return null;
    }

    public PatientDAO getPatientDAO() {
        return null;
    }

    public static boolean saveChanges() throws TransformerFactoryConfigurationError {
        try (FileOutputStream fos = new FileOutputStream(DOCUMENT_PATH)) {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
            return true;
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
}
