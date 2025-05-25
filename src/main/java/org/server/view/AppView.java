package org.server.view;

import org.server.entities.Menu;
import org.server.utils.AppStarter;
import org.server.utils.ErrorMessage;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class AppView {
    public int getOption() {
        showMenu();
        System.out.println("Enter your option: ");
        Scanner sc = new Scanner(System.in);
        int option = 0;
        try {
            option = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(ErrorMessage.INCORRECT_VALUE_MSG.getMessage());
            AppStarter.startApp();
        }
        return option;
    }

    public void getOutput(String message) {
        if (message.equals("0")) {
            System.out.println(ErrorMessage.APP_CLOSE_MSG.getMessage());
            System.exit(0);
        } else System.out.println(message);
    }

    public void showMenu() {
        Map<Integer, String> menu = new Menu().getMenu();
        menu.forEach((key, value) -> System.out.println(key + ". " + value));
    }
}
