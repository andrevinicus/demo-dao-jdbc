package aplication;


import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        System.out.println("\n=== TESTE 4: seller Inset ====");
        Seller newSeller = new Seller(1, "Greg", "greg@gmail.com", new Date(), 4000.0, departament); 
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id = " + newSeller.getId());
        
        System.out.println("\n=== TESTE 5: seller Inset ====");
        seller = sellerDao.findById(1);
        seller.setName("Marta Waine");
        sellerDao.update(seller);
        System.out.println("Update completado");
        
        System.out.println("\n=== TESTE 6: seller Inset ====");
        System.out.println("Enter id for delete teste: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed ");
        sc.close();
    }
        
}
