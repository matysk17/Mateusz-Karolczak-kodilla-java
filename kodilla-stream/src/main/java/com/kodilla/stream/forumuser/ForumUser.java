package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int IDNumber;
    private String name;
    private char sex;
    private LocalDate birthdayDate;
    private int postsQty;

    public ForumUser(int IDNumber, String name, char sex, LocalDate birthdayDate, int postsQty) {
        this.IDNumber = IDNumber;
        this.name = name;
        this.sex = sex;
        this.birthdayDate = birthdayDate;
        this.postsQty = postsQty;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public int getPostsQty() {
        return postsQty;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "IDNumber=" + IDNumber +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthdayDate=" + birthdayDate +
                ", postsQty=" + postsQty +
                '}';
    }
}