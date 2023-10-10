package com.springWeb.WebApplication.Service;

import com.springWeb.WebApplication.Entity.College;
import com.springWeb.WebApplication.Entity.Student;
import com.springWeb.WebApplication.Repositry.CollegeRep;
import com.springWeb.WebApplication.Repositry.StudentRep;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class CollegeService {
    public List<College> getUsers(CollegeRep userRepo){
        System.out.println("Get Method");
        java.util.List<com.springWeb.WebApplication.Entity.College> colleges=userRepo.findAll();
        return colleges;
    }
    public College getById( Long id, CollegeRep userRepo){
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

    public List<Student> getStudentById( Long id,CollegeRep userRepo){
        Optional<College> college=userRepo.findById(id);
        College college1=college.get();
        return college1.getStudents();
    }

    public College addData( College clg,CollegeRep userRepo){
        List<Student> studentList=clg.getStudents();
        for(int i=0;i<studentList.size();i++){
            studentList.get(i).setCollege(clg);
        }
        userRepo.save(clg);
        return clg;
    }

    public College UpdateCollege( long id,@RequestBody College clg,CollegeRep userRepo){
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

    public Student addstudents(Long id, Student student, CollegeRep userRepo, StudentRep studentRep){
        try {
            Optional<College> optionalCollege = userRepo.findById(id);
            College college=optionalCollege.get();
            student.setCollege(college);
            college.getStudents().add(student);

            Student temp=studentRep.save(student);
            userRepo.save(college);
            return temp;
        }
        catch (Exception e){
            return null;
        }
    }

    public College deleteById( Long id,CollegeRep userRepo){
        try {
            Optional<College> collegeOptional= userRepo.findById(id);
            College college=collegeOptional.get();
            userRepo.deleteById(id);
            return college;
        }
        catch (Exception e){
            return null;
        }
    }
}