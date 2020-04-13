package by.gstu.models.entities;

public abstract class Account extends Entity {
    protected String fullName;

    public Account() {
    }

    public Account(int id, String fullName) {
        super(id);
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
