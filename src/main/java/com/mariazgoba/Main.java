package com.mariazgoba;

import com.mariazgoba.enums.CommandEnums;
import com.mariazgoba.handler.CommandsHandler;
import com.mariazgoba.handler.impl.AddHandler;
import com.mariazgoba.handler.impl.ClearHandler;
import com.mariazgoba.handler.impl.ListHandler;
import com.mariazgoba.handler.impl.TotalHandler;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CommandsHandler chain = setUpChain();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please, enter some command:");
            String input = scanner.nextLine();

            if (input.startsWith(CommandEnums.ADD.getCommand()) || input.startsWith(CommandEnums.CLEAR.getCommand())
                    || input.startsWith(CommandEnums.TOTAL.getCommand()) || input.startsWith(CommandEnums.LIST.getCommand())) {
                chain.handleRequest(input);
                System.out.println("Do you want to continue? yes/no");
                if (scanner.nextLine().equals("no")) {
                    break;
                }
            } else {
                System.out.println("ERROR! Unknown command! \n Please, choose one command from list \n" +
                        "- add YYYY-MM-DD price currency name\n" +
                        "- clear YYYY-MM-DD \n" +
                        "- list \n" +
                        "- total currency");
            }
        }
    }

    private static CommandsHandler setUpChain() {
        CommandsHandler addHandler = new AddHandler();
        CommandsHandler clearHandler = new ClearHandler();
        CommandsHandler listHandler = new ListHandler();
        CommandsHandler totalHandler = new TotalHandler();

        addHandler.setNext(clearHandler);
        clearHandler.setNext(listHandler);
        listHandler.setNext(totalHandler);
        return addHandler;
    }

}
