package studyup.projects.ggc.models;

public class Student {
    public static Student LOGGED_IN_USER;
    private String USERNAME, FIRSTNAME, LASTNAME, INSTITUTION;

    public String getUsername() {
        return USERNAME;
    }

    public void setUsername(String username) {
        this.USERNAME = username;
    }

    public String getFirstName() {
        return this.FIRSTNAME;
    }

    public void setFirstName(String firstName) {
        this.FIRSTNAME = firstName;
    }

    public String getLastName() {
        return this.LASTNAME;
    }

    public void setLastName(String lastName) {
        this.LASTNAME = lastName;
    }

    public String getInstitution() {
        return this.INSTITUTION;
    }

    public void setInstitution(String institution) {
        this.INSTITUTION = institution;
    }

    @Override
    public String toString(){
        return this.FIRSTNAME;
    }
}