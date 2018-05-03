package com.kodilla.good.patterns.challenges;

public class OrderRepositoryClass implements OrderRepository{
    @Override
    public void createOrder(User user, Item item) {
        System.out.println("Order is saved in a repository. Item ID: "+item.getItemID()+ ", ordered by user ID: "+user.getUserID());
    }
}
