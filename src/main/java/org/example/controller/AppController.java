package org.example.controller;

import org.example.services.AppService;
import org.example.utils.AppStarter;
import org.example.view.AppView;

public class AppController {
    AppView view;
    AppService service;

    public AppController(AppView view, AppService service) {
        this.view = view;
        this.service = service;
    }
    public void runApp() {
        service.handleOption(view.getOption());
    }

}
