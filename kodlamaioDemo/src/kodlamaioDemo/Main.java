package kodlamaioDemo;

import java.util.ArrayList;
import java.util.List;

import kodlamaioDemo.business.CategoryManager;
import kodlamaioDemo.business.CourseManager;
import kodlamaioDemo.business.InstructorManager;
import kodlamaioDemo.core.logging.DatabaseLogger;
import kodlamaioDemo.core.logging.FileLogger;
import kodlamaioDemo.core.logging.Logger;
import kodlamaioDemo.core.logging.MailLogger;
import kodlamaioDemo.dataAccess.HibernateCourseDao;
import kodlamaioDemo.dataAccess.HibernateInstructorDao;
import kodlamaioDemo.dataAccess.JdbcCategoryDao;
import kodlamaioDemo.dataAccess.JdbcInstructorDao;
import kodlamaioDemo.entities.Category;
import kodlamaioDemo.entities.Course;
import kodlamaioDemo.entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception {
		Logger[] loggers = { new DatabaseLogger(), new FileLogger(), new MailLogger() };

		System.out.println("EGİTMEN");
		System.out.println("--------------------");

		Instructor instructor = new Instructor(1, "Engin", "Demiroğ");
		InstructorManager instructorManager = new InstructorManager(new HibernateInstructorDao(), loggers);
		instructorManager.add(instructor);

		System.out.println("--------------------");
		System.out.println("KURSLAR");
		System.out.println("--------------------");

		Course course1 = new Course(1, "Yazılım Geliştirici Yetiştirme Kampı(C#+ANGULAR)", 600);
		Course course2 = new Course(2, "Senior Yazılım Geliştirici Yetiştirme Kampı(.NET)", 800);
		Course course3 = new Course(3, "Yazılım Geliştirici Yetiştirme Kampı(JAVA+REACT)", 500);

		// Course course4 = new Course(3, "Yazılım Geliştirici Yetiştirme
		// Kampı(JAVA+REACT)", 700);
		// bu kullanımı yaparsak course ismi aynı oldugu için hata mesajı atar.
		// Course course4 = new Course(3, "Yazılım Geliştirici Yetiştirme
		// Kampı2(JAVA+REACT)", -700);
		// bu kullanımı yaparsak kurs ücreti sıfırdan küçük olduğu için yine hata mesajı
		// alırız.

		List<Course> courseList = new ArrayList<>();
		CourseManager courseManager = new CourseManager(new HibernateCourseDao(), loggers, courseList);
		courseManager.add(course1);
		courseManager.add(course2);
		courseManager.add(course3);

		// courseManager.add(course4);

		System.out.println("--------------------");
		System.out.println("KATEGORİ");
		System.out.println("--------------------");

		Category category1 = new Category(1, "Programlama");
		Category category2 = new Category(2, "Programlama2");
		Category category3 = new Category(2, "Programlama3");
		List<Category> categoryList = new ArrayList<>();
		CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), loggers, categoryList);
		categoryManager.add(category1);
		categoryManager.add(category2);
		categoryManager.add(category3);
	}
}
