package devzeus.com.webapp.services.implement;

import devzeus.com.webapp.daos.ICategoryDao;
import devzeus.com.webapp.daos.impl.CategoryDaoImpl;
import devzeus.com.webapp.models.Category;
import devzeus.com.webapp.services.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    public ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public List<Category> searchByName(String keyword) {
        return categoryDao.searchByName(keyword);
    }

    @Override
    public void insert(Category category) {
        Category cate = this.findById(category.getId());
        if (cate.getName() == null) {
            categoryDao.insert(cate);
        }
    }

    @Override
    public void update(int id, Category category) {
        Category cate = this.findById(id);
        if (cate.getName() != null) {
            categoryDao.insert(cate);
        }
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }
}
