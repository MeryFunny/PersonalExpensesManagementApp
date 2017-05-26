package com.mariazgoba.enums;

/**
 * Created by Maria Zgoba on 24.05.2017.
 */
public enum CommandEnums {
    ADD("add"),
    CLEAR("clear"),
    LIST("list"),
    TOTAL("total");

    private String command;

    CommandEnums(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
