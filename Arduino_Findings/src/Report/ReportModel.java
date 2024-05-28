package Report;
import java.time.LocalDate;

/**
 * Model class for Report
 */
public class ReportModel {
        private int reveled;
        private LocalDate date;

    /**
     * @param reveled - distance parameter
     * @param date - object date used for get the actual date
     * @throws IllegalArgumentException - if the distance parameter and the date are null
     */
        public ReportModel(int reveled, LocalDate date) throws IllegalArgumentException{
            if(reveled < 0 || date == null) {
                throw new IllegalArgumentException("Arguments passed are not valid");
            }
            this.reveled = reveled;
            this.date = date;
        }

    /**
     * Method for get the distance
     * @return reveled - distance parameter
     */
        public int getReveled() {
            return reveled;
        }

    /**
     * Method for get the date
     * @return date - object date
     */
        public LocalDate getDate() {
            return date;
        }
}
