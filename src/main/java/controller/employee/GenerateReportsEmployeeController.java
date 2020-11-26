package controller.employee;

import factory.ComponentFactory;
import model.Report;
import model.User;
import repository.EntityNotFoundException;
import repository.user.AuthenticationException;
import service.report.ReportService;
import service.user.UserService;
import view.employee.GenerateReportsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class GenerateReportsEmployeeController {

    GenerateReportsView generateReportsView;

    private final ComponentFactory componentFactory;
    private final ReportService reportService;
    private final UserService userService;
    private static int indexReport = 1;

    public GenerateReportsEmployeeController(GenerateReportsView generateReportsView) {
        this.generateReportsView = generateReportsView;
        this.componentFactory = ComponentFactory.getInstance();
        this.reportService = componentFactory.getReportService();
        this.userService = componentFactory.getUserService();
        generateReportsView.setBtnGenerate(new ButtonGenerateReportsListener());
        generateReportsView.setBtnBack(new ButtonBackListener());
    }

    private class ButtonBackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            generateReportsView.setVisible(false);
        }
    }

    private class ButtonGenerateReportsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Long start = Long.valueOf(generateReportsView.getTxtStart().getText());
            Long end = Long.valueOf(generateReportsView.getTxtEnd().getText());
            String username = generateReportsView.getTxtUsername().getText();
            try {
                userService.findByUsername(username);
            } catch (EntityNotFoundException | AuthenticationException exception) {
                JOptionPane.showMessageDialog(generateReportsView.getContentPane(), "The employee username doesn't exists!");
            }
            try {
                List<Report> reports = reportService.findByUsernameAndPeriod(username, start, end);
                FileOutputStream file = new FileOutputStream("report_" + indexReport + ".txt");
                PrintStream data = new PrintStream(file);
                if(reports.isEmpty()) {
                    data.println("No operation was recorded!");
                } else {
                    for (Report report : reports) {
                        data.println("Moment time: " + report.getId() + " -> " + "The employee " + report.getUsername() +
                                " performed the operation: " + report.getOperation());
                    }
                }
            } catch (FileNotFoundException fileNotFoundException) {
                JOptionPane.showMessageDialog(generateReportsView.getContentPane(), "File not found!");
            } catch (EntityNotFoundException entityNotFoundException) {
                entityNotFoundException.printStackTrace();
            }
            indexReport++;
        }
    }


}
