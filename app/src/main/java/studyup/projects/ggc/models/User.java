package studyup.projects.ggc.models;

/**
 * Created by matt-the-wizard on 11/8/15.
 */
public class User {
    public static User LOGGED_IN_USER;
    private String data;

    public User(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    }
}
