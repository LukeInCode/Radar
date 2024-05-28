package Report;
import processing.core.PApplet;
import java.time.format.DateTimeFormatter;

public class ReportView {

    private PApplet parent;
    private static int y;

    public ReportView(PApplet parent) {
        this.parent = parent;
        y = parent.height/3;

    }

    public void view(ReportModel m) {
        parent.textSize(40);
        parent.fill(0);
        String header = String.format("%12s %12s","DISTANCE","DATE");
        String date = m.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String body = String.format("%-12d %12s",m.getReveled(),date);
        parent.text(header,parent.width/4,parent.height/4);
        parent.text(body,parent.width/3,y);
        if(y > parent.height/10) y += parent.height/10;
    }
}
