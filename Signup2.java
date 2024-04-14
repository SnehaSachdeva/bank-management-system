package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup2 extends JFrame implements ActionListener {

    // Declare GUI components
    JLabel religion, category, income, educational, qual, addDetails, pan, adhar, seniorC, Existing;
    JComboBox<String> categoryBox, relg, educationalBox;
    JTextField adharText, panText, incomeText;
    JRadioButton yes, no, ExYes, ExNo;
    JButton next;
    String formno;

    Signup2(String formno) {
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");

        addDetails = new JLabel("Page 2: Additional Details ");
        addDetails.setFont(new Font("Railway", Font.BOLD, 22));
        addDetails.setBounds(290, 50, 300, 50);
        add(addDetails);

        // Religion
        religion = new JLabel("RELIGION:");
        religion.setFont(new Font("Railway", Font.BOLD, 20));
        religion.setBounds(100, 140, 200, 30);
        add(religion);

        String[] valRelg = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        relg = new JComboBox<>(valRelg);
        relg.setBounds(300, 140, 400, 30);
        add(relg);

        // Category
        category = new JLabel("CATEGORY:");
        category.setFont(new Font("Railway", Font.BOLD, 20));
        category.setBounds(100, 210, 200, 30);
        add(category);

        String[] valCat = {"General", "OBC", "SC", "ST", "Other"};
        categoryBox = new JComboBox<>(valCat);
        categoryBox.setFont(new Font("Railway", Font.BOLD, 14));
        categoryBox.setBounds(300, 210, 400, 30);
        add(categoryBox);

        // Income
        income = new JLabel("INCOME:");
        income.setFont(new Font("Railway", Font.BOLD, 20));
        income.setBounds(100, 280, 200, 30);
        add(income);

        incomeText = new JTextField();
        incomeText.setFont(new Font("Railway", Font.BOLD, 14));
        incomeText.setBounds(300, 280, 400, 30);
        add(incomeText);

        // Senior Citizen
        seniorC = new JLabel("SENIOR CITIZEN:");
        seniorC.setFont(new Font("Railway", Font.BOLD, 20));
        seniorC.setBounds(100, 350, 200, 30);
        add(seniorC);

        yes = new JRadioButton("Yes");
        yes.setBounds(400, 350, 100, 30);
        yes.setBackground(Color.white);
        add(yes);
        no = new JRadioButton("No");
        no.setBounds(500, 350, 100, 30);
        no.setBackground(Color.white);
        add(no);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(yes);
        seniorGroup.add(no);

        // Educational Qualification
        educational = new JLabel("EDUCATIONAL");
        educational.setFont(new Font("Railway", Font.BOLD, 20));
        educational.setBounds(100, 395, 200, 30);
        add(educational);
        qual = new JLabel("QUALIFICATION:");
        qual.setFont(new Font("Railway", Font.BOLD, 20));
        qual.setBounds(100, 420, 200, 30);
        add(qual);

        String[] valEdu = {"Metric", "Undergraduate", "Graduate", "PostGraduate", "Ph.D"};
        educationalBox = new JComboBox<>(valEdu);
        educationalBox.setFont(new Font("Railway", Font.BOLD, 14));
        educationalBox.setBounds(300, 420, 400, 30);
        add(educationalBox);

        // Existing Account
        Existing = new JLabel("EXISTING ACCOUNT:");
        Existing.setFont(new Font("Railway", Font.BOLD, 20));
        Existing.setBounds(100, 490, 300, 30);
        add(Existing);

        ExYes = new JRadioButton("Yes");
        ExYes.setBounds(400, 490, 100, 30);
        ExYes.setBackground(Color.white);
        add(ExYes);
        ExNo = new JRadioButton("No");
        ExNo.setBounds(500, 490, 100, 30);
        ExNo.setBackground(Color.white);
        add(ExNo);

        ButtonGroup accGroup = new ButtonGroup();
        accGroup.add(ExYes);
        accGroup.add(ExNo);

        // Adhar Number
        pan = new JLabel("ADHAR NUMBER:");
        pan.setFont(new Font("Railway", Font.BOLD, 20));
        pan.setBounds(100, 560, 200, 30);
        add(pan);

        panText = new JTextField();
        panText.setFont(new Font("Railway", Font.BOLD, 14));
        panText.setBounds(300, 560, 400, 30);
        add(panText);

        // PAN Number
        adhar = new JLabel("PAN NUMBER:");
        adhar.setFont(new Font("Railway", Font.BOLD, 20));
        adhar.setBounds(100, 630, 200, 30);
        add(adhar);

        adharText = new JTextField();
        adharText.setFont(new Font("Railway", Font.BOLD, 14));
        adharText.setBounds(300, 630, 400, 30);
        add(adharText);

        // Next Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(620, 700, 80, 30);
        add(next);
        next.addActionListener(this); // Action Listener added here

        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
       String Sreligion = (String) relg.getSelectedItem();
        String Scategory = (String) categoryBox.getSelectedItem();
        String Sincome = incomeText.getText();

        String seniorCS = null;
        if (yes.isSelected()) {
            seniorCS = "Yes";
        } else if (no.isSelected()) {
            seniorCS = "No";
        }

        String Seducational = (String) educationalBox.getSelectedItem();

        String SexistingAcc = null;
        if (ExYes.isSelected()) {
            SexistingAcc = "Yes";
        } else if (ExNo.isSelected()) {
            SexistingAcc = "No";
        }

        String Sadhar = adharText.getText();
        String Span = panText.getText();

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "','" + Sreligion + "','" + Scategory + "','" + Sincome + "','" + Seducational + "','" + Span + "','" + Sadhar + "','" + seniorCS + "','" + SexistingAcc + "')";
            c.s.execute(query);
            System.out.println("execute success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new Signup2("");
    }
}
