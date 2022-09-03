package dao.documentDao;

import dao.CrudHib;
import model.ProductMovement;

import java.util.List;

public interface ProductMovementDao extends CrudHib<ProductMovement, Integer> {
    List<ProductMovement> findAll();
    ProductMovement findById(Integer id);
}
