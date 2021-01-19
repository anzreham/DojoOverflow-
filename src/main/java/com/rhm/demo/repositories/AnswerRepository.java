package com.rhm.demo.repositories;
import java.util.List;

import com.rhm.demo.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    public List<Answer> findAll();
}