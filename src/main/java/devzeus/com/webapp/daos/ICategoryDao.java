package devzeus.com.webapp.daos;

import devzeus.com.webapp.models.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> findAll();
    Category findById(int id);
    Category findByName(String name);
    List<Category> searchByName(String keyword);
    void insert(Category category);
    void update(int id, Category category);
    void delete(int id);
    void updateStatus(int id, int status);
}
