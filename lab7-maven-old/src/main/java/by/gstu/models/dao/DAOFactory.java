package by.gstu.models.dao;

import by.gstu.models.dao.domparser.DOMParserFactory;
import by.gstu.models.entities.Account;
import by.gstu.models.entities.Doctor;
import by.gstu.models.entities.MedicalStaff;

public abstract class DAOFactory {

    public abstract AccountDAO<MedicalStaff> getMedicalStaffDAO();
    public abstract AccountDAO<Doctor> getDoctorDAO();
    public abstract AccountDAO<Account> getAccountDAO();

    public abstract HospitalDAO getHospitalDAO();
    public abstract PatientDAO getPatientDAO();

    public static DAOFactory getDAOFactory() {
        return new DOMParserFactory();
    }
}
