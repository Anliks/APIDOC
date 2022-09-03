package dao;

import HibernateSet.HibernateSet;
import dao.documentDao.DocumentSettingDao;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.ProductSetting;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;
@Data
@NoArgsConstructor
public class ProductSettingDaoImpl implements DocumentSettingDao {

    private Transaction transaction;
    private Session currentSession;

    public Session openReadSession() {
        currentSession = HibernateSet.getSessionFactory().openSession();
        return currentSession;
    }
    public void closeReadSession() {
        currentSession.close();
    }

    public Session openCurrentSession() {
        currentSession = HibernateSet.getSessionFactory().openSession();
        transaction = currentSession.beginTransaction();
        return currentSession;
    }
    public void closeCurrentSession() {
        transaction.commit();
        currentSession.close();
    }


    @Override
    public void save(ProductSetting model) {
        getCurrentSession().save(model);
    }

    @Override
    public void update(ProductSetting model) {
     getCurrentSession().update(model);
    }

    @Override
    public void delete(ProductSetting model) {
      getCurrentSession().delete(model);
    }

    @Override
    public ProductSetting read(Integer modelId) {
      ProductSetting product = getCurrentSession().get(ProductSetting.class, modelId);
      if(product != null) {
          Hibernate.initialize(product.getProductsListId());
          Hibernate.initialize(product.getNumberId());
          Hibernate.initialize(product.getStoreId());
      }
      return product;
    }

    @Override
    public List<ProductSetting> findAll() {
        List<ProductSetting> products = (List<ProductSetting>) getCurrentSession().createQuery("from ProductSetting").list();
        return products;
    }

    @Override
    public ProductSetting findById(Integer id) {
        ProductSetting product = getCurrentSession().get(ProductSetting.class, id);
        return product;
    }
}
