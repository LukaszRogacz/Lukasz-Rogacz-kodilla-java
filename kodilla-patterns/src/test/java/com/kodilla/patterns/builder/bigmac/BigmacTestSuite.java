package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigMac(){
        //Given
        Bigmac bigmac=new Bigmac.BigmacBuilder()
                .bun(Bigmac.BigmacBuilder.WITH_SESAME)
                .burgers(3)
                .sauce(Bigmac.BigmacBuilder.BBQ)
                .ingredient(Bigmac.BigmacBuilder.ONION)
                .ingredient(Bigmac.BigmacBuilder.LETTUCE)
                .build();
        System.out.println(bigmac);
        //When
        String bunName=bigmac.getBun();
        String sauceName=bigmac.getSauce();
        int burgersNumber=bigmac.getBurgers();
        int ingredientsNumber=bigmac.getIngredients().size();
        //Then
        Assert.assertEquals("with sesame",bunName);
        Assert.assertEquals("BBQ",sauceName);
        Assert.assertEquals(3,burgersNumber);
        Assert.assertEquals(2,ingredientsNumber);

    }
}
