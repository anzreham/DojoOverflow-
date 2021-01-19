package com.rhm.demo.models;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
// ...

@Entity
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="question", fetch=FetchType.LAZY)
    private List<Answer> answers;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tags_questions",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )

    private List<Tag> tags;


    public Question() {

    }
    public Question(String question, List<Tag> tags) {
        this.question = question;
        this.tags = tags;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PostPersist
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}



//
//    public Question(Long id, String question,  List<Tag> tags) {
//        this.id = id;
//        this.question = question;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.tags = tags;
//    }
//
//    public Question(String question, List<Tag> tags) {
//        this.id = id;
//        this.question = question;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.tags = tags;
//    }