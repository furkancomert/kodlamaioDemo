package kodlamaioDemo.business;

import java.util.List;

import kodlamaioDemo.core.logging.Logger;
import kodlamaioDemo.dataAccess.CategoryDao;
import kodlamaioDemo.entities.Category;

public class CategoryManager {
	private CategoryDao categoryDao;
	private Logger[] loggers;
	private final List<Category> categories;

	public CategoryManager(CategoryDao categoryDao, Logger[] loggers, List<Category> categories) {

		this.categoryDao = categoryDao;
		this.loggers = loggers;
		this.categories = categories;
	}

	public void add(Category category) throws Exception {
		for (Category categories : categories) {
			if (categories.getCategoryName() == category.getCategoryName()) {
				throw new Exception("Aynı kategori ismi kullanılamaz.");
			}
		}

		categoryDao.add(category);
		categories.add(category);

		for (Logger logger : loggers) {
			logger.log(category.getCategoryName());
		}
	}
}
