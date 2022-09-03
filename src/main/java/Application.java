
import dao.ProductSettingDaoImpl;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.ProductSettingService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Product product = new Product("s2", "samsung", 250, 300);
        NumberOfProduct numberOfProduct = new NumberOfProduct(2);
        NumberOfStore numberOfStore =new NumberOfStore("4");
        PurchasePrice purchasePrice =new PurchasePrice(22500);
        SellingPrice sellingPrice =new SellingPrice(13000);


        ProductSettingService productSettingService = new ProductSettingService();
        ProductsList productsList =new ProductsList(sellingPrice, purchasePrice, product, 3);
        ProductSetting productSetting = new ProductSetting(numberOfProduct, numberOfStore, productsList);


           SessionFactory factory = new Configuration().configure().buildSessionFactory();
           try {
               Session session = factory.getCurrentSession();
               session.beginTransaction();
               session.save(numberOfProduct);
               session.save(numberOfStore);
               session.save(sellingPrice);
               session.save(purchasePrice);
               session.save(product);
               session.save(productsList);

               System.out.println(productSetting);
               session.getTransaction().commit();

           }finally {
             factory.close();
           }
        productSettingService.save(productSetting);

        }

        }



