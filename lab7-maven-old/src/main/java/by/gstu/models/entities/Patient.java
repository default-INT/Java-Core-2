package by.gstu.models.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Patient extends Account {
    private int doctorId;
    private Collection<Destination> destinations;
    private String diagnosis;

    public Patient() {
    }

    public Patient(int id, String fullName, int doctorId, Collection<Destination> destinations) {
        super(id, fullName);
        this.doctorId = doctorId;
        this.destinations = destinations;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Collection<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(Collection<Destination> destinations) {
        this.destinations = destinations;
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void removeDestinations(int index) {
        ((List<Destination>)destinations).remove(index);
    }

    public void removeDestinations() {
        destinations = new ArrayList<Destination>();
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public abstract static class Destination {
        private String name;

        public Destination() {
        }

        public Destination(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return "none";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Destination)) return false;
            Destination that = (Destination) o;
            return that.getName().equals(getName());
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    public static class Drug extends Destination {
        public Drug(String name) {
            super(name);
        }

        @Override
        public String getType() {
            return "drug";
        }
    }

    public static class Operation extends Destination {
        public Operation(String name) {
            super(name);
        }

        @Override
        public String getType() {
            return "operation";
        }
    }

    public static class Procedure extends Destination {
        public Procedure(String name) {
            super(name);
        }

        @Override
        public String getType() {
            return "procedure";
        }
    }
}
