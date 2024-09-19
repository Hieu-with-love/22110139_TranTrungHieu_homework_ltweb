package devzeus.com.webapp.daos.impl;

import devzeus.com.webapp.configs.DBConnectMySQL;
import devzeus.com.webapp.daos.IUserDao;
import devzeus.com.webapp.models.UserModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM users";

        List<UserModel> users = new ArrayList<>();
        try {
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setImage(rs.getString("image"));
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public UserModel findById(int id) {
        return null;
    }

    @Override
    public UserModel findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username=?";

        try {
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next())
            {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setImage(rs.getString("image"));
                user.setRoleid(rs.getInt("roleid"));
                LocalDate date = rs.getDate("createdate").toLocalDate();
                user.setCreatedate(date);
                user.setPhone(rs.getString("phone"));
                return user;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean insertRegisterUser(UserModel userModel) {
        String sql = new StringBuilder()
                .append("INSERT INTO users(username, password, email, fullname, roleid, createdate, phone) ")
                .append("VALUES(?,?,?,?,?,?,?)")
                .toString();

        try {
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userModel.getUsername());
            ps.setString(2, userModel.getPassword());
            ps.setString(3, userModel.getEmail());
            ps.setString(4, userModel.getFullname());
            ps.setInt(5, 1);
            ps.setDate(6, Date.valueOf(userModel.getCreatedate()));
            ps.setString(7, userModel.getPhone());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // Đóng các tài nguyên
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return check(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return check(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return check(phone);
    }

    private boolean check(String param){
        String sql = String.format("SELECT * FROM user WHERE %s=?", param);
        boolean exists = false;
        try {
            // Kết nối cơ sở dữ liệu từ phương thức getDatabaseConnection()
            conn = getDatabaseConnection();

            // Chuẩn bị câu lệnh SQL với tham số
            ps = conn.prepareStatement(sql);
            ps.setString(1, param);

            // Thực thi truy vấn
            rs = ps.executeQuery();

            // Kiểm tra xem kết quả có tồn tại không
            if (rs.next()) {
                exists = true; // Nếu có kết quả trả về, email đã tồn tại
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return exists;
    }
}
