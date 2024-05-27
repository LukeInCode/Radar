package DAO;
import Report.ReportController;
import Report.ReportModel;
import Report.ReportView;
import processing.core.PApplet;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class  Finder implements Actions {

    private final String URL = "jdbc:mysql://localhost/Obstacles";
    private final String USERNAME = "user";
    private final String PSW = "MySQLDB!";

    private PApplet parent;

    public Finder(PApplet parent) throws NullPointerException{
        if(parent == null) {
            throw new NullPointerException("Data null");
        }
        this.parent = parent;
    }


    /**
     * Method to set a new report
     * @param dist - distance
     * @param d - date
     * @return true if the action is successfully completed
     */
    @Override
    public boolean addReport(int dist, String d) throws RuntimeException{
        final String query = "INSERT INTO Obstacles.infos(REVELED,Date) VALUES(?,?)";
        try(Connection c = DriverManager.getConnection(URL,USERNAME,PSW)){
            PreparedStatement t = c.prepareStatement(query);
            t.setInt(1,dist);
            t.setString(2,d);
            t.executeUpdate();
            return true;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Method to get a report by its id
     * @param id - id of the report
     * @return the ResultSet
     */
    @Override
    public ResultSet getReportById(int id) {
        final String query = "SELECT * infos WHERE id=?";
        try(Connection c = DriverManager.getConnection(URL,USERNAME,PSW)){
            PreparedStatement t = c.prepareStatement(query);
            t.setInt(1,id);
            ResultSet rs = t.executeQuery();
            return rs;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Method to get a report by its id
     * @return the ResultSet
     */
    @Override
    public ArrayList<ReportController> getAllreports() throws RuntimeException{
        final String query = "SELECT * FROM infos";
        ArrayList<ReportController> list = new ArrayList<>();
        try(Connection c = DriverManager.getConnection(URL,USERNAME,PSW)){
            Statement t = c.createStatement();
            ResultSet rs = t.executeQuery(query);
            try {
                while (rs.next()) {
                    int dist = rs.getInt("REVELED");
                    LocalDate date = LocalDate.parse(rs.getString("Date"));
                    list.add(new ReportController(new ReportModel(dist,date),new ReportView(parent)));
                }
                return list;
            }catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
