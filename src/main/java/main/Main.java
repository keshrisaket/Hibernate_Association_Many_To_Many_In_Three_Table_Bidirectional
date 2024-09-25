package main;

import beans.Department;
import beans.Employee;
import hibernateutils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(session);

        try {

            Department department1 = new Department();
            department1.setName("AIIT");

            Department department2 = new Department();
            department2.setName("MBBA");


            Employee emp1 = new Employee();
            emp1.setAddr("Danapur");
            emp1.setName("Keshri1");
            List<Department> emp1Depart = new ArrayList<>();
            emp1Depart.add(department1);
            emp1Depart.add(department2);
            emp1.setDepartment(emp1Depart);

            Employee emp2 = new Employee();
            emp2.setName("Keshri2");
            emp2.setAddr("Patna");
            List<Department> emp2Depart = new ArrayList<>();
            emp2Depart.add(department2);
            emp2.setDepartment(emp2Depart);

            List<Employee> employeeList = new ArrayList<>();
            employeeList.add(emp1);
            department1.setEmployeeList(employeeList);

            List<Employee> employeeList2 = new ArrayList<>();
            employeeList2.add(emp1);
            employeeList2.add(emp2);
            department2.setEmployeeList(employeeList2);

           /* session.persist(department1);
            session.persist(department2);*/

          /*  Department department = (Department) session.get(Department.class, Integer.parseInt("2"));
            List<Employee> employees = department.getEmployeeList();


            for (Employee employee : employees) {
                System.out.println(employee.getName());
            }*/

            Employee employee=(Employee) session.get(Employee.class,Integer.parseInt("1"));
            List<Department> empDepart=employee.getDepartment();

            for (Department dep:
                empDepart ) {
                System.out.println(dep.getName());
            }


            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }


    }
}
