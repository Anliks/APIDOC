package dao.documentDao;

import dao.CrudHib;
import model.SaleOfProduct;

import java.util.List;

public interface SaleOfProductDao extends CrudHib<SaleOfProduct, Integer> {
    List<SaleOfProduct> findAll();
    SaleOfProduct findById(Integer id);
}
