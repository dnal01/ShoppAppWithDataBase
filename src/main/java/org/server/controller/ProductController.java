package org.server.controller;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.server.services.ProductService;
import org.server.utils.AppStarter;
import org.server.view.*;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
    ProductService service = new ProductService();

    public void add() {
        ProductCreateView view = new ProductCreateView();
        view.getOutput(service.add(view.getData()));
        AppStarter.startApp();
    }

    public void read() {
        ProductReadView view = new ProductReadView();
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
