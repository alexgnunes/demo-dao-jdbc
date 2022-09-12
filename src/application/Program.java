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

		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===test 1 : seller findById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n===test 2 : seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===test 3 : seller findAll ===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===test 4 : seller insert ===");
		Seller newseller = new Seller(null, "greg", "greg@gmail", new Date(), 4000.0, department);
		sellerDao.insert(newseller);
		System.out.println("inserted! new id = " + newseller.getId());
		
		System.out.println("\n===test 5 : seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("update complete ");	
		
		System.out.println("\n===test 6 : seller deleteByID ===");
		System.out.println(" Enter com numero id para deletar");
		int id = sc.nextInt();
		sellerDao.deleteByID(id);
		System.out.println("delete complet");
		
		sc.close();
	}

}
