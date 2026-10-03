package com.example.demo.Repository;

import com.example.demo.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {


    long deleteByName(String name);

    @Query("SELECT s FROM StudentEntity s WHERE s.course = :course AND s.age >= :minAge ORDER BY s.name")
    List<StudentEntity> findByCourseAndMinAge(@Param("course") String course, @Param("minAge") Integer minAge);
}
