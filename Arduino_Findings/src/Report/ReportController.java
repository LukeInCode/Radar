package Report;

public class ReportController {
    private ReportModel m;
    private ReportView v;

    public ReportController(ReportModel m, ReportView v) throws NullPointerException{
        if(m == null || v == null) {
            throw new NullPointerException("Values passed null");
        }
        this.m = m;
        this.v = v;
    }

    public void displayReports() {
        v.view(m);
    }

    public ReportModel getM() {
        return m;
    }

    public ReportView getV() {
        return v;
    }
}
