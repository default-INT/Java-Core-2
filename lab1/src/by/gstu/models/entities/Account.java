package by.gstu.models.entities;

import org.json.JSONObject;

import java.util.Objects;

/**
 * Entity class.
 *
 * @author Evgeniy Trofimov
 * @version 2.0
 */
public abstract class Account extends Entity {
    protected String login;
    protected transient String password;
    protected String email;
    protected String fullName;

    public static String staticField;

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param id
     * @param login
     * @param password
     * @param email
     * @param fullName
     */
    public Account(int id, String login, String password, String email, String fullName) {
        super(id);
        this.login = login;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    /**
     *
     * @param login
     * @param password
     * @param email
     * @param fullName
     */
    public Account(String login, String password, String email, String fullName) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    /**
     *
     * @param id
     * @param login
     * @param email
     * @param fullName
     */
    public Account(int id, String login, String email, String fullName) {
        super(id);
        this.login = login;
        this.email = email;
        this.fullName = fullName;
    }

    public Account() {
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return this.hashCode() == account.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getEmail(), getFullName());
    }

    @Override
    public JSONObject toJSON() {
        JSONObject accountJson = super.toJSON();

        accountJson.put("login", login);
        accountJson.put("email", email);
        accountJson.put("fullName", fullName);

        return accountJson;
    }
}
