package com.springWeb.WebApplication.Service;

import com.springWeb.WebApplication.Entity.College;
import com.springWeb.WebApplication.Entity.Student;
import com.springWeb.WebApplication.Repositry.CollegeRep;
import com.springWeb.WebApplication.Repositry.StudentRep;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class StudentService {

    public Student getByStudentId( Long studentid, StudentRep studentRep){
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

    public boolean upDataStudents( long id, Student st,StudentRep studentRep){
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

    public boolean deleteStudentId( Long studentsId,StudentRep studentRep){
        try {
            studentRep.deleteById(studentsId);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
