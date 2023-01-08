package erasmus.frontla.objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Course {
     Integer id;

     String name;

     String definition;

     Integer credits;

     String semester;

     String university;

    public Course(String name, String definition, Integer credits,String semester, String university) {
        this.name = name;
        this.definition = definition;
        this.credits = credits;
        this.semester=semester;
        this.university = university;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name=name;}

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String email) {
        this.definition = email;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getUniversity() {return university;}

    public void setUniversity(String university) {this.university = university;}
}

