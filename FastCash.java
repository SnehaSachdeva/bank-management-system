package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1, b2,b3,b4,b5,b6,b7;
    String pin;
    FastCash(String pin){// we use constructor bcz when we create class object ,it calls constructor
            this.pin =pin;// pin number
            
         ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);   
         
         JLabel trans = new JLabel(" Please select withdrawl amount ");
         trans.setBounds(210, 280, 700, 35);
         trans.setForeground(Color.white);
         trans.setFont(new Font("Times new Roman",Font.BOLD , 20));
         image.add(trans);
         
         b1 = new JButton("Rs 100");
         b1.setBounds(160,390,150,30);
         b1.setBackground(Color.CYAN);
         b1.setFont(new Font("Times new Roman",Font.BOLD , 16));
         b1.addActionListener(this);
         image.add(b1);
         
         b2 = new JButton("Rs 500");
         b2.setBounds(350,390,150,30);
         b2.setBackground(Color.CYAN);
         b2.setFont(new Font("Times new Roman",Font.BOLD , 16));
         b2.addActionListener(this);
         image.add(b2);
         
         
         b3 = new JButton("Rs 1000");
         b3.setBounds(160,425,150,30);
         b3.setBackground(Color.orange);
         b3.setFont(new Font("Times new Roman",Font.BOLD , 16));
         b3.addActionListener(this);
         image.add(b3);
         
         b4 = new JButton("Rs 2000");
         b4.setBounds(160,460,150,30);
         b4.setBackground(Color.CYAN);
         b4.setFont(new Font("Times new Roman",Font.BOLD , 16));
         b4.addActionListener(this);
         image.add(b4);
         
         
         b5 = new JButton("Rs 5000");
         b5.setBounds(350,425,150,30);
         b5.setBackground(Color.orange);
         b5.setFont(new Font("Times new Roman",Font.BOLD , 16));
         b5.addActionListener(this);
         image.add(b5);
         
         b6 = new JButton("Rs 10,000");
         b6.setBounds(350,460,150,30);
         b6.setBackground(Color.CYAN);
         b6.setFont(new Font("Times new Roman",Font.BOLD , 16));
         b6.addActionListener(this);
         image.add(b6);
         
         b7 = new JButton("Back");
         b7.setBounds(350,495,150,30);
         b7.setBackground(Color.orange);
         b7.setFont(new Font("Times new Roman",Font.BOLD , 16));
         b7.addActionListener(this);
         image.add(b7);         
         
         // framing dimensions
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);//bcz bydefault its false and unvisible to users
        //should be in end setVisible
        //
         
         
    }
    public static void main(String []args){
        new FastCash("");
    }

    @Override
    
    
       public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == b7) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    } else {
        String buttonText = ((JButton) ae.getSource()).getText();
        // Extracting the amount from the button text
        int amount = Integer.parseInt(buttonText.substring(3).replace(",", ""));
        Conn c = new Conn();
        try {
            // Retrieving the current balance for the user
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            // Checking if there's enough balance for withdrawal
            if (balance < amount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            // Inserting the withdrawal transaction into the database
            Date date = new Date();
            String query = "INSERT INTO bank VALUES('" + pin + "','" + date + "','Withdrawal','" + amount + "')";
            c.s.executeUpdate(query);
            // Updating the balance in the database
            String updateQuery = "UPDATE bank SET amount = amount - " + amount + " WHERE pin = '" + pin + "'";
            c.s.executeUpdate(updateQuery);
            JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

}
