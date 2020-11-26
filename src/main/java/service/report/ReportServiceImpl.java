package service.report;

import model.Report;
import model.builder.ReportBuilder;
import repository.EntityNotFoundException;
import repository.report.ReportRepository;

import java.util.List;

public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Report> findByUsernameAndPeriod(String username, Long start, Long end) throws EntityNotFoundException {
        if(start > end) {
            Long aux = start;
            start = end;
            end = aux;
        }
        return reportRepository.findByUsernameAndPeriod(username, start, end);
    }

    @Override
    public boolean save(String username, String operation) throws EntityNotFoundException {
        Report report = new ReportBuilder()
                .setUsername(username)
                .setOperation(operation)
                .build();
        return reportRepository.save(report);
    }
}
