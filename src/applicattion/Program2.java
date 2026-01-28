package applicattion;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	
		System.out.println("=== Teste 1 department findById ===");
		Department department =  departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n ==== Teste 2 department findByAll ====");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
				System.out.println(obj);
		}
		
		System.out.println("\n ==== Teste 3 department Insert ====");
		Department newDepartment = new Department(15, null);
		departmentDao.insert(newDepartment);
		System.out.println("Insert, new department : " + newDepartment.getId());
		
		System.out.println("\n ==== Teste 4 department update ====");
		department = departmentDao.findById(12);
		department.setName("Almoxarifado2 ");
		departmentDao.update(department);
		System.out.println("Update Completed");
		
		System.out.println("\n ==== Teste 5 delete department ====");
		System.out.println("Enter id for delete test: ");
		
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed");
		
		sc.close();
	}
}
