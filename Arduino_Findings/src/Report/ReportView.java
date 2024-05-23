package Report;

import processing.core.PApplet;

public class ReportView {

    private PApplet parent;
    private int y;

    public ReportView(PApplet parent) {
        this.parent = parent;
        y = parent.height/3;

    }

    public void view(ReportModel m) {
        parent.textSize(40);
        parent.fill(0);
        parent.text("",0,y);
        y -= parent.height/10;
    }
}
