package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n=== TEST 3: insert ===");
		Department dep = new Department(null, "Música");
		departmentDao.insert(dep);
		System.out.println("Inserted! New id:" + dep.getId());
		
		System.out.println("\n=== TEST 4: update ===");
		Department dep2 = departmentDao.findById(6);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: delete ===");
		System.out.println("Enter Id for delete test: ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.print("Delete completed!");
		sc.close();
		

	}

}
