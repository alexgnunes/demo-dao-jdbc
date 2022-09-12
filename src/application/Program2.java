package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("===test 1 : department findById ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

		System.out.println("\n===test 2 : department findByAll ===");
		List<Department>list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===test 4 : department insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("inserted! new id = " + newDepartment.getId());
		
		System.out.println("\n===test 5 : department update ===");
		dep = departmentDao.findById(6);
		dep.setName("Carros");
		departmentDao.update(dep);
		System.out.println("update complete ");
		
		System.out.println("\n===test 6 : department deleteByID ===");
		System.out.println(" Enter com numero id para deletar");
		int id = sc.nextInt();
		departmentDao.deleteByID(id);
		System.out.println("delete complet");
		
		sc.close();
		
		
	}

}
