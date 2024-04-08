package College.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Marks extends JFrame implements ActionListener {

    String Roll_No;

    JButton back;
    Marks(String Roll_No){

        this.Roll_No = Roll_No;

        setSize(500,600);
        setLocation(500,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        JLabel heading = new JLabel("Pune Techincal University");
        heading.setBounds(100,10,500,25);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);


        JLabel subheading = new JLabel("Result of Examination 2024");
        subheading.setBounds(100,50,500,20);
        subheading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(subheading);

        JLabel lblrollnumber = new JLabel("Roll Number "+Roll_No);
        lblrollnumber.setBounds(60,100,500,20);
        lblrollnumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblrollnumber);


        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60,130,500,20);
        lblsemester.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblsemester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(100,200,500,20);
        sub1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100,230,500,20);
        sub2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100,260,500,20);
        sub3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100,290,500,20);
        sub4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100,320,500,20);
        sub5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub5);


        try{
            Conn c = new Conn();

            ResultSet rs1 = c.s.executeQuery("select * from subject where Roll_No = '"+Roll_No+"'");

            while(rs1.next()){
                sub1.setText(rs1.getString("Subject_1"));
                sub2.setText(rs1.getString("Subject_2"));
                sub3.setText(rs1.getString("Subject_3"));
                sub4.setText(rs1.getString("Subject_4"));
                sub5.setText(rs1.getString("Subject_5"));
            }

            ResultSet rs2 = c.s.executeQuery("select * from marks where Roll_No = '"+Roll_No+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText()+"------------------" +rs2.getString("Marks_1"));
                sub2.setText(sub2.getText()+"------------------" +rs2.getString("Marks_2"));
                sub3.setText(sub3.getText()+"------------------" +rs2.getString("Marks_3"));
                sub4.setText(sub4.getText()+"------------------" +rs2.getString("Marks_4"));
                sub5.setText(sub5.getText()+"------------------" +rs2.getString("Marks_5"));

                lblsemester.setText("Semester "+rs2.getString("Semester"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(250, 500, 120, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("serif", Font.BOLD, 15));
        add(back);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String [] args)
    {

        Marks m = new Marks(" ");

    }
}
