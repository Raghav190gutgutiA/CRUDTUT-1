package com.example.demo.utils;

import com.example.demo.DTP.StudentDto;
import com.example.demo.Entity.StudentEntity;

public class Mapping {

    public static StudentEntity dtoToEntity(StudentDto dto) {
        if (dto == null) {
            return null;
        }
        StudentEntity entity = new StudentEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAge(dto.getAge());
        entity.setCourse(dto.getCourse());
        return entity;
    }

    public static StudentDto entityToDto(StudentEntity entity) {
        if (entity == null) {
            return null;
        }
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setAge(entity.getAge());
        dto.setCourse(entity.getCourse());
        return dto;
    }
}
