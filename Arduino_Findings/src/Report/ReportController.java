package Report;


/**
 * Controller class of Report
 */
public class ReportController {
    private ReportModel m;
    private ReportView v;

    /**
     * @param m - Model object
     * @param v - View object
     * @throws NullPointerException - if the model and the view obejects are null
     */
    public ReportController(ReportModel m, ReportView v) throws NullPointerException{
        if(m == null || v == null) {
            throw new NullPointerException("Values passed null");
        }
        this.m = m;
        this.v = v;
    }

    /**
     * Method for display the reports
     */
    public void displayReports() {
        v.view(m);
    }

    /**
     * Method for get the model object
     * @return m - model object
     */
    public ReportModel getM() {
        return m;
    }

    /**
     * Method for get the view object
     * @return v - view object
     */
    public ReportView getV() {
        return v;
    }
}
