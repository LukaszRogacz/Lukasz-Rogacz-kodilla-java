package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double addValue = calculator.add(6, 3);
        double subValue = calculator.sub(6, 3);
        double mulValue = calculator.mul(6, 3);
        double divValue = calculator.div(6, 3);
        //Then
        Assert.assertEquals(addValue, 9, 0.001);
        Assert.assertEquals(subValue, 3, 0.001);
        Assert.assertEquals(mulValue, 18, 0.001);
        Assert.assertEquals(divValue, 2, 0.001);
    }
}
