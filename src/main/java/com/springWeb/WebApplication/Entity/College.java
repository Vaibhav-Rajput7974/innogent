
package com.springWeb.WebApplication.Entity;

import com.springWeb.WebApplication.Repositry.CollegeRep;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "college")
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)@Column(name="id",nullable = false)
    private Long id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "college",cascade = CascadeType.ALL)
    List<Student> students ;

    public List<Student> getStudents() {
        return students;
    }

    public Long getId() {
        return id;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void addStudent(Student st){
        students.add(st);
    }
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", students=" + students +
                '}';
    }
}

