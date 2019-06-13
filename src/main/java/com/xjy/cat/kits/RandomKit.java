package com.xjy.cat.kits;

import java.util.Random;

public class RandomKit {

    private static final Random random = new Random();

    public static int getInt() {
        return random.nextInt(Integer.MAX_VALUE);
    }

    public static int getInt(int bound) {
        return random.nextInt(bound);
    }

}
