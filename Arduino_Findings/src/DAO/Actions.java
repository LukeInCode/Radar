package DAO;

import Report.ReportController;
import Report.ReportView;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Interface for DAO design pattern application
 */
public interface Actions {
    /**
     * Method for add a new report in the DB
     * @param revelation - distance parameter
     * @param date - date in string format
     * @return true if it doesn't catch any exception
     */
    public boolean addReport(int revelation, String date);

    /**
     * Method for get the ID of the report
     * @param id - numeric id
     * @return a ReportController object if it doesn't catch any exception
     */
    public ReportController getReportById(int id);

    /**
     * Method for get all the reports
     * @return ad ArrayList of ReportController
     */
    public ArrayList<ReportController> getAllreports();
}
