package by.gstu.models.entities;

import java.util.Collection;

public class MedicalStaff extends Account {

    private Collection<Patient> patients;

    public Collection<Patient> getPatients() {
        if (patients == null) {
            // TODO: get information from xml file.
        }
        return patients;
    }

    public MedicalStaff(int id, String fullName) {
        super(id, fullName);
    }
}
