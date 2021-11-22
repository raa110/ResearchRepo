package com.sample.factory.abstractTest;

public class Student extends User {

    public String type = "STUDENT";

    @Override
    public String getUniqueId(final String name) throws ApplicationError {
        if (name == null) {
            throw new ApplicationError("Name is null");
        }
        return type + "_" + super.getUniqueId(name);
    }

    @Override
    public String privilege() {
        return "CLASS_ROOM";
    }
}
