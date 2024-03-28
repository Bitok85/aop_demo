package org.aop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Comment {

    private String comment;
    private String username;

    public Comment(String comment, String username) {
        this.comment = comment;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Comment{comment=%s, userName=%s}".formatted(comment, username);
    }

}
