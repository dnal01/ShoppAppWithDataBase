package org.server.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.server.dto.ProductDtoDeleteResponse;
import org.server.dto.ProductDtoRequest;
import org.server.entities.Product;
import org.server.services.product.ProductService;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
    @Inject
    ProductService productService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(final ProductDtoRequest request) {
        Product product = productService.create(request);
        return Response
                .ok()
                .entity(product)
                .build();
    }
    @GET
    public Response getAllProducts() {
        List<Product> products = productService.getAll();
        return Response
                .ok()
                .entity(products)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") final Long id) {
        Product product = productService.getById(id);
        return Response
                .ok()
                .entity(product)
                .build();
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") final Long id,
                               final ProductDtoRequest request) {
        Product product = productService.update(id, request);
        return Response
                .ok()
                .entity(product)
                .build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteProductById(@PathParam("id") final Long id) {
        boolean isProductDeleted = productService.deleteById(id);
        return Response
                .ok()
                .entity(ProductDtoDeleteResponse.of(id, isProductDeleted))
                .build();
    }
}
