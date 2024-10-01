package devzeus.com.webapp.daos.impl;

import devzeus.com.webapp.configs.DBConnectMySQL;
import devzeus.com.webapp.daos.ICategoryDao;
import devzeus.com.webapp.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends DBConnectMySQL implements ICategoryDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    private void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        conn.close();
        ps.close();
        rs.close();
    }
    @Override
    public List<Category> findAll() {
        sql = "select * from categories";
        List<Category> categoryList = new ArrayList<Category>();
        try{
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setImage(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                categoryList.add(category);
            }
            close(conn, ps, rs);
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return categoryList;
    }

    @Override
    public Category findById(int id) {
        sql = "select * from categories where id = ?";
        try{
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Category category = new Category();
            if (rs.next()){
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setImage(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
            }
            close(conn, ps, rs);
            return category;
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category findByName(String name) {
        sql = "select * from categories where name = ?";
        try{
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery(sql);
            if (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setImage(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                return category;
            }
            close(conn, ps, rs);
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Category> searchByName(String keyword) {
        sql = "select * from categories like name=?";
        List<Category> categoryList = new ArrayList<Category>();
        try{
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setImage(rs.getString("images"));
                category.setStatus(rs.getInt("status"));
                categoryList.add(category);
            }
            close(conn, ps, rs);
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return categoryList;
    }

    @Override
    public void insert(Category category) {
        sql = "insert into categories (name, images, status) values (?, ?, ?)";
        try{
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getImage());
            ps.setInt(3, category.getStatus());
            ps.executeUpdate();
            close(conn, ps, rs);
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Category category) {
        sql = "update categories set name = ?, images = ?, status = ? where id = ?";
        try{
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getImage());
            ps.setInt(3, category.getStatus());
            ps.setInt(4, id);
            ps.executeUpdate();
            close(conn, ps, rs);
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        sql = "delete from categories where id = ?";
        try{
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int ck = ps.executeUpdate();
            close(conn, ps, rs);
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStatus(int id, int status) {
        sql = "update categories set status = ? where id = ?";
        try{
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
            close(conn, ps, rs);
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
