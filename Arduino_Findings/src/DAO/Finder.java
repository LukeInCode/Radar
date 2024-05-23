package DAO;
import java.sql.*;

public class  Finder implements Actions {

    private final String URL = "jdbc:mysql://localhost/infos";
    private final String USERNAME = "user";
    private final String PSW = "MySQLDB!";


    /**
     * Method to set a new report
     * @param id - id of the new report
     * @param rev - if something is revealed (0,1)
     * @param d - date
     * @return true if the action is successfully completed
     */
    @Override
    public boolean addReport(int id, byte rev, String d) {
        final String query = "INSERT INTO infos(ID,REVELED,DATE) VALUES(?,?,?)";
        try(Connection c = DriverManager.getConnection(URL,USERNAME,PSW)){
            PreparedStatement t = c.prepareStatement(query);
            t.setInt(1,id);
            t.setInt(2,rev);
            t.setString(3,d);
            ResultSet rs = t.executeQuery();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    /**
     * Method to get a report by its id
     * @param id - id of the report
     * @return the ResultSet
     */
    @Override
    public ResultSet getReport(int id) {
        final String query = "SELECT * infos WHERE id=?";
        try(Connection c = DriverManager.getConnection(URL,USERNAME,PSW)){
            PreparedStatement t = c.prepareStatement(query);
            t.setInt(1,id);
            ResultSet rs = t.executeQuery();
            return rs;
        }catch (Exception e) {
            return null;
        }
    }
}
