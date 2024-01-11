package com.social.api.socialapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private String user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Post post;


    @Column(name = "commentText")
    private String comment;

    @OneToMany(mappedBy = "comment")
    private List<Reply> reply;


    public Comment() {
    }

    public Comment(Integer id, String user, Post post, String comment, List<Reply> reply) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.comment = comment;
        this.reply = reply;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Reply> getReply() {
        return reply;
    }

    public void setReply(List<Reply> reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", post=" + post +
                ", comment='" + comment + '\'' +
                ", reply=" + reply +
                '}';
    }
}
