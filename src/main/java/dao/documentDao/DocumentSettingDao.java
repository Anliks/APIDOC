package dao.documentDao;

import dao.CrudHib;
import model.ProductSetting;

import java.util.List;

public interface DocumentSettingDao extends CrudHib<ProductSetting, Integer> {
    List<ProductSetting> findAll();
    ProductSetting findById(Integer id);
}
