package bank.management.system;

import javax.swing.*;
import java.awt.*;//seft background
import java.util.*; // for random class
import java.awt.event.*;
import java.sql.SQLException;

public class Signup3 extends JFrame implements ActionListener {
    JLabel l1,type,cardno,number,cDetails,pin,pinN,pinD,services; 
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6, c7;
    JButton submit,cancel;
    String formno;
    Signup3(String formno){
        this.formno = formno;
        
        setLayout(null);
        
        l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Railway",Font.BOLD,22));
        l1.setBounds(280, 40, 400,40);
        add(l1);
        
        type=new JLabel("Account Type:");
        type.setFont(new Font("Railway",Font.BOLD,22));
        type.setBounds(100, 140, 200,30);
        add(type);
        
         r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Railway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100, 180, 250,20);
        add(r1);
        
         r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Railway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350, 180, 250,20);
        add(r2);
        
         r3=new JRadioButton("Fixed Deposit (FD)");
        r3.setFont(new Font("Railway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100, 220, 250,20);
        add(r3);
         r4=new JRadioButton("Reccuring Deposit (RD)");
        r4.setFont(new Font("Railway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350, 220, 250,20);
        add(r4);
            
        ButtonGroup grpAcc= new ButtonGroup();
        grpAcc.add(r1);
        grpAcc.add(r2);
        grpAcc.add(r3);
        grpAcc.add(r4);
        
        cardno=new JLabel("Card number:");
        cardno.setFont(new Font("Railway",Font.BOLD,22));
        cardno.setBounds(100, 300, 200,30);
        add(cardno);
        
        number=new JLabel("xxxx-xxxx-xxxx-8888");
       number.setFont(new Font("Railway",Font.BOLD,22));
        number.setBounds(330, 300, 300,30);
        add(number);
        
        cDetails=new JLabel("Your 16 digit card number");
        cDetails.setFont(new Font("Railway",Font.BOLD,12));
        cDetails.setBounds(100, 330, 300,30);
        add(cDetails);
        
        pin=new JLabel("PIN: ");
        pin.setFont(new Font("Railway",Font.BOLD,22));
        pin.setBounds(100, 380, 300,30);
        add(pin);
        
        pinD=new JLabel("Your 4 digit Password");
        pinD.setFont(new Font("Railway",Font.BOLD,12));
        pinD.setBounds(100, 410, 300,30);
        add(pinD);
       pinN=new JLabel("xxxx");
       pinN.setFont(new Font("Railway",Font.BOLD,22));
        pinN.setBounds(330, 380, 300,30);
        add(pinN);
        
        services=new JLabel("Services Required: ");
        services.setFont(new Font("Railway",Font.BOLD,22));
        services.setBounds(100, 460, 300,30);
        add(services);
        //check BOX
        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Railway",Font.BOLD,18));
        c1.setBounds(100, 500, 200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Railway",Font.BOLD,18));
        c2.setBounds(400, 500, 200,30);
        add(c2);
        
       
        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Railway",Font.BOLD,18));
        c3.setBounds(100, 550, 200,30);
        add(c3);
        
        c4=new JCheckBox("Email and SMS alerts");
        c4.setFont(new Font("Railway",Font.BOLD,18));
        c4.setBounds(400, 550, 300,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Railway",Font.BOLD,18));
        c5.setBounds(100, 600, 200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Railway",Font.BOLD,18));
        c6.setBounds(400, 600, 200,30);
        add(c6);
        
        
        //
        c7=new JCheckBox("I hereby declares that above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Railway",Font.BOLD,12));
        c7.setBounds(100, 640, 1000,30);
        add(c7);
        
         
//button
       cancel =new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Railway",Font.BOLD,14));
        cancel.setBounds(200,700,100,30);
        cancel.addActionListener(this);
        add(cancel);
         //button
        submit =new JButton("Submit");
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         submit.setFont(new Font("Railway",Font.BOLD,14));
         submit.setBounds(400,700,100,30);
         submit.addActionListener(this);
        add( submit);
        
       
         setSize(850,850);
        setLocation(350,0);
        setVisible(true);
        
}
    
    public static void main(String args[]){
        new Signup3("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()== submit){
            String accountType =null;
            if(r1.isSelected()){
                accountType ="Saving Account";
            }else if(r2.isSelected()){
                accountType="Current Account";
            }
            else if(r3.isSelected()){
                accountType="Fixed Deposit";
            }
            else if(r3.isSelected()){
                accountType="Reccuring Deposit";
            }
            Random ran =new Random();
            String cardnumber =""+ Math.abs((ran.nextLong()%90000000L) + 5040936000000000L);
            String pin =""+ Math.abs((ran.nextLong()%9000L)+1000L) ;
            String facility ="";
            if(c1.isSelected()){
               facility = facility + " ATM CARD";
            }else if(c2.isSelected()){
                 facility = facility + " Internet Banking";

            }
            else if(c3.isSelected()){
                 facility = facility + " Mobile Banking";

            }
            else if(c4.isSelected()){
                 facility = facility + " Email and SMS alerts";

            }
            else if(c5.isSelected()){
                 facility = facility + " Cheque Book";

            }
            else if(c6.isSelected()){
                 facility = facility + " E-Statement";
            }
            try{
                 if (accountType.equals("")) {
            JOptionPane.showMessageDialog(null, "Account type is Required");
        } else {
                     Conn conn =new Conn();
                  
                     
                     String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pin+"','"+facility+"')";
                     conn.s.executeUpdate(query1);
                     //
                     String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pin+"')";
                      conn.s.executeUpdate(query2);
                      
            JOptionPane.showMessageDialog(null, "Card number"+ cardnumber+"\n Pin:" + pin);

                 }
                
            }
            catch(Exception e){
                System.out.println(e);
            }
            
       }
    else if(ae.getSource()== cancel){
          
       }
    }
}
