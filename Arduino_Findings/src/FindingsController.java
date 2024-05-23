import DAO.Finder;
import Findings.*;
import controlP5.ControlEvent;
import processing.core.PApplet;

import java.time.LocalDate;

/**
 * Controller class from the MVC program pattern
 */
public class FindingsController extends PApplet {
    //digital -> green // analog -> blue
    private FindingsModel m;
    private FindingsView v;
    private Finder report;

    boolean ready = false;


    /**
     * Method for initializing variables
     */
    public void setup() {
        report = new Finder();
        m = new FindingsModel(this);
        v = new FindingsView(this);
        v.setScreen(0,true);
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
        //System.out.println(m.s.read());
        v.loop(m);
    }

    public void exit(ControlEvent e) {
        if(ready && e.isFrom(v.getButton(1))) {
            System.exit(0);
        }
    }

    public void list(ControlEvent e) {
        if(ready && e.isFrom(v.getButton(0))) {
            v.setScreen(0,false);
            v.setScreen(1,true);
        }
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "FindingsController" };
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }
}
