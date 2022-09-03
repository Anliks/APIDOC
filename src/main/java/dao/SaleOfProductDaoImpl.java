package dao;

import HibernateSet.HibernateSet;
import dao.documentDao.SaleOfProductDao;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.SaleOfProduct;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
@Data
@NoArgsConstructor
public class SaleOfProductDaoImpl implements SaleOfProductDao {

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
    public void save(SaleOfProduct model) {
    getCurrentSession().save(model);
    }

    @Override
    public void update(SaleOfProduct model) {
    getCurrentSession().update(model);
    }

    @Override
    public void delete(SaleOfProduct model) {
     getCurrentSession().delete(model);
    }

    @Override
    public SaleOfProduct read(Integer id) {
        final SaleOfProduct result = getCurrentSession().get(SaleOfProduct.class, id);
        if(result!= null) {
            result.getListOfProductId();
            result.getNumberId();
            result.getStoreId();
        }
        return result;
    }

    @Override
    public List<SaleOfProduct> findAll() {
        return (List<SaleOfProduct>) getCurrentSession().createQuery("from SaleOfProduct").list();
    }

    @Override
    public SaleOfProduct findById(Integer id) {
        SaleOfProduct product = getCurrentSession().get(SaleOfProduct.class, id);
        return product;
    }
}
