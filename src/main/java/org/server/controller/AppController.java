package org.server.controller;

import org.server.services.AppService;
import org.server.view.AppView;

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
