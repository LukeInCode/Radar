package Findings;
import Report.ReportController;
import processing.core.PApplet;
import processing.serial.Serial;
import java.util.ArrayList;


/**
 * Model class from the MVC program pattern
 */
public class FindingsModel {
    public ArrayList<ReportController> reports;
    private Serial s;


    /**
     * Constructor
     * @param p - PApplet obj
     * @throws NullPointerException if the PApplet ogj is null
     */
    public FindingsModel(PApplet p) throws NullPointerException{
        if(p != null) {
            s = new Serial(p,Serial.list()[3],9600);
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
     * @return the serial obj
     */
    public Serial getSerial() {
        return s;
    }
}