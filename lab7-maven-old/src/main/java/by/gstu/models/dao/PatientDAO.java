package by.gstu.models.dao;

import by.gstu.models.entities.Patient;

import java.util.Collection;

public interface PatientDAO extends AccountDAO<Patient> {
    boolean createDestination(int patientId, Patient.Destination destination);
    Collection<Patient.Destination> readAllDestination(int patientId);
    boolean updateDestination(int patientId, int index, Patient.Destination destination);
    boolean deleteDestination(int patientId, int index);
}
