
package bank.management.system;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;

public class Login  extends JFrame implements ActionListener{
        //    ActionListener interface so that it carries value input and perform some action after clicking on buttons
    JButton login,clear,Signup;
// button define globally for easilly accessible
    JTextField cardtext;
    JPasswordField pintext;// for password and provide invisiblity of pin

    Login(){
        setTitle("AUTOMATED TELLER MACHINE (ATM)");
        
        setLayout(null);// remove the bydefault layout of frame so that we create custom layout further
        //setting icon using Imageicon class from java swing
       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
       //give size and scalling to image logo using ScaledInstance method and image classs from AWT     
       Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
       
        //JLabel class add Imageicon obj but not Image object i2
           // so we pass i2 to i3 Imageicon object 
       ImageIcon i3 =  new ImageIcon(i2);
       JLabel label = new JLabel(i3);
       //setting location of label/logo in frame so we use setbound(dist from left, top, height, widht)
       label.setBounds(100,30,100,100);//custom layout
        
       add(label);//display or add image icon from jlable
        //
       JLabel text =new JLabel("WELCOME TO ATM");
       text.setFont(new Font("Osward",Font.BOLD,38));
       text.setBounds(200,60,400,40);
       add(text);
       
      //card no.
       JLabel cardno =new JLabel("Card No: ");
       cardno.setFont(new Font("Railway",Font.BOLD,28));
       cardno.setBounds(120,150,150,30);
       add(cardno);
        
       //adding a text box for user entry for card no. 
       cardtext=new JTextField();
       cardtext.setBounds(300,150,230,30);
       cardtext.setFont(new Font("Arial", Font.BOLD, 14));
       add(cardtext);
       
       // pin 
       JLabel pin =new JLabel("PIN:");
       pin.setFont(new Font("Railway",Font.BOLD,28));
       pin.setBounds(120,200,400,30);
       add(pin);
       
       //adding a text box for user entry for pin no. 
       pintext=new JPasswordField();
       pintext.setBounds(300,200,230,30);
       pintext.setFont(new Font("Arial", Font.BOLD, 14));
       add(pintext);
       
       //sign in button
       login=  new JButton("SIGN IN");
       login.setBounds(300,300,100,30);
       login.setBackground(Color.blue);
       login.setForeground(Color.WHITE);
       // add to all buttons for action perform
       login.addActionListener(this);
       add(login);
       
       clear=  new JButton("CLEAR");
       clear.setBounds(430,300,100,30);
       clear.setBackground(Color.blue);
       clear.setForeground(Color.WHITE);
       clear.addActionListener(this);
       add(clear);
       
       Signup=new JButton("SIGN UP");
       Signup.setBounds(300,350,230,30);
       Signup.setBackground(Color.blue);
       Signup.setForeground(Color.WHITE);
       Signup.addActionListener(this);
       add(Signup);
       
      
       getContentPane().setBackground(Color.WHITE);//awt
        
        setSize(800,480);//set size of length and breadth of frame
        setVisible(true);//show the frame
        setLocation(350,200);
//by default frame open in top left corner of scree so we ae setting location giving margin  (left,right)
        

    }
    public static void main(String args[]){
        new Login();
    }
    @Override// should be added because of interface
    // it perform action after clicking on button so we define here in this method
    public void actionPerformed(ActionEvent e) {
 
         if (e.getSource() == clear){
             cardtext.setText("");//set text in input textbox manually
             pintext.setText("");
         }
         else if(e.getSource() == login){
             
         }
         else if (e.getSource()== Signup){
             setVisible(false);
             new SignupOne().setVisible(true);
         }
    }


}
