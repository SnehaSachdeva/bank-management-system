
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton Deposit, withdraw,fastcash, miniS ,pinChange ,Balance ,Exit;
    String pin;
    Transactions(String pin){// we use constructor bcz when we create class object ,it calls constructor
            this.pin =pin;// pin number
            
         ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);   
         
         JLabel trans = new JLabel(" Please select your Transaction ");
         trans.setBounds(210, 280, 700, 35);
         trans.setForeground(Color.white);
         trans.setFont(new Font("Times new Roman",Font.BOLD , 20));
         image.add(trans);
         
         Deposit = new JButton("Deposit");
         Deposit.setBounds(160,390,150,30);
         Deposit.setBackground(Color.CYAN);
         Deposit.setFont(new Font("Times new Roman",Font.BOLD , 16));
         Deposit.addActionListener(this);
         image.add(Deposit);
         
         withdraw = new JButton("Cash Withdrawl");
         withdraw.setBounds(350,390,150,30);
         withdraw.setBackground(Color.CYAN);
         withdraw.setFont(new Font("Times new Roman",Font.BOLD , 16));
         withdraw.addActionListener(this);
         image.add(withdraw);
         
         
         fastcash = new JButton("FastCash");
         fastcash.setBounds(160,425,150,30);
         fastcash.setBackground(Color.orange);
         fastcash.setFont(new Font("Times new Roman",Font.BOLD , 16));
         fastcash.addActionListener(this);
         image.add(fastcash);
         
         miniS = new JButton("Mini Statement");
         miniS.setBounds(160,460,150,30);
         miniS.setBackground(Color.CYAN);
         miniS.setFont(new Font("Times new Roman",Font.BOLD , 16));
         miniS.addActionListener(this);
         image.add(miniS);
         
         
         pinChange = new JButton("PIN Change");
         pinChange.setBounds(350,425,150,30);
         pinChange.setBackground(Color.orange);
         pinChange.setFont(new Font("Times new Roman",Font.BOLD , 16));
         pinChange.addActionListener(this);
         image.add(pinChange);
         
         Balance = new JButton("Balance Enquiry");
         Balance.setBounds(350,460,150,30);
         Balance.setBackground(Color.CYAN);
         Balance.setFont(new Font("Times new Roman",Font.BOLD , 16));
         Balance.addActionListener(this);
         image.add(Balance);
         
         Exit = new JButton("Exit");
         Exit.setBounds(350,495,150,30);
         Exit.setBackground(Color.orange);
         Exit.setFont(new Font("Times new Roman",Font.BOLD , 16));
         Exit.addActionListener(this);
         image.add(Exit);         
         
         // framing dimensions
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);//bcz bydefault its false and unvisible to users
        //should be in end setVisible
        //
         
         
    }
    public static void main(String []args){
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Exit){
            System.exit(0);
        }
        else if(ae.getSource() ==Deposit){
        setVisible(false);
        new deposit(pin).setVisible(true);
        }
        else if(ae.getSource() == withdraw){
        setVisible(false);
        new withdrawl(pin).setVisible(true);
        
        }
        else if(ae.getSource() == fastcash){
        setVisible(false);
        new FastCash(pin).setVisible(true);
        }
        else if(ae.getSource() == pinChange){
        setVisible(false);
        new PinChangee(pin).setVisible(true);
        }
    }
}
