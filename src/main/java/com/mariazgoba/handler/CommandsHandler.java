package com.mariazgoba.handler;

public abstract class CommandsHandler {

    CommandsHandler next;

    public CommandsHandler getNext() {
        return this.next;
    }

    public void setNext(CommandsHandler next) {
        this.next = next;
    }

    public abstract void handleRequest(String inputs);

}
