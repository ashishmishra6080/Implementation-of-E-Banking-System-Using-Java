
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class deleteaccount  implements ActionListener
{    JLabel l1,l2,l3;
     JTextField t1,t2;
     JButton b1;
     JPanel p1;
     JFrame f1;
    public deleteaccount()
    {      
     l1=new JLabel("Enter Account Number");
          l3=new JLabel("Deleting Your Account");
          l2=new JLabel("Enter Account PIN");
          p1=new JPanel();
          b1=new JButton("Delete My Account");
          f1=new JFrame("Delete Screen");
          t1=new JTextField();
          t2=new JTextField();
          
          l3.setBounds(135,10,200,20);
          l1.setBounds(40,50,200,20);
          t1.setBounds(190,50,150,20);
          l2.setBounds(40,90,200,20);
          t2.setBounds(190,90,50,20);
          b1.setBounds(120,130,150,20);
          
          
          p1.add(l3);
          p1.add(l1);
          p1.add(t1);
          p1.add(l2);
          p1.add(t2);
          p1.add(b1);
          
          b1.setBackground(Color.pink);
          p1.setBackground(Color.green);
          
          f1.setResizable(false);
          f1.add(p1);
          p1.setLayout(null);
          f1.setSize(400,200);
          f1.setVisible(true);
          
         
          b1.addActionListener(this);
          
          
 }
 
public void actionPerformed(ActionEvent e)
{  
          if(t1.getText().isEmpty()||t2.getText().isEmpty())
            {    JOptionPane.showMessageDialog(f1,"Please Fill Account No And PIN");
             }
          else{
             try
                {
                 String w=(String)t2.getText();
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
                 Statement s=c.createStatement();
                 s.execute("delete from accountdetails where pin='"+w+"' ");
                 JOptionPane.showMessageDialog(f1,"Account Is Successfully Deleted");  
                 t1.setText("");
                 t2.setText("");
                }
              catch(Exception ee)  
                {
                }
              }
 }
       
 public static void main(String[] args)
  {
     new deleteaccount();  
  }

}
