package dao;

import HibernateSet.HibernateSet;
import dao.documentDao.ProductMovementDao;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.ProductMovement;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductMovementDaoImpl implements ProductMovementDao {

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
    public void save(ProductMovement model) {
     getCurrentSession().save(model);
    }

    @Override
    public void update(ProductMovement model) {
     getCurrentSession().update(model);
    }

    @Override
    public void delete(ProductMovement model) {
      getCurrentSession().delete(model);
    }

    @Override
    public ProductMovement read(Integer modelId) {
        final ProductMovement movement = getCurrentSession().get(ProductMovement.class, modelId);
        if(movement!= null) {
            Hibernate.initialize(movement.getProductsListId());
            Hibernate.initialize(movement.getNumberId());
            Hibernate.initialize(movement.getDepartureStoreId());
            Hibernate.initialize(movement.getCatcherStoreId());
        }
        return movement;
    }

    @Override
    public List<ProductMovement> findAll() {
        List<ProductMovement> products = (List<ProductMovement>) getCurrentSession().createQuery("from ProductMovement ").list();
        return products;
    }

    @Override
    public ProductMovement findById(Integer id) {
        return getCurrentSession().get(ProductMovement.class, id);
    }
}
