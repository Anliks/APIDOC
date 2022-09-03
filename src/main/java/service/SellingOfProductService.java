package service;

import dao.SaleOfProductDaoImpl;
import lombok.Data;
import model.SaleOfProduct;

import java.util.List;

@Data
public class SellingOfProductService {
    private SaleOfProductDaoImpl saleOfProductDao;

    public SellingOfProductService() {
        saleOfProductDao = new SaleOfProductDaoImpl();
    }
    public void save(SaleOfProduct product) {
      getSaleOfProductDao().openCurrentSession();
      getSaleOfProductDao().save(product);
      getSaleOfProductDao().closeCurrentSession();
    }
    public void update(SaleOfProduct product) {
        getSaleOfProductDao().openCurrentSession();
        getSaleOfProductDao().update(product);
        getSaleOfProductDao().closeCurrentSession();
    }
    public void delete(Integer id) {
        getSaleOfProductDao().openCurrentSession();
        SaleOfProduct product = getSaleOfProductDao().findById(id);
        getSaleOfProductDao().delete(product);
        getSaleOfProductDao().closeCurrentSession();
    }
    public SaleOfProduct findById(Integer id) {
        getSaleOfProductDao().openReadSession();
        SaleOfProduct product = getSaleOfProductDao().findById(id);
        getSaleOfProductDao().closeReadSession();
        return product;
    }
    public List<SaleOfProduct> findAll() {
        getSaleOfProductDao().openReadSession();
        List<SaleOfProduct> products = getSaleOfProductDao().findAll();
        getSaleOfProductDao().closeReadSession();
        return products;
    }
}


