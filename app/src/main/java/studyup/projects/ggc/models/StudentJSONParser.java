package studyup.projects.ggc.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StudentJSONParser {

    private StudentJSONParser(){}

    public static Student parseJSONRecord(String data){
        Student student = new Student();
        JSONObject newJSON = null;
        try {
            JSONObject jsonObject = new JSONObject(data);
            newJSON = jsonObject.getJSONObject("student");
            student.setUserName(newJSON.get("username").toString());
            student.setFirstName(newJSON.get("first_name").toString());
            student.setLastName(newJSON.get("last_name").toString());
            student.setInstitution(newJSON.get("institution").toString());
        } catch (JSONException e) {
            Log.d("Error", e.getMessage());
        }
        catch (Exception e){
            Log.d("Error", e.getMessage());
        }
        return student;
    }

    public static String parseJSONError(String data){
        String response = "Error";
        try {
            JSONObject jsonObject = new JSONObject(data);
            response = jsonObject.get(Student.AUTHENTICATION_ERROR).toString();
        }
        catch(JSONException e) {}
        return response;
    }

    public static ArrayList<Student> parseJSONRecordList(String data) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            JSONObject jObject = new JSONObject(data);
            JSONArray jArray = jObject.getJSONArray("students");
            for (int i = 0; i < jArray.length(); i++) {
                Student student = new Student();
                JSONObject newJSON = jArray.getJSONObject(i);
                student.setUserName(newJSON.get("username").toString());
                student.setFirstName(newJSON.get("first_name").toString());
                student.setLastName(newJSON.get("last_name").toString());
                student.setInstitution(newJSON.get("institution").toString());
                studentList.add(student);
            }
        } catch (JSONException e){}
        return studentList;
    }

    /*public static void main(String[] args){
        StudentJSONParser.parseJSONRecord("{\"student\":{\"id\":6,\"username\":\"wizard@ggc.edu\",\"first_name\":\"Test First\",\"last_name\":\"Test Last\",\"institution\":\"Hogwarts\"}}");
    }*/
}


