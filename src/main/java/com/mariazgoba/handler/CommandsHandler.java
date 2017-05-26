package com.mariazgoba.handler;

import java.util.List;

/**
 * Created by Maria Zgoba on 24.05.2017.
 */
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
