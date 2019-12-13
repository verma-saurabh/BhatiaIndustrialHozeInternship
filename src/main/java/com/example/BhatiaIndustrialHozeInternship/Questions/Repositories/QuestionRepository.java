package com.example.BhatiaIndustrialHozeInternship.Questions.Repositories;

import com.example.BhatiaIndustrialHozeInternship.Questions.Entity.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Query(value = "Select * From Question", nativeQuery = true)
    List<Question> findAll();

    @Query(value = "Select * From Question where TAG=?1", nativeQuery = true)
    List<Question> findByTag(String tag);

    List<Question> findById(long id);


}
