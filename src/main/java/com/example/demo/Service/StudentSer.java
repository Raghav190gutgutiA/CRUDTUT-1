package com.example.demo.Service;

import com.example.demo.DTP.StudentDto;
import com.example.demo.Entity.StudentEntity;
import com.example.demo.Repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.utils.Mapping;

import java.util.List;
import java.util.Optional;

import static com.example.demo.utils.Mapping.dtoToEntity;
import static com.example.demo.utils.Mapping.entityToDto;

@Service
public class StudentSer {
    @Autowired
    public StudentRepo str;
    public String createUser(StudentDto st){

        StudentEntity ste = dtoToEntity(st);
        str.save(ste);
        return "Done";
    }

    public StudentDto getUser(Long id)
    {
       Optional<StudentEntity> ste = str.findById(id);
       return ste.map(Mapping::entityToDto).orElse(null);
    }
    @Transactional
    public String updateUser(Long id, StudentDto dto)
    {
        Optional<StudentEntity> ste = str.findById(id);
        if (ste.isEmpty()) {
            return null;
        }
        StudentEntity ste1 = ste.get();
        if (dto.getName() != null) ste1.setName(dto.getName());
        if (dto.getEmail() != null) ste1.setEmail(dto.getEmail());
        if (dto.getPhone() != null) ste1.setPhone(dto.getPhone());
        if (dto.getAge() != null) ste1.setAge(dto.getAge());
        if (dto.getCourse() != null) ste1.setCourse(dto.getCourse());
//        str.save(ste1);
        return "Done";
    }
    @Transactional
    public String deleteUser(Long id){
        str.deleteById(id);
        return "Done";
    }
    @Transactional
    public String deleteByName(String name){
        str.deleteByName(name);
        return "Done";
    }

    public List<StudentDto> getByCourseAndMinAge(String course, Integer minAge) {
        return str.findByCourseAndMinAge(course, minAge)
                .stream()
                .map(Mapping::entityToDto)
                .toList();
    }
}

