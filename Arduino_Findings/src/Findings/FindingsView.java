package Findings;
import Report.ReportController;
import processing.core.PApplet;
import controlP5.*;

import java.util.Arrays;

/**
 * View class from the MVC program pattern
 */
public class FindingsView {

    private PApplet parent;
    private ControlP5 cp5;

    private Button btns[];

    private Button home;

    private boolean screens[];

    /**
     * Constructor
     * @param p - PApplet obj for the processing implementation
     * @throws NullPointerException - if the obj is null
     */
    public FindingsView (PApplet p) throws NullPointerException{
        if(p != null) {
            parent = p;
            btns = new Button[2];
            screens = new boolean[2];
            cp5 = new ControlP5(parent);

            btns[0] = cp5.addButton("list").setValue(100).setSize(100,100).setPosition(parent.width/2-50,parent.height/2).setLabel("view").hide();
            btns[1] = cp5.addButton("exit").setValue(100).setSize(100,100).setPosition(parent.width/2-50,parent.height/2+200).setLabel("exit").hide();
            home = cp5.addButton("home").setValue(100).setSize(100,50).setPosition(parent.width/2+parent.width/6,parent.height/4-parent.width/5).setLabel("Back").hide();
            Arrays.fill(screens,false);
        }
        else {
            throw new NullPointerException("Obj null");
        }
    }

    /**
     * Method for displaying start menu
     */
    public void showStart () {
        parent.background(144, 224, 239);
        parent.textMode(3);
        parent.fill(0);
        parent.textSize(40);
        parent.text("Welcome to the radar!",parent.width/2-parent.width/4,parent.height/4);
        showAllButtons();
    }

    /**
     * Method for displaying information
     * @param m - FindingsModel obj to display
     */
    public void loop(FindingsModel m) {
        if(screens[0]) {
            screens[1] = false;
            showStart();
        }else if(screens[1]){
            parent.background(144, 224, 239);
            home.show();
            parent.textSize(40);
            parent.fill(0);
            parent.text("Records",parent.width/2-parent.width/12,parent.height/3-parent.width/4);
            if(m.getReports().isEmpty()) parent.text("No data to found" , parent.width/2-parent.width/6,parent.height/3);
            else {
                for(ReportController report : m.getReports()) {
                    report.displayReports();
                }
            }
            hideAllButtons();
            screens[0] = false;
        }
    }

    /**
     * Method to show all buttons
     */
    public void showAllButtons() {
        for(Button b : btns) b.show();
    }

    /**
     * Method to hide all buttons
     */
    public void hideAllButtons() {
        for(Button b : btns) b.hide();
    }

    /**
     * Method to get a single button from the array
     * @param index - index of the array
     * @return - the button
     * @throws IndexOutOfBoundsException - if the index is not valid
     */
    public Button getButton(int index) throws IndexOutOfBoundsException{
        if(index >= 0 && index < btns.length) return btns[index];
        else throw new IndexOutOfBoundsException("Index out of the button array bound");
    }

    /**
     * Method to set a screen
     * @param index - index to set
     * @param value - value to set
     * @throws IndexOutOfBoundsException - if the index is out of the array bound
     */
    public void setScreen(int index, boolean value) throws IndexOutOfBoundsException{
        if(index >= 0 && index < btns.length) screens[index] = value;
        else throw new IndexOutOfBoundsException("Index out of the screen array bound");
    }

    /**
     * Method to get a single screen value
     * @param index - index to get
     * @return the value of the screen
     * @throws IndexOutOfBoundsException if the index is out of the array bound
     */
    public boolean getScreen(int index) throws IndexOutOfBoundsException{
        if(index >= 0 && index < screens.length) return screens[index];
        else throw new IndexOutOfBoundsException("Index out of the screen array bound");
    }

    /**
     * @return the "home" button
     */
    public Button getHome() {return home;}
}
