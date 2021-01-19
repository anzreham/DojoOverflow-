package com.rhm.demo.models;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="tags_questions")
public class TagQuestion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tag_id")
    private Tag tag;

    public TagQuestion() {
    }

    public TagQuestion(Long id, Question question, Tag tag) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.question = question;
        this.tag = tag;
    }

    public TagQuestion( Question question, Tag tag) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.question = question;
        this.tag = tag;
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
