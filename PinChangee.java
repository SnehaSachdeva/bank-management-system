
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChangee extends JFrame implements ActionListener{
     JLabel text,pintext,reEnter;
     JPasswordField npin,repin;
     JButton back,change;
    String pin;
    PinChangee(String pin){
         this.pin=pin;
            setLayout(null);
         ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("icons/atm45.jpg"));
         Image i2 = i.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,800);
         add(image);  
           text =new JLabel("CHANGE YOUR PIN");
//            text.setForeground(Color.white);
            text.setFont(new Font("System",Font.BOLD,22));
            text.setBounds(300,230,500,30);
            image.add(text);
            
            pintext =new JLabel("Enter your new pin of 4 digit:");
//            pintext.setForeground(Color.white);
            pintext.setFont(new Font("System",Font.BOLD,16));
            pintext.setBounds(180,280,500,30);
            image.add(pintext);
            
            npin =new  JPasswordField();
            npin.setForeground(Color.black);
            npin.setFont(new Font("System",Font.BOLD,16));
            npin.setBounds(400,280,100,30);
            image.add(npin);
             
            
            reEnter =new JLabel("Re-Enter your new pin:");
//            reEnter.setForeground(Color.white);
            reEnter.setFont(new Font("System",Font.BOLD,16));
            reEnter.setBounds(180,330,500,30);
            image.add(reEnter);
            
            repin =new  JPasswordField();
            repin.setForeground(Color.black);
            repin.setFont(new Font("System",Font.BOLD,16));
            repin.setBounds(400,330,100,30);
            image.add(repin);
         
             back =new JButton("BACK");
             back.setBackground(Color.LIGHT_GRAY);
             back.setForeground(Color.white);
             back.setFont(new Font("System",Font.BOLD,16));
             back.setBounds(200,400,100,30);
             back.addActionListener(this);
            image.add( back );
            
             change =new JButton("CHANGE PIN");
             change.setBackground(Color.LIGHT_GRAY);
             change.setForeground(Color.white);
             change.setFont(new Font("System",Font.BOLD,16));
             change.setBounds(500,400,200,30);
             change.addActionListener(this);
            image.add( change );

          // framing dimensions
        setSize(900,850);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);//bcz bydefault its false and unvisible to users
        //should be in end setVisible
        //
         
    }
     public static void main(String []args){
        new PinChangee("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== change){
        try{
            String opin = npin.getText();
            String rpin = repin.getText();
            if(opin.equals("") || rpin.equals("")){
                 JOptionPane.showMessageDialog(null,"PLEASE ENTER PIN:");
                 return;
            }
            else if(!opin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Enter pin does not match");
                return;
            }
            Conn c = new Conn();
            String query = "update bank set pin= '"+rpin+"' where pin ='"+pin+"' ";
            String q2="update login set pin= '"+rpin+"' where pin ='"+pin+"' ";
            String q3="update signupthree set pin= '"+rpin+"' where pin ='"+pin+"' ";
        
            c.s.executeQuery(query);
            
            c.s.executeQuery(q2);
            
            c.s.executeQuery(q3);
            JOptionPane.showMessageDialog(null,"PIN changed succesfully");
            setVisible(false);
            new Transactions("").setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transactions("").setVisible(true);
        }
    }

}
