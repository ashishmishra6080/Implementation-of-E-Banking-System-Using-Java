
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class alreadyaccount implements ActionListener
{  JFrame f1;
   JButton b1,b4,b5,b6;
   JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
   JTextField name,acno,pin,bal,t5,t6,t7,t8;
   JPanel p1;
   int add,remove,bala,result,trans;
   
   public alreadyaccount() 
   {  f1=new JFrame("Screen2");
      b1=new JButton("Login");
     
       b4=new JButton("Add Money");
      b5=new JButton("Withdrawl Money"); 
      b6=new JButton("Transfer");
      l0=new JLabel("Welcome To Login Screen");
      l1=new JLabel("Enter Your Account Number");
      l2=new JLabel("Enter Your PIN");
      l3=new JLabel("Name Of The Customer");
      l4=new JLabel("Balance");
     l5=new JLabel("For Deposit Money");
      l6=new JLabel("For Withdrawl Money");
      l7=new JLabel("Enter Amount");
      l8=new JLabel("Enter Amount");
      l9=new JLabel("Enter Account No To Transfer ");
      l10=new JLabel("Enter Amount To Transfer");
      name=new JTextField();   
      acno=new JTextField(); 
      pin=new JTextField(); 
      bal=new JTextField();
      t5=new JTextField(); 
      t6=new JTextField();
      t7=new JTextField();
      t8=new JTextField();
      p1=new JPanel();
      
      name.setEditable(false);
      bal.setEditable(false);
      
      l0.setBounds(170,20,200,20);
      l1.setBounds(20,60,200,20);
      acno.setBounds(200,60,200,20);
      l2.setBounds(20,100,200,20);
      pin.setBounds(200,100,60,20);
      b1.setBounds(180,140,100,20);
      l3.setBounds(20,185,150,20);
      name.setBounds(200,185,200,20);
      l4.setBounds(20,225,150,20);
      bal.setBounds(200,225,110,20);
       l5.setBounds(40,280,110,20);
      l6.setBounds(320,280,200,20);
      l7.setBounds(40,305,200,20);
      l8.setBounds(320,305,200,20);
      t5.setBounds(120,305,70,20);
      t6.setBounds(400,305,70,20);
      b4.setBounds(40,330,150,20);
      b5.setBounds(320,330,150,20); 
      
      l9.setBounds(40,360,180,20);
      t7.setBounds(220,360,160,20); 
      l10.setBounds(40,390,180,20);
      t8.setBounds(220,390,160,20);
      b6.setBounds(180,420,100,20);
      
      
        p1.add(l0);
        p1.add(l1);
        p1.add(acno);
        p1.add(l2);
        p1.add(pin);
        p1.add(b1);
        p1.add(l3);
        p1.add(name);
        p1.add(l4);
        p1.add(bal);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(l8);
        p1.add(t5);
        p1.add(t6);
        p1.add(b4);
        p1.add(b5);
        p1.add(l9);
        p1.add(l10);
        p1.add(t7);
        p1.add(t8);
        p1.add(b6);
        f1.add(p1);
        f1.add(p1);
      p1.setBackground(Color.cyan);  
       b1.setBackground(Color.white);  
        b4.setBackground(Color.white);  
         b5.setBackground(Color.white);  
         t5.setBackground(Color.white);  
          t6.setBackground(Color.white);  
         name.setBackground(Color.white);       
         bal.setBackground(Color.white);       
 
       p1.setLayout(null); 
       f1.setSize(500,500);
       f1.setVisible(true);
       b1.addActionListener(this);
        b4.addActionListener(this);
         b5.addActionListener(this);
         b6.addActionListener(this);
   }
   public void actionPerformed(ActionEvent e)
   {  String s=e.getActionCommand();
        if(s.equals("Login"))
      { 
          if(acno.getText().isEmpty()||pin.getText().isEmpty())
            {  JOptionPane.showMessageDialog(f1,"Please Fill Account No And PIN");
             }
         else {
        try
          {
          String w=(String)pin.getText();
   
          Class.forName("com.mysql.jdbc.Driver");
          Connection c2=DriverManager.getConnection("jdbc:mysql://localhost:3306/worldbank", "root", "root");
           Statement s2=c2.createStatement();
         ResultSet r= s2.executeQuery("select * from acc3 where pin='"+w+"' ");
         while(r.next())
          {
           

             name.setText(r.getString(1));
             
             bal.setText(r.getString(5));
           } 
     }
     catch(Exception ee)
     {
       System.out.println(ee.getMessage());
     }
    }
    }
     
        else if(s.equals("Add Money"))
      {      if(acno.getText().isEmpty()||pin.getText().isEmpty()||name.getText().isEmpty()||bal.getText().isEmpty()||t5.getText().isEmpty())
            {  JOptionPane.showMessageDialog(f1,"Please Fill Account No And PIN");
             } 
          else{
          add=Integer.parseInt(t5.getText());
           bala=Integer.parseInt(bal.getText());
           result=add+bala;
           String a=pin.getText();
           try
            {     
                 String w1=""+result;
            
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/worldbank", "root", "root");
                  Statement s1=c1.createStatement();
                 s1.execute("update acc3 set bal='"+w1+"' where pin=('"+a+"') ");
                 
            }
            catch(Exception ee)
            {
              System.out.println(ee.getMessage());
            }
        bal.setText(""+result);
       JOptionPane.showMessageDialog(f1,"Amount Has Been Successfully Added To  Your Account");
         t5.setText("");
         t6.setText("");
      }
   }

         else if(s.equals("Withdrawl Money"))
      {  if(acno.getText().isEmpty()||pin.getText().isEmpty()||name.getText().isEmpty()||bal.getText().isEmpty()||t6.getText().isEmpty())
            {  JOptionPane.showMessageDialog(f1,"Please Fill Account No And PIN");
             }
         else{
           add=Integer.parseInt(t6.getText());
           bala=Integer.parseInt(bal.getText());
               if(add>bala){ JOptionPane.showMessageDialog(f1,"Sorry Cant Withdrwal Money Because Withdrawl Money Is More Than Your Balance"); }
            else{
 result=bala-add;
           String a=pin.getText();
           try
            {     
                 String w2=""+result;
            
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection c3=DriverManager.getConnection("jdbc:mysql://localhost:3306/worldbank", "root", "root");
                  Statement s3=c3.createStatement();
                 s3.execute("update acc3 set bal='"+w2+"' where pin=('"+a+"') ");
                 
            }
            catch(Exception ee)
            {
              System.out.println(ee.getMessage());
            }
        bal.setText(""+result);
       JOptionPane.showMessageDialog(f1,"Amount Has Been Successfully Withdrawled ");
        t5.setText("");
         t6.setText("");
       }
     }
   }
     else if(s.equals("Transfer"))
    {    if(acno.getText().isEmpty()||pin.getText().isEmpty()||name.getText().isEmpty()||bal.getText().isEmpty()||t8.getText().isEmpty()||t7.getText().isEmpty())
            {  JOptionPane.showMessageDialog(f1,"Please Fill Account No And PIN");
             }
         else{
          int a1,a2,b1,b2;
          String ww1="",ww2="";
          String am=t7.getText();
          String am2=acno.getText();
          trans=Integer.parseInt(t8.getText());
          bala=Integer.parseInt(bal.getText());
               if(trans>bala){ JOptionPane.showMessageDialog(f1,"Sorry Cannot Transfer Because Transfer Money Is More Than Your Balance"); }
               else
                  {  try
                         {     
                              
            
                              Class.forName("com.mysql.jdbc.Driver");
                              Connection c3=DriverManager.getConnection("jdbc:mysql://localhost:3306/worldbank", "root", "root");
                              Statement s3=c3.createStatement();
                              ResultSet r2= s3.executeQuery("select * from acc3 where accno='"+am+"'");
                              while(r2.next())
                               { ww2=ww2+r2.getString(5);
                               }
                              bala=bala-trans;
                              b2=Integer.parseInt(ww2);
                              b2=b2+trans;
                              
                             
                              s3.execute("update acc3 set bal='"+bala+"' where accno=('"+am2+"') ");
                              s3.execute("update acc3 set bal='"+b2+"' where accno=('"+am+"') ");
                              bal.setText(""+bala);
                              JOptionPane.showMessageDialog(f1,"Amount Has Been Successfully Transferred ");
                              t8.setText("");
                              
                              c3.close();
                                                           
                         }
                     catch(Exception ee)
                         {
                               System.out.println(ee.getMessage());
                         }             
                  }
     
             } 
   }
}
   public static void main(String s[])
   {  alreadyaccount a1=new alreadyaccount();
   }
}   
   
   