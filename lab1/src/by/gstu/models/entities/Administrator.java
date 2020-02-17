package by.gstu.models.entities;

import org.json.JSONObject;

/**
 * Entity class.
 * Extends Account.
 *
 * @author Evgeniy Trofimov
 * @version 2.0
 */
public class Administrator extends Account {
    private static final long serialVersionUID = 1L;
    /**
     *
     * @param id
     * @param login
     * @param password
     * @param email
     * @param fullName
     */
    public Administrator(int id, String login, String password, String email, String fullName) {
        super(id, login, password, email, fullName);
    }

    public Administrator() {
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", version=" + serialVersionUID  +
                ", staticField=" + staticField +
                '}';
    }

    /**
     *
     * @param id
     * @param login
     * @param email
     * @param fullName
     */
    public Administrator(int id, String login, String email, String fullName) {
        super(id, login, email, fullName);
    }



    @Override
    public JSONObject toJSON() {
        JSONObject adminJson = super.toJSON();
        adminJson.put("status", "admin");
        return adminJson;
    }
}
