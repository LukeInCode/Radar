package DAO;

import Report.ReportController;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface Actions {
    public boolean addReport(int revelation, String date);
    public ResultSet getReportById(int id);
    public ArrayList<ReportController> getAllreports();
}
