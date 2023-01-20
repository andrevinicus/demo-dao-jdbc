
package aplication;

import java.util.Date;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;


public class Program {

    
    public static void main(String[] args) {
        
        SellerDao sellerDao = DaoFactory.creatSallerDao();
        
        Seller seller = sellerDao.findById(3);
        
        System.out.println(seller);
        
  }
    
}
