package College.Management.System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.*;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbcourse,cbbranch,cbsemester;

    JLabel labeltotal;

    JButton update,pay,back;


    StudentFeeForm()
    {
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

        JLabel lblrollnumber = new JLabel("Select Roll No");
        lblrollnumber.setBounds(40,60,150,20);
        lblrollnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(200,60,150,20);
        add(crollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select  * from AddStudent");
            while(rs.next()){
                crollno.add(rs.getString("Roll_No"));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel lblname  = new JLabel("Name");
        lblname.setBounds(40,100,150,20);
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname);

        JLabel lblfname  = new JLabel("Father's Name");
        lblfname.setBounds(40,140,150,20);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(200,140,150,20);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelfname);

        try{
            Conn c = new Conn();
            String  query = "select * from AddStudent where Roll_No='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("Name"));
                labelfname.setText(rs.getString("Father_Name"));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {

                try{
                    Conn c = new Conn();
                    String  query = "select * from AddStudent where Roll_No='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("Name"));
                        labelfname.setText(rs.getString("Father_Name"));

                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        JLabel lblcousre  = new JLabel("Course");
        lblcousre.setBounds(40,180,150,20);
        lblcousre.setFont(new Font("serif",Font.BOLD,16));
        add(lblcousre);

        String course [] = {"B.Tech","B.B.A","BCA","B.Sc","M.Sc","MBA","MCA","M.Com","BA","MA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch  = new JLabel("Branch");
        lblbranch.setBounds(40,220,150,20);
        lblbranch.setFont(new Font("serif",Font.BOLD,16));
        add(lblbranch);

        String branch[] = {"Computer Science","Electronics","Mechanical","Civil","IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200,220,150,20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(40,260,150,20);
        lblsemester.setFont(new Font("serif",Font.BOLD,16));
        add(lblsemester);

        String semester[] = { "Semester_1","Semester_2","Semester_3","Semester_4","Semester_5","Semester_6","Semester_7","Semester_8"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200,260,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40,300,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);

        labeltotal= new JLabel();
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labeltotal);

        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("serif", Font.BOLD, 15));
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("serif", Font.BOLD, 15));
        add(back);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();

            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
                while(rs.next()){
                    labeltotal.setText(rs.getString(semester));
                }

            } catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==pay) {

            String Roll_No = crollno.getSelectedItem();
            String Course = (String) cbcourse.getSelectedItem();
            String Semester = (String) cbsemester.getSelectedItem();
            String Branch = (String) cbbranch.getSelectedItem();
            String Total = labeltotal.getText();

            try{
                Conn c = new Conn();
                String query = "insert into collegefee values('"+Roll_No+"','"+Course+"','"+Semester+"','"+Branch+"','"+Total+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"College Fee Submitted Successfully");
                setVisible(false);

            } catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

    public static  void main(String [] args)
    {
        StudentFeeForm stf = new StudentFeeForm();
    }
}
