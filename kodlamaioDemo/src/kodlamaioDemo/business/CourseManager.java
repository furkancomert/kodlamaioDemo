package kodlamaioDemo.business;

import java.util.List;

import kodlamaioDemo.core.logging.Logger;
import kodlamaioDemo.dataAccess.CourseDao;
import kodlamaioDemo.entities.Course;

public class CourseManager {
	private CourseDao courseDao;
	private Logger[] loggers;
	private List<Course> courses;

	public CourseManager(CourseDao courseDao, Logger[] loggers, List<Course> courses) {
		this.courseDao = courseDao;
		this.courses = courses;
		this.loggers = loggers;
	}

	public void add(Course course) throws Exception {
		if (course.getCoursePrice() < 0) {
			throw new Exception("Kurs fiyatı 0 dan küçük olamaz.");
		}
		for (Course courses : courses) {
			if (courses.getCourseName().equals(course.getCourseName())) {
				throw new Exception("Kurs ismi aynı olamaz.");
			}

		}

		courses.add(course);

		for (Logger logger : loggers) {
			logger.log(course.getCourseName());

		}
	}
}
