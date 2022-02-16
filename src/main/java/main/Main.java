package main;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import main.entity.Student;
import main.model.Address;
import main.utils.HibernateUtil;

public class Main {
	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Student student = new Student();
			student.setStudentName("Daham");
			student.setDoj(new Date());
			student.setEmail("Daham@gmail.com");

			Address homeAdrees = new Address();
			homeAdrees.setStreet("Bonn annabe");
			homeAdrees.setPincode(1234);
			homeAdrees.setState("Germany");
			homeAdrees.setCity("Bonn");

			Address officeAddress = new Address();
			officeAddress.setStreet("Berlin");
			officeAddress.setPincode(222);
			officeAddress.setState("Germany");
			officeAddress.setCity("Bonn");
			student.getListAddresses().add(officeAddress);
			student.getListAddresses().add(homeAdrees);
			
			
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
