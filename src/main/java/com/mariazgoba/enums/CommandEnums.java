package com.mariazgoba.enums;

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
