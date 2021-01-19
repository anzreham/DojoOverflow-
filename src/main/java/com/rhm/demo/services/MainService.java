package com.rhm.demo.services;

import com.rhm.demo.models.Answer;
import com.rhm.demo.models.NewQuestion;
import com.rhm.demo.models.Question;
import com.rhm.demo.models.Tag;
import com.rhm.demo.repositories.AnswerRepository;
import com.rhm.demo.repositories.QuestionRepository;
import com.rhm.demo.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
 @Service
public class MainService {

    private final QuestionRepository questionRepository ;
    private final AnswerRepository answerRepository;
    private final TagRepository tagRepository;

    public MainService(QuestionRepository questionRepository, AnswerRepository answerRepository, TagRepository tagRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.tagRepository = tagRepository;
    }
    public List<Question> getQuestions() {
        return this.questionRepository.findAll();
    }
    public Question getQuestion(Long id) {
        return this.questionRepository.findById(id).orElse(null);
    }


    public void createQuestion(NewQuestion question) {
        // TODO: make a real question here
        List<Tag> questionsTags = new ArrayList<Tag>();
        for(String subject: question.splitTags()) {
            System.out.println(subject);
            Tag tag = this.tagRepository.findBySubject(subject).orElse(null);
            System.out.println("after" + " " +tag);

            if(tag == null) {
                tag = new Tag(subject);
                this.tagRepository.save(tag);
            }
            if(!questionsTags.contains(tag))
                questionsTags.add(tag);
        }
        Question newQuestion = new Question(question.getQuestion(), questionsTags);
        this.questionRepository.save(newQuestion);
    }



    public Answer createAnswer(Answer newAnswer) {
        return this.answerRepository.save(newAnswer);
    }



    public Answer getAnswerById(Long id) {
        return this.answerRepository.findById(id).orElse(null);
    }

}
