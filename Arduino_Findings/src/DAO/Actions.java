package DAO;

import java.sql.ResultSet;

public interface Actions {
    public boolean addReport(int id, byte revelation, String date);
    public ResultSet getReport(int id);
}
