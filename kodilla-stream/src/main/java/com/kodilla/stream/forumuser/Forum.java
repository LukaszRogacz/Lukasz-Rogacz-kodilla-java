package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumUserList=new ArrayList<>();

    public Forum(){
        theForumUserList.add(new ForumUser(1,"badguy",'M',LocalDate.of(2000,1,23),23));
        theForumUserList.add(new ForumUser(2,"niceguy",'M',LocalDate.of(1997,3,11),5));
        theForumUserList.add(new ForumUser(3,"niceguy2",'M',LocalDate.of(1997,3,11),0));
        theForumUserList.add(new ForumUser(4,"badgirl",'F',LocalDate.of(2002,5,29),123));
        theForumUserList.add(new ForumUser(5,"nicegirl",'F',LocalDate.of(1990,11,14),53));
        theForumUserList.add(new ForumUser(6,"niceguy3",'M',LocalDate.of(1998,4,24),5));
    }

    public List<ForumUser> getUserList(){
        return new ArrayList<>(theForumUserList);
    }
}
