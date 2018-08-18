package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Watcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.kodilla.patterns2.aop.calculator.Watcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(theOrder,theUserId) && target(object)")
    public void logEvent(OrderDto theOrder,Long theUserId,Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Order size: " + theOrder.getItems().size() + "; user: " + theUserId);
    }
}
