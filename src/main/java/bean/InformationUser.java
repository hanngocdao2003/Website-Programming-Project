package bean;

public class InformationUser {
    private int id;
    private String name;
    private String numberphone;
    private String email;
    private String role;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public int getStatus() {
        return status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InformationUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberphone='" + numberphone + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                '}';
    }
}
