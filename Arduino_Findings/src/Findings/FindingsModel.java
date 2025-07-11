package Findings;
import Report.ReportController;
import WiFi.WifiConnection;
import processing.core.PApplet;
import java.util.ArrayList;

/**
 * Model class from the MVC program pattern
 */
public class FindingsModel {
    public ArrayList<ReportController> reports;
    private WifiConnection s;


    /**
     * Constructor
     * @param p - PApplet obj
     * @throws NullPointerException if the PApplet ogj is null
     */
    public FindingsModel(PApplet p) throws NullPointerException{
        if(p != null) {
            s = new WifiConnection(p);
            reports = new ArrayList<>();
        }else throw new NullPointerException();
    }

    /**
     * Method to get a single report from the list
     * @param index - index of the array
     * @return the report
     */
    public ReportController getReport (int index) {
        return reports.get(index);
    }

    /**
     * @return the list with all the reports
     */
    public ArrayList<ReportController> getReports() {
        return reports;
    }

    /**
     * @return the WifiConnection obj
     */
    public WifiConnection getWifi() {
        return s;
    }
}