package com.sample.factory.abstractTest;

public class Teacher extends User {

    public String type = "TEACHER";

    @Override
    public String getUniqueId(final String name) throws ApplicationError {
        return "TEACHER_" + super.getUniqueId(name);
    }

    @Override
    public String privilege() {
        return "CLASS_ROOM";
    }

}
