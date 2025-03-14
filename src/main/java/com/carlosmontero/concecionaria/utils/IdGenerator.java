package com.carlosmontero.concecionaria.utils;

import java.util.Random;

public class IdGenerator {

    public static int generatedID() {
        Random r = new Random();
        return r.nextInt(1000) + 1000;
    }

}
