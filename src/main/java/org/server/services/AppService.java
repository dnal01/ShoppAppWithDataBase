package org.server.services;

import org.server.controller.ProductController;
import org.server.exceptions.OptionException;
import org.server.utils.AppStarter;
import org.server.utils.ErrorMessage;
import org.server.view.AppView;

public class AppService {
    ProductController controller = new ProductController();

    public void handleOption(int option) {
        switch (option) {
            case 1 -> controller.add();
            case 2 -> controller.read();
            case 3 -> controller.readById();
            case 4 -> controller.update();
            case 5 -> controller.delete();
            case 0 -> new AppView().getOutput(Integer.toString(option));
            default -> {
                try {
                    throw new OptionException(ErrorMessage.INCORRECT_OPTION_MSG.getMessage());
                } catch (OptionException e) {
                    new AppView().getOutput(e.getMessage());
                    AppStarter.startApp();
                }
            }
        }
    }
}
