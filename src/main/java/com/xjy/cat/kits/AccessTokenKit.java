package com.xjy.cat.kits;

import com.xjy.cat.DO.LoginDO;

import java.util.UUID;

public class AccessTokenKit {

    public static LoginDO getToken() {
        return new LoginDO().setAccess_token(UUID.randomUUID().toString().replace("-", "").toLowerCase()).setDate(System.currentTimeMillis()).setRandom_id(RandomKit.getInt());
    }

}
