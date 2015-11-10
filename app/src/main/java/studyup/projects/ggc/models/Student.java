package studyup.projects.ggc.models;

public class Student {
    public static Student LOGGED_IN_USER;
    private String userName, firstName, lastName, institution;

    public Student(){}

    public Student(String userName, String firstName, String lastName, String institution) {
        this.setUserName(userName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setInstitution(institution);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName == null)
            this.userName = "";
        else
            this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null)
            this.firstName = "";
        else
          this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null)
            this.lastName = "";
        else
            this.lastName = lastName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        if (institution == null)
            this.institution = "";
        else
            this.institution = institution;
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.lastName + " " + this.institution;
    }
}