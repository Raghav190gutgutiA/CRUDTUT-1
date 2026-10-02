package com.example.demo.Service;

import com.example.demo.DTP.StudentDto;
import com.example.demo.Entity.StudentEntity;
import com.example.demo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.utils.Mapping.dtoToEntity;

@Service
public class StudentSer {
    @Autowired
    public StudentRepo str;
    public String createUser(StudentDto st){

        StudentEntity ste = dtoToEntity(st);
        if(str.save(ste))
        {
            return "Done";
        }
        return "failed";


    }

    public StudentDto getUser(Integer id)
    {
        return str.get(id);
    }
}
