package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {
    public OrderRequest retrieve(){
        User user=new User( 123456,"John","Smith","blackeye");
        Item item=new Item(9876,"sock","such a nice sock");
        return new OrderRequest(user,item);
    }
}
