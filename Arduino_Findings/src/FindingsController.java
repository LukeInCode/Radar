import DAO.Finder;
import Findings.*;
import controlP5.ControlEvent;
import processing.core.PApplet;
import Report.*;
import java.time.format.DateTimeFormatter;
import java.time.*;
/**
 * Controller class from the MVC program pattern
 */
public class FindingsController extends PApplet {
    //digital -> green // analog -> blue
    private FindingsModel m;
    private FindingsView v;
    private Finder finder;

    private boolean ready = false;

    private int previousMillis;

    private int status = -1;
    private int message;

    /**
     * Method for initializing variables
     */
    public void setup() {
        finder = new Finder(this);
        m = new FindingsModel(this);
        v = new FindingsView(this);
        v.setScreen(0,true);
        previousMillis = millis();
        ready = true;
    }

    /**
     * Method to set the view settings
     */
    public void settings() {
        size(800,800);
    }

    /**
     * Main method
     */
    public void draw() {
        if(status != -1 && millis() - previousMillis > 3000) {
            System.out.println("dentro");
            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String today = LocalDate.now().format(f);
            previousMillis = millis();
            ReportController atcualReport = new ReportController(new ReportModel(message,LocalDate.parse(today,f)),new ReportView(this));
            finder.addReport(atcualReport.getM().getReveled(),atcualReport.getM().getDate().toString());
            status = -1;
        }
        m.reports = finder.getAllreports();
        v.loop(m);
    }

    /**
     * Exit button callback
     * @param e button event
     */
    public void exit(ControlEvent e) {
        if(ready && e.isFrom(v.getButton(1))) {
            System.exit(0);
        }
    }

    /**
     * Report view button callback
     * @param e button event
     */
    public void list(ControlEvent e) {
        if(ready && e.isFrom(v.getButton(0))) {
            v.setScreen(0,false);
            v.setScreen(1,true);
        }
    }

    /**
     * Back home button callback
     * @param e button event
     */
    public void home(ControlEvent e) {
        if(ready && e.isFrom(v.getHome())) {
            v.setScreen(0,true);
            v.setScreen(1,false);
            v.getHome().hide();
        }
    }

    public void webSocketServerEvent(String msg){
        try {
            message = Integer.parseInt(msg);
            System.out.println(message);
            if(message == -1) status = -1;
            else status = 0;
        }catch (Exception e) {
            status = -1;
        }
    }

    /**
     * Main method
     * @param passedArgs args
     */
    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "FindingsController" };
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }
}
