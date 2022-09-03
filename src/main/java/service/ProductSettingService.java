package service;
import dao.ProductSettingDaoImpl;
import lombok.Data;
import model.ProductSetting;

import java.util.List;

@Data
public class ProductSettingService {
    public static  ProductSettingDaoImpl productSettingDao;

    public ProductSettingService() {
         productSettingDao = new ProductSettingDaoImpl();
    }

    public void save(ProductSetting productSetting) {
     getProduct().openCurrentSession();
     getProduct().save(productSetting);
     getProduct().closeCurrentSession();
    }
    public void update(ProductSetting productSetting) {
        getProduct().openCurrentSession();
        getProduct().update(productSetting);
        getProduct().closeCurrentSession();
    }
    public void delete(Integer id) {
        getProduct().openCurrentSession();
        ProductSetting product = getProduct().findById(id);
        getProduct().delete(product);
        getProduct().closeCurrentSession();
    }
    public ProductSetting findById(Integer id) {
        getProduct().openReadSession();
        ProductSetting product = getProduct().findById(id);
        getProduct().closeReadSession();
        return product;
    }
    public List<ProductSetting> findAll() {
        getProduct().openReadSession();
        List<ProductSetting> products = getProduct().findAll();
        getProduct().closeReadSession();
        return products;
    }
  public ProductSettingDaoImpl getProduct() {
        return productSettingDao;
  }


}
