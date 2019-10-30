package MyBudget;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    public static final String GET_ALL = "select * from item;";
    public static final String INSERT_INTO_ITEM = "insert into item (date, kind_of_outcome, month, outcome) values (? , ? , ? , ?);";
    public static final String GET_SUM_OF_OUTCOME_BY_MONTH = "select sum(outcome) from item where month = ?;";
    public static final String GET_SUM_OF_OUTCOME_BY_KIND = "select sum(outcome) from item where kind_of_outcome = ?;";

    public static void getAllRows() {
        try {
            Connection conn = DbConnector.createConnection();
            PreparedStatement ps = conn.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int itemId = rs.getInt("item_id");
                String date = rs.getString("date");
                String kindOfOutcome = rs.getString("kind_of_outcome");
                String month = rs.getString("month");
                int outcome = rs.getInt("outcome");

                System.out.format("%s, %s , %s, %s , %s\n", itemId, date, kindOfOutcome, month, outcome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertItem(String date, String kindOfOutcome, String month, double outcome) {
        try (Connection conn = DbConnector.createConnection()) {

            PreparedStatement ps = conn.prepareStatement(INSERT_INTO_ITEM);
            ps.setString(1, date);
            ps.setString(2, kindOfOutcome);
            ps.setString(3, month);
            ps.setDouble(4, outcome);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double getSumOfOutcomeByMonth(String month){
        try {
            Connection conn = DbConnector.createConnection();
            PreparedStatement ps = conn.prepareStatement(GET_SUM_OF_OUTCOME_BY_MONTH);
            ps.setString(1, month);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                double sumOfOutcome = rs.getDouble("sum(outcome)");

                return sumOfOutcome;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }

    public static double getSumOfOutcomeByKind(String kindOfOutcome){
        try {
            Connection conn = DbConnector.createConnection();
            PreparedStatement ps = conn.prepareStatement(GET_SUM_OF_OUTCOME_BY_KIND);
            ps.setString(1, kindOfOutcome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                double sumOfOutcome = rs.getDouble("sum(outcome)");

                return sumOfOutcome;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
