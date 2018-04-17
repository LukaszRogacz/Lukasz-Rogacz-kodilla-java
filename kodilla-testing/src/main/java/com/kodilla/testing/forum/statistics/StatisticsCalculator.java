package com.kodilla.testing.forum.statistics;

import java.util.List;

public class StatisticsCalculator {

    private int userQuantity = 0;
    private int postQuantity = 0;
    private int commentQuantity = 0;
    private double averagePostsPerUser = 0;
    private double averageCommentsPerUser = 0;
    private double averageCommentsPerPost = 0;

    public int getUserQuantity() {
        return userQuantity;
    }

    public int getPostQuantity() {
        return postQuantity;
    }

    public int getCommentQuantity() {
        return commentQuantity;
    }

    public void calculateAdvStatistics(Statistics statistics) {

        userQuantity = statistics.usersNames().size();
        postQuantity = statistics.postsCount();
        commentQuantity = statistics.commentsCount();
        if (userQuantity > 0) {
            averagePostsPerUser = postQuantity / userQuantity;
        } else {
            System.out.println("User Quantity is 0. Statistics referring to it will be wrongly presented");
        }
        if (userQuantity > 0) {
            averageCommentsPerUser = commentQuantity / userQuantity;
        } else {
            System.out.println("User Quantity is 0. Statistics referring to it will be wrongly presented");
        }
        if (postQuantity > 0) {
            averageCommentsPerPost = commentQuantity / postQuantity;
        } else {
            System.out.println("Post Quantity is 0. Statistics referring to it will be wrongly presented");
        }

    }

    public void showStatistics() {
        System.out.println("User quantity=" + userQuantity);
        System.out.println("Post quantity=" + postQuantity);
        System.out.println("Comment quantity=" + commentQuantity);
        System.out.println("Average posts per user=" + averagePostsPerUser);
        System.out.println("Average comments per user=" + averageCommentsPerUser);
        System.out.println("Average comments per post=" + averageCommentsPerPost);
    }

}
