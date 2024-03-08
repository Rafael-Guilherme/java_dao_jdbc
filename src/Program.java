import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: department insert ===");
        Department derp = new Department(null, "Food");
        departmentDao.insert(derp);
        System.out.println("Inserted! New Id = " + derp.getId());

        System.out.println("\n=== Test 2: department update ===");
        derp = departmentDao.findById(5);
        derp.setName("Bed and Bathroom");
        departmentDao.update(derp);
        System.out.println("Update Completed!");

        System.out.println("\n=== Test 3: department delete ===");
        System.out.print("Enter a id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Department id: " + id + " deleted!");

        sc.close();

        System.out.println("\n=== Test 4: department findAll ===");
        List<Department> dep = departmentDao.findAll();
        for (Department obj : dep) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test 5: department findbyId ===");
        derp = departmentDao.findById(5);
        System.out.println(derp);
    }
}
