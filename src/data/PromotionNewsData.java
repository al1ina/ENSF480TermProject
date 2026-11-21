package src.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import src.business.PromotionNews;

public class PromotionNewsData {
    public PromotionNews getPromotionNews(String month) {
        PromotionNews news = null;
        String sql = 
        """
        SELECT * FROM MONTHLYPROMOTIONS WHERE month = ?
        """;
        try(Connection conn = DatabaseManager.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, month);
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    news = new PromotionNews(rs.getString("title"), rs.getString("details"), rs.getString("month"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not get the monthly promotion news");
        }
        if (news == null) {
            throw new RuntimeException("No promotional news available for this month");
        }
        return news;
    }
}
