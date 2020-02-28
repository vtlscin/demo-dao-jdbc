package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department obj = new Department(1, "Books");
		
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
	}

}
