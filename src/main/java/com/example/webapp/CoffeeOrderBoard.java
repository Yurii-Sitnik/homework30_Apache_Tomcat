package com.example.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeOrderBoard {

    private final List<Order> orderList = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    public void add(Order order) {

        if (orderList.contains(order) || order.getNumberOrder() == 0) {
            log.error("You entered an invalid numId"+order.getNumberOrder());
            throw new IllegalArgumentException("Wrong ! You entered an invalid numId.");
        }

        try {
            orderList.add(order);
            log.info("order added" + order);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            log.error("incorrect order" + order.getNumberOrder() + order.getPeopleName());
        }
        Collections.sort(orderList);
    }

    public void deliver() {
        orderList.remove(0);
    }

    public void deliver(Integer num) {
        for (Order order : orderList) {
            if (order.getNumberOrder() == num) {
                orderList.remove(order);
                log.info("order removed " + order.getNumberOrder() + " " + order.getPeopleName());
                break;
            }
        }
    }

    public void draw() {
        String showTitle = "ID | Client\n";
        StringBuilder stringBuilder = new StringBuilder();
        for (Order order : orderList) {
            stringBuilder.append("\n").append(order);
        }
        log.info("logger" + showTitle + stringBuilder);
        System.out.println(showTitle + stringBuilder);
    }
}










