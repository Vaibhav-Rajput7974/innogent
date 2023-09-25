package com.springWeb.WebApplication.Controler;

import com.springWeb.WebApplication.Entity.College;
import com.springWeb.WebApplication.Entity.Student;
import com.springWeb.WebApplication.Repositry.CollegeRep;
import com.springWeb.WebApplication.Repositry.StudentRep;
import com.springWeb.WebApplication.Service.CollegeService;
import com.springWeb.WebApplication.Service.StudentService;
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

    @Autowired
    CollegeService collegeService;

    @Autowired
    StudentService studentService;
    //get all college
    @GetMapping("/")
    public List<College> getUsers(){
        return collegeService.getUsers(userRepo);
    }

    //get  college by id
    @GetMapping("/{id}")
    public College getById(@PathVariable Long id){
        return collegeService.getById(id,userRepo);
    }

    // Get All student By college id
    @GetMapping("/{id}/students")
    public List<Student > getStudentById(@PathVariable Long id){
        return collegeService.getStudentById(id,userRepo);
    }

    // Get particular Student By id
    @GetMapping("/students/{studentid}")
    public Student getByStudentId(@PathVariable Long studentid){
        return studentService.getByStudentId(studentid,studentRep);
    }

    // Add College
    @PostMapping("/")
    public College addData(@RequestBody College clg){
        return collegeService.addData(clg,userRepo);

    }

    // Update College By college Id
    @PutMapping("/{id}")
    public College Update(@PathVariable long id,@RequestBody College clg){
        return  collegeService.UpdateCollege(id,clg,userRepo);
    }


    // Add Student to particular College
    @PostMapping("/{id}/students")
    public boolean addstudents(@PathVariable Long id,@RequestBody Student student){
        return collegeService.addstudents(id,student,userRepo);
    }

    // Update Student By id
    @PutMapping("/students/{id}")
    public boolean upDataStudents(@PathVariable long id,@RequestBody Student st){
       return studentService.upDataStudents(id,st,studentRep);
    }
    // Delete Student By id
    @DeleteMapping("/students/{studentsId}")
    public boolean deleteStudentId(@PathVariable Long studentsId){
        return studentService.deleteStudentId(studentsId,studentRep);
    }

    // Delete College By id
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id){
        return collegeService.deleteById(id,userRepo);
    }

}
