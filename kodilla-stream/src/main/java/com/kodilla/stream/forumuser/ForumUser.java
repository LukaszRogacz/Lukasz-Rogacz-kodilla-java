package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int forumUserID;
    private final String username;
    private final char sex;
    private final LocalDate birthDate;
    private final int postQuantity;

    public ForumUser(final int forumUserID, final String username, final char sex, final LocalDate birthDate, final int postQuantity) {
        this.forumUserID = forumUserID;
        this.username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postQuantity = postQuantity;
    }

    public int getForumUserID() {
        return forumUserID;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostQuantity() {
        return postQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "forumUserID=" + forumUserID +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postQuantity=" + postQuantity +
                '}';
    }
}
