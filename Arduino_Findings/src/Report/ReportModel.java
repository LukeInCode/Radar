package Report;

import java.time.LocalDate;

public class ReportModel {
        private int reveled;
        private LocalDate date;
        public ReportModel(int reveled, LocalDate date) throws IllegalArgumentException{
            if(reveled < 0 || date == null) {
                throw new IllegalArgumentException("Arguments passed are not valid");
            }
            this.reveled = reveled;
            this.date = date;
        }

        public int getReveled() {
            return reveled;
        }

        public LocalDate getDate() {
            return date;
        }
}
