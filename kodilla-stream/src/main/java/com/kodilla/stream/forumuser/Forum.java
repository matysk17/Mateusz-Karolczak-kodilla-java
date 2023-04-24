package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        forumUserList.add(new ForumUser(1, "Batman", 'M', LocalDate.of(2003, Month.DECEMBER, 5),10));
        forumUserList.add(new ForumUser(2, "Spiderman", 'M', LocalDate.of(2008, Month.OCTOBER, 22),0));
        forumUserList.add(new ForumUser(3, "Thor", 'M', LocalDate.of(1998, Month.DECEMBER, 30),5));
        forumUserList.add(new ForumUser(4, "Catwomen", 'F', LocalDate.of(1969, Month.APRIL, 25),2));
        forumUserList.add(new ForumUser(5, "Marshall", 'M', LocalDate.of(1994, Month.NOVEMBER, 16),7));
        forumUserList.add(new ForumUser(6, "Rocky", 'M', LocalDate.of(2001, Month.SEPTEMBER, 17),0));
        forumUserList.add(new ForumUser(7, "Rubble", 'M', LocalDate.of(1989, Month.MAY, 25),0));
        forumUserList.add(new ForumUser(8, "Sky", 'F', LocalDate.of(1980, Month.JULY, 3),3));
        forumUserList.add(new ForumUser(9, "Chase", 'M', LocalDate.of(1981, Month.SEPTEMBER, 14),4));
        forumUserList.add(new ForumUser(10, "Nala", 'F', LocalDate.of(1991, Month.OCTOBER, 9),8));
    }

    public List<ForumUser> getForumUserList() {
        return new ArrayList<>(forumUserList);
    }
}