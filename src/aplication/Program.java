package aplication;


import java.util.Date;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.creatSallerDao();
        
        System.out.println("=== TESTE 1: seller findById ====");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
        System.out.println("\n=== TESTE 2: seller findByDepartment ====");
        Departament departament = new Departament(2,null);
        List<Seller> list = sellerDao.findByDepartament(departament);
        
        for(Seller obj : list){
            System.out.println(obj);
        }
    }

}
