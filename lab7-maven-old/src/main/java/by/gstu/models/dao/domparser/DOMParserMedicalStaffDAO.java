package by.gstu.models.dao.domparser;

import by.gstu.models.dao.AccountDAO;
import by.gstu.models.entities.MedicalStaff;
import org.w3c.dom.Document;

import java.util.Collection;

public class DOMParserMedicalStaffDAO implements AccountDAO<MedicalStaff> {
    private static final String MEDICAL_STAFFS = "medicalStaff";
    private static final String MEDICAL_STAFF = "patient";

    private Document document;

    public DOMParserMedicalStaffDAO(Document document) {
        this.document = document;
    }

    public boolean create(MedicalStaff account) {
        return false;
    }

    public MedicalStaff read(int id) {
        return null;
    }

    public Collection<MedicalStaff> readAll() {
        return null;
    }

    public boolean update(MedicalStaff account) {
        return false;
    }

    public boolean delete(int id) {
        return false;
    }
}
