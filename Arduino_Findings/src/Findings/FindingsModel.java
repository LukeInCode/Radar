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


    public FindingsModel(PApplet p) throws NullPointerException{
        if(p != null) {
            s = new Serial(p,Serial.list()[0],9600);
            reports = new ArrayList<>();
        }else throw new NullPointerException();
    }

    public ReportController getReport (int index) {
        return reports.get(index);
    }

    public ArrayList<ReportController> getReports() {
        return reports;
    }

    public Serial getSerial() {
        return s;
    }
}