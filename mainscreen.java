
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class mainscreen implements ActionListener
{     JButton b1,b2,b3;
      JLabel l1;
      JPanel p1;
      JFrame f1;
     public mainscreen()
     {      f1=new JFrame();
            b1=new JButton("Login To Account");
            b2=new JButton("Create New Account");
            b3=new JButton("Delete Existing Account");
            l1=new JLabel("------Welcome To World Bank------");
            p1=new JPanel();
           
            l1.setBounds(150,20,200,30); 
            b1.setBounds(140,80,200,30); 
            b2.setBounds(140,130,200,30);
            b3.setBounds(140,180,200,30);
            
           p1.add(l1);
           p1.add(b1);
           p1.add(b2);
           p1.add(b3);
           f1.add(p1);
          
          p1.setBackground(Color.blue); 
          b1.setBackground(Color.white); 
            
           
          f1.setResizable(false);
          f1.setTitle("Mainscreen");    
          p1.setLayout(null);
          f1.setSize(500,300);
          f1.setVisible(true);
          
          b1.addActionListener(this);
          b2.addActionListener(this);
           b3.addActionListener(this);
     }   
   
 
     
     public void actionPerformed(ActionEvent e)
     { 
       String s=e.getActionCommand();
        if(s.equals("Login To Account"))
          {  new alreadyaccount();
          }
        if(s.equals("Create New Account"))
          {  createaccount c2=new createaccount(); 
          }
        if(s.equals("Delete Existing Account"))
          {  new deleteaccount(); 
          }
    
     }
     
     public static void main(String s[])
     {  mainscreen m1=new mainscreen();
     }
}     
    