package com.fp.api_client.comments.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Comment {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String body;
    private int postId;
    private int likes;
    private User user;

    public Comment() {}

    // Constructor
    public Comment(int id, String body, int postId, int likes, User user) {
        this.id = id;
        this.body = body;
        this.postId = postId;
        this.likes = likes;
        this.user = user;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", postId=" + postId +
                ", likes=" + likes +
                ", user=" + user +
                '}';
    }
}