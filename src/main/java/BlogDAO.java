
import com.huy3003.utils.DBUtils;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author huy
 */
public class BlogDAO {

    private static final String DELETE = "DELETE sale.blog WHERE id=?";
    private static final String CREATE = "INSERT INTO sale.blog(title, content, publish_date, image, staff_id)"
            + "SELECT ?,?,?,?, id FROM account.staff WHERE first_name + ' ' + last_name = ?";
    private static final String UPDATE = "UPDATE sale.blog SET title=?, content=?,publish_date=?, image=? WHERE id=?";

    public boolean delete(String id) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, id);
                int count = ptm.executeUpdate();
                if (count > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public boolean create(Blog blog, String imagePath) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            File imageFile = new File(imagePath);
            try (FileInputStream fis = new FileInputStream(imageFile)) {
                if (conn != null) {
                    ptm = conn.prepareStatement(CREATE);
                    ptm.setInt(1, blog.getId());
                    ptm.setString(2, blog.getTitle());
                    ptm.setString(3, blog.getContent());
                    ptm.setDate(4, blog.getDate());
                    ptm.setBinaryStream(5, fis, (int) imageFile.length());
                    result = ptm.executeUpdate() > 0 ? true : false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
