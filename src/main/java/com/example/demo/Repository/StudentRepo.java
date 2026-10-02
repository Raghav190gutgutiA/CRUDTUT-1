package com.example.demo.Repository;

import com.example.demo.DTP.StudentDto;
import com.example.demo.Entity.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static com.example.demo.utils.Mapping.entityToDto;

@Repository
public class StudentRepo {
    private final AtomicInteger idCounter = new AtomicInteger(0);

    Map<Integer, StudentEntity> studentDb = new HashMap<>();
    public boolean save(StudentEntity st)
    {

//      studentDto.setId(idCounter.incrementAndGet());

        studentDb.put(idCounter.incrementAndGet(),st);
        return true;
    }

    public StudentDto get( Integer id)
    {
      StudentEntity getStudent = studentDb.get(id);

      StudentDto sta = entityToDto(getStudent);

      return sta;
    }
}
