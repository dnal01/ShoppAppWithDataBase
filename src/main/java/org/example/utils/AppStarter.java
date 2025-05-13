package org.example.utils;

import org.example.controller.AppController;
import org.example.services.AppService;
import org.example.view.AppView;

public class AppStarter {
    public static void startApp() {
        AppService service = new AppService();
        AppView view = new AppView();
        AppController controller = new AppController(view, service);
        controller.runApp();
    }
}
