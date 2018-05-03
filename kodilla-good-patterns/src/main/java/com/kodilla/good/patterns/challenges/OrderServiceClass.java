package com.kodilla.good.patterns.challenges;

public class OrderServiceClass implements OrderService{
    @Override
    public boolean order(User user,Item item){
        System.out.println("User ID: "+user.getUserID()+" is ordering Item ID: "+item.getItemID());
        return true;
    }
}
