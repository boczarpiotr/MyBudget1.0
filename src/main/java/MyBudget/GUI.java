package MyBudget;

import javax.swing.*;
import java.time.LocalDate;

public class GUI {

    public static void createAndShowGUI() {


        JFrame frame = new JFrame("MyBudget 1.0");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 340);
        frame.setResizable(false);

        JLabel label1 = new JLabel("Type of outcome");
        JLabel label2 = new JLabel("Month");
        JLabel label3 = new JLabel("Amount");

        LocalDate localDate = LocalDate.now();
        String[] outcomeArray = {"Food", "Bills", "Pleasure", "Home Loan", "Other"};
        String[] monthArray = {"Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        JTextField todaysDate = new JTextField();
        todaysDate.setText(String.valueOf(localDate));

        JComboBox typeOfOutcome = new JComboBox(outcomeArray);
        JComboBox monthOfitem = new JComboBox(monthArray);

        JTextField outcome = new JTextField();

        JButton reportButton = new JButton("Get sum of outcome");
        reportButton.setBounds(20, 15, 150, 35);
        JButton button1 = new JButton("Add the outcome");
        button1.setBounds(140, 220, 150, 35);
        todaysDate.setBounds(305, 15, 72, 25);
        label1.setBounds(20, 50, 100, 50);
        typeOfOutcome.setBounds(140, 62, 100, 30);
        label2.setBounds(20, 100, 100, 50);
        monthOfitem.setBounds(140, 110, 100, 30);
        label3.setBounds(20, 150, 100, 50);
        outcome.setBounds(140, 160, 100, 30);

        button1.addActionListener(actionEvent -> {

            Item item = new Item();
            try {
                item.setOutcome(Double.parseDouble(String.valueOf(outcome.getText())));
                item.setDate(todaysDate.getText());
                item.setKindOfOutcome(typeOfOutcome.getSelectedItem().toString());
                item.setMonth(monthOfitem.getSelectedItem().toString());

                DAO.insertItem(item.getDate(), item.getKindOfOutcome(), item.getMonth(), item.getOutcome());
                JOptionPane.showMessageDialog(null, "You have just added this item:\n " + item
                        + "\n to database.");

            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "You have just entered invalid input in field 'Amount'. Maybe try with number =)");
            }


        });
        reportButton.addActionListener(actionEvent -> {

            JFrame reportFrame = new JFrame("Reports");
            reportFrame.setSize(400, 400);
            reportFrame.setVisible(true);
            reportFrame.setLayout(null);

            JComboBox sumForMonthCombo = new JComboBox(monthArray);
            sumForMonthCombo.setBounds(40, 70, 140, 30);

            JComboBox sumForKindCombo = new JComboBox(outcomeArray);
            sumForKindCombo.setBounds(220, 70, 140, 30);

            JButton generateReportButtonByMonth = new JButton("Get sum for month");
            generateReportButtonByMonth.setBounds(40, 150, 140, 40);

            JButton generateReportButtonByKind = new JButton("Get sum for kind");
            generateReportButtonByKind.setBounds(220, 150, 140, 40);

            generateReportButtonByMonth.addActionListener(actionEvent1 -> {
                String selectedMonth = sumForMonthCombo.getSelectedItem().toString();
                double sum = DAO.getSumOfOutcomeByMonth(selectedMonth);
                JOptionPane.showMessageDialog(null, "Sum of outcomes in month " + selectedMonth + " is: " + sum);
            });

            generateReportButtonByKind.addActionListener(actionEvent2-> {
                String selectedKind = sumForKindCombo.getSelectedItem().toString();
                double sum = DAO.getSumOfOutcomeByKind(selectedKind);
                JOptionPane.showMessageDialog(null, "Sum of outcomes for: " + selectedKind + " is " + sum);
            });


            reportFrame.add(generateReportButtonByMonth);
            reportFrame.add(generateReportButtonByKind);
            reportFrame.add(sumForMonthCombo);
            reportFrame.add(sumForKindCombo);

        });

        frame.add(button1);
        frame.add(reportButton);
        frame.add(todaysDate);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(typeOfOutcome);
        frame.add(monthOfitem);
        frame.add(outcome);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
