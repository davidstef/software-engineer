package repository.report;

import model.Report;
import model.builder.ReportBuilder;
import repository.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static database.Constants.Tables.REPORT;

public class ReportRepositoryMySQL implements ReportRepository {

    private final Connection connection;

    public ReportRepositoryMySQL(Connection connection) { this.connection = connection; }

    @Override
    public boolean save(Report report) throws EntityNotFoundException {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("INSERT INTO repository_report values (null, ?, ?)");
            insertUserStatement.setString(1, report.getUsername());
            insertUserStatement.setString(2, report.getOperation());
            insertUserStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Report> findByUsernameAndPeriod(String username, Long start, Long end) throws EntityNotFoundException {
        List<Report> reports = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String fetchReportSql = "Select * from `" + REPORT + "` where `username`=\'" + username + "\' and `id`>\'" + start + "\' and `id`<\'" + end + "\'";
            ResultSet reportResultSet = statement.executeQuery(fetchReportSql);
            while(reportResultSet.next()) {
                Report report = new ReportBuilder()
                        .setId(reportResultSet.getLong("id"))
                        .setUsername(reportResultSet.getString("username"))
                        .setOperation(reportResultSet.getString("operation"))
                        .build();
                reports.add(report);
            }
            return reports;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
