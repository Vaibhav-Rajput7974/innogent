package com.springWeb.WebApplication.Controler;

import com.springWeb.WebApplication.Configration.CustomeUserDetailService;
import com.springWeb.WebApplication.Entity.College;
import com.springWeb.WebApplication.Entity.Student;
import com.springWeb.WebApplication.Entity.Users;
import com.springWeb.WebApplication.Repositry.CollegeRep;
import com.springWeb.WebApplication.Repositry.StudentRep;
import com.springWeb.WebApplication.Repositry.UsersRep;
import com.springWeb.WebApplication.Service.CollegeService;
import com.springWeb.WebApplication.Service.JwtUtil;
import com.springWeb.WebApplication.Service.StudentService;
import com.springWeb.WebApplication.Service.UserService;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    UsersRep usersRep;
    @Autowired
    CollegeService collegeService;

    @Autowired
    StudentService studentService;

    @Autowired
    UserService userService;

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

    @Autowired
    CustomeUserDetailService customeUserDetailService;

    @Autowired
    JwtUtil jwtUtil;
//    @Autowired
//    AuthenticationManager manager;

    @GetMapping("/login")
    public String getAllUsers(@RequestBody Users users){
//        doAuthenticate(users.getEmail(), users.getPassword());
        UserDetails userDetails= customeUserDetailService.loadUserByUsername(users.getEmail());
        String token=jwtUtil.generateToken(userDetails);
        System.out.println("token "+ token);
        return token;
    }

//    private void doAuthenticate(String email, String password) {
//
//        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
//        try {
//            manager.authenticate(authentication);
//
//        } catch (BadCredentialsException e) {
//            throw new BadCredentialsException(" Invalid Username or Password  !!");
//        }
//
//    }
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Users addUsers(@RequestBody Users users){
        return userService.createUser(users);
    }



    // Update College By college Id
    @PutMapping("/{id}")
    public College Update(@PathVariable long id,@RequestBody College clg){
        return  collegeService.UpdateCollege(id,clg,userRepo);
    }

    // Add Student to particular College
    @PostMapping("/{id}/students")
    public Student addstudents(@PathVariable Long id,@RequestBody Student student){
        return collegeService.addstudents(id,student,userRepo,studentRep);
    }

    // Update Student By id
    @PutMapping("/students/{id}")
    public Student upDataStudents(@PathVariable long id,@RequestBody Student st){
       return studentService.upDataStudents(id,st,studentRep);
    }
    // Delete Student By id
    @DeleteMapping("/students/{studentsId}")
    public Student deleteStudentId(@PathVariable Long studentsId){
        return studentService.deleteStudentId(studentsId,studentRep);
    }

    // Delete College By id
    @DeleteMapping("/{id}")
    public College deleteById(@PathVariable Long id){
        return collegeService.deleteById(id,userRepo);
    }

}
