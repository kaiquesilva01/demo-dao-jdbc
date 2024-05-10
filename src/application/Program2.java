package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n=== TEST 1: department insert =====");
        Department newDepartment = new Department(null,"Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 2: department findById =====");
        Department obj = departmentDao.findById(1);
        System.out.println(obj);

        System.out.println("\n=== TEST 3: department update =====");
        obj = departmentDao.findById(1);
        obj.setName("Notebooks");
        departmentDao.update(obj);
        System.out.println("Update Complete");

        System.out.println("\n=== TEST 4: department findByAll =====");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n=== TEST 5: department delete =====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");


    }

}