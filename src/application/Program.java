package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department obj = new Department(1, "Books");
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ====");
		List<Seller> list = sellerDao.findByDepartment(new Department(2,null));
		
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: seller findAll ====");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 4: seller insert ====");
		Seller newSeller = new Seller(null,"Greg", "greg@gmail.com", new Date(),4000.0,new Department(2,null));
		sellerDao.insert(newSeller);
		System.out.println("Inserte! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("\n=== TEST 6: seller delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Complete");
		
		sc.close();
	}

}
