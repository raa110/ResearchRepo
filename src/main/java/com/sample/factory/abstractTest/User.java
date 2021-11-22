package com.sample.factory.abstractTest;

import java.util.UUID;

abstract public class User {

    public String type = "DEFAULT";

    public String getUniqueId(final String name) throws ApplicationError {
        return name + "-" + UUID.randomUUID().toString();
    }

    public abstract String privilege();

}
