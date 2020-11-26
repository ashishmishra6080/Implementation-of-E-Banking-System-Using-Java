
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random; 

public class createaccount  extends JFrame implements ActionListener
{     JLabel head,name,dob,aadhar1,pin,day,month,year,panno;
      JComboBox c1,c2,c3;
      JTextField t1,t2,t3,t4,tx,t5;
      JButton b1;
      JPanel p1;
     public createaccount()
       { setTitle("New Account Screen");
  head=new JLabel("---Create A New  Account---");
       name=new JLabel("Enter Your Name");
          dob=new JLabel("Enter Your D.O.B");
          aadhar1=new JLabel("Enter Your Aadhar No");
          pin=new JLabel("Enter PIN Of Your Choice");
          panno=new JLabel("Enter Your Panno");
          day=new JLabel("Day");
          month=new JLabel("Month");
          year=new JLabel("Year");
          String s1[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
          String s2[]= {"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
          c1=new  JComboBox(s1);
          c2=new JComboBox(s2);
          b1=new JButton("Create My Account");
          p1=new JPanel();
          t1=new JTextField();
          t2=new JTextField();
          t3=new JTextField();
          t4=new JTextField();
          tx=new JTextField();
          t5=new JTextField();

          head.setBounds(140,20,200,20);
          name.setBounds(40,50,100,20);
          t1.setBounds(170,50,210,20);
          day.setBounds(170,75,40,20);
          month.setBounds(240,75,40,20);
          year.setBounds(340,75,40,20);
          dob.setBounds(40,100,100,20);
           c1.setBounds(160,100,50,20);
           c2.setBounds(230,100,80,20);
           t2.setBounds(330,100,50,20);
           aadhar1.setBounds(40,140,200,20);
           t3.setBounds(220,140,160,20);
           pin.setBounds(40,180,160,20);
           t4.setBounds(220,180,160,20);
           panno.setBounds(40,220,200,20);
           t5.setBounds(220,220,160,20);
           b1.setBounds(160,250,160,20);
           
           
         p1.add(head); 
         p1.add(name);
         p1.add(t1);
         p1.add(day);
         p1.add(dob);
         p1.add(month);
         p1.add(year);
         p1.add(c1);
         p1.add(c2);
         p1.add(t2);
         p1.add(aadhar1);
         p1.add(t3);
         p1.add(pin);
         p1.add(t4);
         p1.add(b1);
         p1.add(panno);
         p1.add(t5);
         
         add(p1);
         
         p1.setBackground(Color.gray);
         b1.setBackground(Color.cyan);
         
          setResizable(false);        
          p1.setLayout(null);
          setSize(440,320);
          setVisible(true);
          
         b1.addActionListener(this);
     }     
       public void actionPerformed(ActionEvent e)
       { 
        Random rand = new Random(); 

		
		int i1 = rand.nextInt(1000); 
		int i2 = rand.nextInt(1000); 
                int i3 = rand.nextInt(1000); 
                String s1= Integer.toString(i1);
		String s2= Integer.toString(i2);
                String s3= Integer.toString(i3); 
	        String sx=s1+s2+s3;
                tx.setText(sx);  



        String name1,dob1,acno1,pin1,bal1,pan1,aadhar1;
         name1=t1.getText();
        dob1=""+c1.getItemAt(c1.getSelectedIndex())+"-"+c2.getItemAt(c2.getSelectedIndex())+"-"+t2.getText();
         acno1=tx.getText();
         pin1=t4.getText();
         bal1=""+0;
         pan1=t5.getText();
         aadhar1=t3.getText();

        if(t1.getText().isEmpty()||t2.getText().isEmpty()||t3.getText().isEmpty()||t4.getText().isEmpty()||t5.getText().isEmpty())
         {
           JOptionPane.showMessageDialog(this,"Please Fill All Details First");
           
         }
         else
         {
           
           try
           {
                String w=(String)t1.getText();
            String m=(String)t2.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/worldbank", "root", "root");
                 Statement s=c.createStatement();
             s.executeUpdate("insert into acc3 values('"+name1+"','"+dob1+"','"+acno1+"','"+pin1+"','"+bal1+"','"+aadhar1+"','"+pan1+"')");
           
              c.close();
           }
           catch(Exception ee)
           {
             
           }
           
               JOptionPane.showMessageDialog(this,"Created Account Successfully. Your Account Number is : "+ acno1);
               
         }
       }  
       
    
    public static void main(String p[])
     {   createaccount c1=new createaccount();
     
     }
          
}     
     
   

