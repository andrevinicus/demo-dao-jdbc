package aplication;


import java.util.Date;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.creatSallerDao();
        
        System.out.println("=== TESTE 1: seller findById ====");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
        System.out.println("\n=== TESTE 2: seller findByDepartment ====");
        Department departament = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartament(departament);
        
        for(Seller obj : list){
            System.out.println(obj);
        }
        System.out.println("\n=== TESTE 3: seller findAll ====");
        
        list = sellerDao.findAll();
        
        for(Seller obj : list){
            System.out.println(obj);
        }
    }

}
