package by.gstu.models.dao.domparser;

import by.gstu.models.dao.AccountDAO;
import by.gstu.models.entities.Account;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DOMParserAccountDAO implements AccountDAO {

    private Document document;

    public DOMParserAccountDAO(Document document) {
        this.document = document;
    }

    public boolean create(Account account) {
        return false;
    }

    public Account read(int id) {
        return null;
    }

    public Collection<Account> readAll() {
        List<Account> accounts = new ArrayList<>();

        DOMParserDoctorDAO domParserDoctorDAO = new DOMParserDoctorDAO(document);
        DOMParserMedicalStaffDAO domParserMedicalStaffDAO = new DOMParserMedicalStaffDAO(document);
        DOMParserPatientDAO domParserPatientDAO = new DOMParserPatientDAO(document);

        accounts.addAll(domParserDoctorDAO.readAll());
        accounts.addAll(domParserMedicalStaffDAO.readAll());
        accounts.addAll(domParserPatientDAO.readAll());

        return accounts;
    }

    public boolean update(Account account) {
        return false;
    }

    public boolean delete(int id) {
        return false;
    }
}
