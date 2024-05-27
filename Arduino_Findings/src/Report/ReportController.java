package Report;

import java.time.LocalDate;

public class ReportController implements Comparable{
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

    @Override
    public int compareTo(Object o) throws IllegalArgumentException{
        if(!(o instanceof ReportController)) throw new IllegalArgumentException("Argument not date");
        if(m.getDate().isBefore(((ReportController) o).getM().getDate())) {
            return -1;
        }else if(m.getDate().isAfter(((ReportController) o).getM().getDate())) {
            return 1;
        }else {
            return 0;
        }
    }
}
