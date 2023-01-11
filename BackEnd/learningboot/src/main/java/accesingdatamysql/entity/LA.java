package accesingdatamysql.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class LA {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;

    public String student;

    public List<Course> courses1;

    public List<Course> courses2;

    public String supervisor1;

    public String supervisor2;

    public int year;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Course> getCourses1() {
        return courses1;
    }

    public void addCourses1(Course courses) {
        courses1.add(courses);
    }

    public List<Course> getCourses2() {
        return courses1;
    }

    public void addCourses2(Course courses) {
        courses2.add(courses);
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSupervisor1() {
        return supervisor1;
    }

    public void setSupervisor1(String supervisor1) {
        this.supervisor1 = supervisor1;
    }

    public String getSupervisor2() {
        return supervisor2;
    }

    public void setSupervisor2(String supervisor2) {
        this.supervisor2 = supervisor2;
    }
    
}