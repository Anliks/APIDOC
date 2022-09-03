package service;

import dao.ProductMovementDaoImpl;
import lombok.Data;
import model.ProductMovement;

import java.util.List;

@Data
public class ProductMovementService {
    private ProductMovementDaoImpl product;

    public ProductMovementService() {
        product = new ProductMovementDaoImpl();
    }
    public void save(ProductMovement movement) {
        getProduct().openCurrentSession();
        getProduct().save(movement);
        getProduct().closeCurrentSession();
    }
    public void update(ProductMovement movement) {
        getProduct().openCurrentSession();
        getProduct().update(movement);
        getProduct().closeCurrentSession();
    }
    public void delete(Integer id) {
        getProduct().openCurrentSession();
        ProductMovement product = getProduct().findById(id);
        getProduct().delete(product);
        getProduct().closeCurrentSession();
    }
    public List<ProductMovement> findAll() {
        getProduct().openReadSession();
        List<ProductMovement> products = getProduct().findAll();
        getProduct().closeReadSession();
        return products;
    }
    public ProductMovement findById(Integer id) {
        getProduct().openReadSession();
        ProductMovement  product = getProduct().findById(id);
        getProduct().closeReadSession();
        return product;
    }
}
