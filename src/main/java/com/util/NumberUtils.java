package com.util;

import org.springframework.stereotype.Component;

@Component
public class NumberUtils {

    public static int getRandomIntBetweenRange(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return (int)x;
    }

}
