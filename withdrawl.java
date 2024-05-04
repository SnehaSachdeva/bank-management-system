/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;// for date class

public class withdrawl extends JFrame implements ActionListener{
    JLabel text;
     JTextField amount;
     JButton withdrwal , back;
    String pin; 
    
    withdrawl(String pin){
        this.pin =pin;
            setLayout(null);
            
         ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);   
         
        text = new JLabel("Enter Amount you want to withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("Times New Roman",Font.BOLD,22));
        text.setBounds(170,300,400,30);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Times New Roman",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdrwal =new JButton("withdraw");
        withdrwal.setFont(new Font("Times New Roman",Font.BOLD,16));
        withdrwal.setBackground(Color.orange);
        withdrwal.setBounds(160,425,150,30);
        withdrwal.addActionListener(this);
        image.add(withdrwal);
        
         back= new JButton("BACK");
         back.setBounds(350,425,150,30);
         back.setBackground(Color.orange);
         back.setFont(new Font("Times new Roman",Font.BOLD , 16));
       back.addActionListener(this);
         image.add(back);
        
         
        //do we have to set this everytime ...can't we set it in default by setting in one class??
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);  
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrwal){
            String inputAmount = amount.getText();
            Date date = new Date();
            if(inputAmount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount ");
            }
            else {
                try{
                Conn conn= new Conn();
                String query ="insert into bank values('"+pin+"','"+date+"','Withdraw','"+inputAmount+"')";
                      conn.s.executeUpdate(query);
                      JOptionPane.showMessageDialog(null,"Rs"+ inputAmount+"Withdraw Succesfully");
                      setVisible(false);
                      new Transactions(pin).setVisible(true);
;            }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
            
        }
    }
    public static void main(String[] args){
        new deposit("");
    }
}
