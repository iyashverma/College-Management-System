package College.Management.System;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice cempid,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;

    TeacherLeave()
    {
        setSize(600,650);
        setLocation(600,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply Leave Student");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel lblrollno = new JLabel("Search Employee Id");
        lblrollno.setBounds(60,100,200,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrollno);

        cempid = new Choice();
        cempid.setBounds(60,120,200,20);
        add(cempid);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select  * from addTeacher");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }

        }catch (Exception e)
        {
            e.printStackTrace();

        }

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,25);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60,260,200,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 16));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==submit){
            String rollno = cempid.getSelectedItem();
            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query = "insert into teacherleave values('"+rollno+"','"+date+"','"+duration+"')";

            try{

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Leave Confirmed");

            } catch (Exception e){

                e.printStackTrace();

            }

        } else{

            setVisible(false);
        }

    }

    public static void main(String [] args)
    {
        TeacherLeave tl = new TeacherLeave();
    }
}
