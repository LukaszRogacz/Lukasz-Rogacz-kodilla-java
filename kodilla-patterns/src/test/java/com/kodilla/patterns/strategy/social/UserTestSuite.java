package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies(){
        //Given
        User user1=new Millenials("John Smith");
        User user2=new YGeneration("Kate Nova");
        User user3=new ZGeneration("Peter Kovalsky");
        //When
        String usingFacebook=user1.sharePost();
        String usingTwitter=user2.sharePost();
        String usingSnapchat=user3.sharePost();
        //Then
        Assert.assertEquals("Using Facebook",usingFacebook);
        Assert.assertEquals("Using Twitter",usingTwitter);
        Assert.assertEquals("Using Snapchat",usingSnapchat);
    }

    @Test
    public void testIndividualSharingStrategy(){
        //Given
        User user1=new Millenials("John Smith");
        //When
        user1.setSocialPublisher(new SnapchatPublisher());
        String usingSnapchat=user1.sharePost();
        //Then
        Assert.assertEquals("Using Snapchat",usingSnapchat);
    }
}
