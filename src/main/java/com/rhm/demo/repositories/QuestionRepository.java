package com.rhm.demo.repositories;

import java.util.List;

import com.rhm.demo.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    public List<Question> findAll();

}