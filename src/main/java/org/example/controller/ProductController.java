package org.example.controller;

import org.example.services.ProductService;
import org.example.utils.AppStarter;
import org.example.view.ProductCreateView;
import org.example.view.ProductDeleteView;
import org.example.view.ProductReadByIdView;
import org.example.view.ProductUpdateView;

public class ProductController {
    ProductService service = new ProductService();

    public void add() {
        ProductCreateView view = new ProductCreateView();
        view.getOutput(service.add(view.getData()));
        AppStarter.startApp();
    }

    public void read() {
        ProductDeleteView view = new ProductDeleteView();
        view.getOutput(service.read());
        AppStarter.startApp();
    }
    public void readById() {
        ProductReadByIdView view = new ProductReadByIdView();
        view.getOutput(service.readById(view.getData()));
        AppStarter.startApp();
    }
    public void update() {
        ProductUpdateView view = new ProductUpdateView();
        view.getOutput(service.update(view.getData()));
        AppStarter.startApp();
    }
    public void delete() {
        ProductDeleteView view = new ProductDeleteView();
        view.getOutput(service.delete(view.getData()));
        AppStarter.startApp();
    }
}
