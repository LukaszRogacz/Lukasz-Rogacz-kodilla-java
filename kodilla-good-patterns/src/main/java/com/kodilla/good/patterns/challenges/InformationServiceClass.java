package com.kodilla.good.patterns.challenges;

public class InformationServiceClass implements InformationService{
    @Override
    public void inform(User user,Item item){
        System.out.println("Hello "+user.getUserName()+". You have just bought: "+item.getItemName());
    }
}
