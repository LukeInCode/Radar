package Report;

import java.time.LocalDate;

public class ReportModel {
        private int id;
        private int reveled;
        private LocalDate date;
        public ReportModel(int id, int reveled, LocalDate date) throws IllegalArgumentException{
            if(id < 0 || reveled < 0 || reveled > 1 || date == null) {
                throw new IllegalArgumentException("Arguments passed are not valid");
            }
            this.id = id;
            this.reveled = reveled;
            this.date = date;
        }
        public int getId() {
            return id;
        }

        public int getReveled() {
            return reveled;
        }

        public LocalDate getDate() {
            return date;
        }
}
