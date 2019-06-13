package com.xjy.cat.kits;

import java.util.UUID;

public class AccessTokenKit {

    public static String getToken() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
