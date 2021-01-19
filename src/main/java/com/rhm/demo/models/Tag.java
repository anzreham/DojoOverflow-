package com.rhm.demo.models;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
// ..
// ..
// ..
@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tags_questions",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;

    public Tag() {
    }

    public Tag(Long id, String subject, List<Question> questions) {
        this.id = id;
        this.subject = subject;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.questions = questions;
    }


    public Tag(String subject,  List<Question> questions) {
        this.id = id;
        this.subject = subject;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.questions = questions;
    }

    public Tag(String subject) {
       this.subject = subject;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
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
