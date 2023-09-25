package com.springWeb.WebApplication.Controler;

import com.springWeb.WebApplication.Entity.College;
import com.springWeb.WebApplication.Entity.Student;
import com.springWeb.WebApplication.Repositry.CollegeRep;
import com.springWeb.WebApplication.Repositry.StudentRep;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserCntrl {
    @Autowired
    CollegeRep userRepo;
    @Autowired
    StudentRep studentRep;

    //get all college
    @GetMapping("/")
    public List<College> getUsers(){
        System.out.println("Get Method");
        List<College> colleges=userRepo.findAll();
        return colleges;
    }

    //get  college by id
    @GetMapping("/{id}")
    public College getById(@PathVariable Long id){
        try{
            Optional<College> college=userRepo.findById(id);
            College college1=college.get();
            return college1;
        }
        catch (Exception e){
            System.out.println("No College With The Id Exist");
            return null;
        }
    }

    // Get All student By college id
    @GetMapping("/{id}/students")
    public List<Student > getStudentById(@PathVariable Long id){
        Optional<College> college=userRepo.findById(id);
        College college1=college.get();
        return college1.getStudents();
    }

    // Get particular Student By id
    @GetMapping("/students/{studentid}")
    public Student getByStudentId(@PathVariable Long studentid){
        try{
            Optional<Student> optionalStudent=studentRep.findById(studentid);
            Student student=optionalStudent.get();
            return student;
        }
        catch (Exception e){
            System.out.println("No Student With the id Exist");
            return null;
        }
    }

    // Add College
    @PostMapping("/")
    public College addData(@RequestBody College clg){
        List<Student> studentList=clg.getStudents();
        for(int i=0;i<studentList.size();i++){
            studentList.get(i).setCollege(clg);
        }
        userRepo.save(clg);
        return clg;
    }

    // Update College By college Id
    @PutMapping("/{id}")
    public College addStudents(@PathVariable long id,@RequestBody College clg){
        try{
            Optional<College> optionalCollege=userRepo.findById(id);
            College college=optionalCollege.get();
            college.setName(clg.getName());
            college.setLocation(clg.getLocation());
            userRepo.save(college);
            return clg;
        }
        catch (Exception e){
            System.out.println("No College with the id exist");
            return null;
        }

    }


    // Add Student to particular College
    @PostMapping("/{id}/students")
    public boolean addstudents(@PathVariable Long id,@RequestBody Student student){
        try {
            Optional<College> optionalCollege = userRepo.findById(id);
            College college=optionalCollege.get();
            student.setCollege(college);
            college.getStudents().add(student);
            userRepo.save(college);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    // Update Student By id
    @PutMapping("/students/{id}")
    public boolean upDataStudents(@PathVariable long id,@RequestBody Student st){
        try{
            System.out.println("update");
            System.out.println(st);
            Optional<Student > optionalStudent=studentRep.findById(id);
            Student student=optionalStudent.get();
            student.setName(st.getName());
            student.setEmail(st.getEmail());
            studentRep.save(student);
            return  true;
        }
        catch (Exception e){
            return false;
        }
    }
    // Delete Student By id
    @DeleteMapping("/students/{studentsId}")
    public boolean deleteStudentId(@PathVariable Long studentsId){
        try {
            studentRep.deleteById(studentsId);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    // Delete College By id
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id){
        try {
            userRepo.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
