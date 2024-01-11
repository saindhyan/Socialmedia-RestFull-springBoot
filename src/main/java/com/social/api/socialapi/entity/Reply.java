package com.social.api.socialapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private String user;


    @Column(name = "replyText")
    private String ReplyText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Comment comment;



    public Reply() {
    }

    public Reply(Integer id, String user, String replyText, Comment comment) {
        this.id = id;
        this.user = user;
        ReplyText = replyText;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getReplyText() {
        return ReplyText;
    }

    public void setReplyText(String replyText) {
        ReplyText = replyText;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", ReplyText='" + ReplyText + '\'' +
                ", comment=" + comment +
                '}';
    }
}
