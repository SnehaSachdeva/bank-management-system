package bank.management.system;

import javax.swing.*;
import java.awt.*;//seft background
import java.util.*; // for random class
import java.awt.event.*;
import com.toedter.calendar.*;
//import java.text.SimpleDateFormat;

public class SignupOne extends JFrame implements ActionListener {
    //use jlabel,radio buttons,text field, calender
    JLabel name,fname,state,pincode,PersonalDetails,formno,dob,city,gender,address,email,marital;
    JTextField nameText,fnameText,emailText, addressText,cityText,stateText,pincodeText;
    long random;
     JDateChooser date;
     JRadioButton male,female,other,married,unmarried,notClosed;
     JButton next;
     
    SignupOne(){
        setLayout(null); 
        
        Random ran = new Random();
        random=(Math.abs(ran.nextLong()% 9000L)+1000L);
        
       formno= new JLabel("APPLICATION FORM NO.  "+ random); 
        formno.setFont(new Font("Railway",Font.BOLD,34));
        formno.setBounds(140, 20, 600, 40 );
        add(formno);
        
        PersonalDetails= new JLabel("Page 1: Personal Details "); 
        PersonalDetails.setFont(new Font("Railway",Font.BOLD,22));
        PersonalDetails.setBounds(290, 80, 600, 30);
        add(PersonalDetails);
        
        //name
        name= new JLabel("NAME:"); 
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(100, 140, 200, 30);
        add(name);
        
        //nameTextfield
        nameText= new JTextField();
        nameText.setFont(new Font("Railway",Font.BOLD,14));
        nameText.setBounds(300,140,400,30);
        add(nameText);
        
        //father name
        fname= new JLabel("FATHER's NAME:"); 
        fname.setFont(new Font("Railway",Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameText= new JTextField();
        fnameText.setFont(new Font("Railway",Font.BOLD,14));
        fnameText.setBounds(300,190,400,30);
        add(fnameText);
        
        
        dob= new JLabel("DATE OF BIRTH:"); 
        dob.setFont(new Font("Railway",Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        //calender adding//import jar file Jcalender in Libraries folder
         date=new JDateChooser();
         date.setBounds(300, 240, 400, 30);
         date.setForeground(new Color(105,105,105));
        add(date);
        
        gender= new JLabel("GENDER:"); 
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        //RadioButton
        male=new JRadioButton("MALE");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.white);
        add(male);
      female=new JRadioButton("FEMALE");
        female.setBounds(400,290,100,30);
        female.setBackground(Color.white);
        add(female);
        //
       notClosed=new JRadioButton("others");
            notClosed.setBounds(500,290,100,30);
            notClosed.setBackground(Color.white);
        add( notClosed);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(notClosed);
         
        
        email= new JLabel("EMAIL ADDRESS:"); 
        email.setFont(new Font("Railway",Font.BOLD,20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        //
        emailText= new JTextField();
       emailText.setFont(new Font("Railway",Font.BOLD,14));
        emailText.setBounds(300,340,400,30);
        add(emailText);
        
        
        marital= new JLabel("MARITAL STATUS:"); 
        marital.setFont(new Font("Railway",Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        //
         married=new JRadioButton("Married");
            married.setBounds(300,390,100,30);
            married.setBackground(Color.white);
        add( married);
           unmarried=new JRadioButton("Unmarried");
            unmarried.setBounds(400,390,100,30);
            unmarried.setBackground(Color.white);
        add( unmarried);
        other=new JRadioButton("Other");
            other.setBounds(500,390,100,30);
            other.setBackground(Color.white);
        add( other);
        //for not selecting more than one option
         ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        address= new JLabel("ADDRESS:"); 
        address.setFont(new Font("Railway",Font.BOLD,20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        //
        addressText= new JTextField();
        addressText.setFont(new Font("Railway",Font.BOLD,14));
         addressText.setBounds(300,440,400,30);
        add( addressText);
        
        city= new JLabel("CITY:"); 
        city.setFont(new Font("Railway",Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        //
         cityText= new JTextField();
        cityText.setFont(new Font("Railway",Font.BOLD,14));
         cityText.setBounds(300,490,400,30);
        add( cityText);
        
        state= new JLabel("STATE:"); 
        state.setFont(new Font("Railway",Font.BOLD,20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        //
        stateText= new JTextField();
        stateText.setFont(new Font("Railway",Font.BOLD,14));
        stateText.setBounds(300,540,400,30);
        add( stateText);
        
        pincode= new JLabel("PINCODE:"); 
        pincode.setFont(new Font("Railway",Font.BOLD,20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        //
        pincodeText= new JTextField();
        pincodeText.setFont(new Font("Railway",Font.BOLD,14));
        pincodeText.setBounds(300,590,400,30);
        add( pincodeText);
        
        //button
        next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);//bg color of page
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae) {
    String formno = "" + random; // long value convert to string by adding ""
    String name = nameText.getText(); // fetch value from text field
    String fname = fnameText.getText();
    String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
    String gender = null;
    if (male.isSelected()) {
        gender = "Male";
    } else if (female.isSelected()) {
        gender = "Female";
    } else if (notClosed.isSelected()) {
        gender = "other";
    }

    String email = emailText.getText();
    String marital = null;
    if (married.isSelected()) {
        marital = "Married";
    } else if (unmarried.isSelected()) {
        marital = "Unmarried";
    } else if (other.isSelected()) {
        marital = "Other";
    }
    String address = addressText.getText();
    String city = cityText.getText();
    String state = stateText.getText();
    String pincode = pincodeText.getText();

    try {
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name is Required");
        } else if (fname.equals("")) {
            JOptionPane.showMessageDialog(null, " Father Name is Required");
        } else if (dob.equals("")) {
            JOptionPane.showMessageDialog(null, " Date of Birth is Required");
        } else if (address.equals("")) {
            JOptionPane.showMessageDialog(null, " Address is Required");
        } else if (pincode.equals("")) {
            JOptionPane.showMessageDialog(null, " Pincode is Required");
        } else if (city.equals("")) {
            JOptionPane.showMessageDialog(null, " city is Required");
        } else if (state.equals("")) {
            JOptionPane.showMessageDialog(null, " state is Required");
        } else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, " Email is Required");
        } else if (marital.equals("")) {
            JOptionPane.showMessageDialog(null, " Marital Status is Required");
        } else if (gender.equals("")) {
            JOptionPane.showMessageDialog(null, "Gender is Required");
        } else {
            // Format date
 
//SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
//java.util.Date dobDate = dateFormat.parse(dob);
//java.sql.Date dobS = new java.sql.Date(dobDate.getTime());

            // Insert data into the database
            Conn c = new Conn();
            String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + marital + "','" + address + "','" + city + "','" + state + "','" + pincode + "','" + email + "')";
            c.s.execute(query); // execution of query
            System.out.println("execute success");
            
            setVisible(false);
            new Signup2(formno).setVisible(true);
            
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}

    public static void main(String args[]){
        new SignupOne();
    }

}
