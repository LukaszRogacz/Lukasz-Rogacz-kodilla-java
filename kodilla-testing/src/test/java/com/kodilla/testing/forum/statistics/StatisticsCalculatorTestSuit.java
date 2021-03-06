package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsCalculatorTestSuit {

    @Test
    public void testCalculateAdvStatistics0Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculator myStatsCalculator = new StatisticsCalculator();
        List<String> userListMock = new ArrayList<String>();

        userListMock.add("niceguy");
        userListMock.add("badguy");
        userListMock.add("badgirl");

        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(userListMock);

        //When
        myStatsCalculator.calculateAdvStatistics(statisticsMock);
        myStatsCalculator.showStatistics();
        int result = myStatsCalculator.getPostQuantity();
        //Then
        Assert.assertEquals(0, result);

    }
    @Test
    public void testCalculateAdvStatistics1000Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculator myStatsCalculator = new StatisticsCalculator();
        List<String> userListMock = new ArrayList<String>();

        userListMock.add("niceguy");
        userListMock.add("badguy");
        userListMock.add("badgirl");

        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.usersNames()).thenReturn(userListMock);

        //When
        myStatsCalculator.calculateAdvStatistics(statisticsMock);
        myStatsCalculator.showStatistics();
        int result = myStatsCalculator.getPostQuantity();
        //Then
        Assert.assertEquals(1000, result);

    }

    @Test
    public void testCalculateAdvStatistics0Comments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculator myStatsCalculator = new StatisticsCalculator();
        List<String> userListMock = new ArrayList<String>();

        userListMock.add("niceguy");
        userListMock.add("badguy");
        userListMock.add("badgirl");

        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(userListMock);

        //When
        myStatsCalculator.calculateAdvStatistics(statisticsMock);
        myStatsCalculator.showStatistics();
        int result = myStatsCalculator.getCommentQuantity();
        //Then
        Assert.assertEquals(0, result);

    }
    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculator myStatsCalculator = new StatisticsCalculator();
        List<String> userListMock = new ArrayList<String>();

        userListMock.add("niceguy");
        userListMock.add("badguy");
        userListMock.add("badgirl");

        when(statisticsMock.commentsCount()).thenReturn(2000);
        when(statisticsMock.postsCount()).thenReturn(1000);

        when(statisticsMock.usersNames()).thenReturn(userListMock);

        //When
        myStatsCalculator.calculateAdvStatistics(statisticsMock);
        myStatsCalculator.showStatistics();
        int resultComment = myStatsCalculator.getCommentQuantity();
        int resultPost = myStatsCalculator.getPostQuantity();
        boolean moreComments;
        if((resultPost==1000)&&(resultComment==2000)){
            moreComments=true;
        }else{
            moreComments=false;
        }
        //Then
        Assert.assertTrue(moreComments);

    }
    @Test
    public void testCalculateAdvStatisticsMorePostsThanComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculator myStatsCalculator = new StatisticsCalculator();
        List<String> userListMock = new ArrayList<String>();

        userListMock.add("niceguy");
        userListMock.add("badguy");
        userListMock.add("badgirl");

        when(statisticsMock.commentsCount()).thenReturn(1000);
        when(statisticsMock.postsCount()).thenReturn(2000);

        when(statisticsMock.usersNames()).thenReturn(userListMock);

        //When
        myStatsCalculator.calculateAdvStatistics(statisticsMock);
        myStatsCalculator.showStatistics();
        int resultComment = myStatsCalculator.getCommentQuantity();
        int resultPost = myStatsCalculator.getPostQuantity();
        boolean morePosts;
        if((resultComment==1000) && (resultPost==2000)){
            morePosts=true;
        }else{
            morePosts=false;
        }
        //Then
        Assert.assertTrue(morePosts);

    }


    @Test
    public void testCalculateAdvStatistics0Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculator myStatsCalculator = new StatisticsCalculator();
        List<String> userListMock = new ArrayList<String>();


        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(userListMock);

        //When
        myStatsCalculator.calculateAdvStatistics(statisticsMock);
        myStatsCalculator.showStatistics();
        int result = myStatsCalculator.getUserQuantity();
        //Then
        Assert.assertEquals(0, result);

    }

    @Test
    public void testCalculateAdvStatistics100Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculator myStatsCalculator = new StatisticsCalculator();
        List<String> userListMock = new ArrayList<String>();

        for(int i=0;i<100;i++){
            userListMock.add("random user");
        }

        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(userListMock);

        //When
        myStatsCalculator.calculateAdvStatistics(statisticsMock);
        myStatsCalculator.showStatistics();
        int result = myStatsCalculator.getUserQuantity();
        //Then
        Assert.assertEquals(100, result);

    }

}
