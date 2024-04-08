package College.Management.System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.*;


public class UpdateStudent extends JFrame implements ActionListener{

    JTextField tfcourse,tfaddress,tfphone,tfemail,tfbranch;
    JLabel labelrollno;

   // JComboBox cbcourse,cbbranch;

    JButton submit,cancel;

    Choice crollno;

    UpdateStudent(){

        setSize(900,700);
        setLocation(300,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Update Students Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(250,100,200,20);
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
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,30));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,18));
        add(labelname);

        JLabel lblfname  = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,18));
        add(labelfname);

        JLabel lblrollno  = new JLabel("Roll Number");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        labelrollno  = new JLabel();
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("serif",Font.PLAIN,18));
        add(labelrollno);

        JLabel lbldob  = new JLabel("Date Of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,18));
        add(labeldob);


        JLabel lbladdress  = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lblphone  = new JLabel("Phone Number");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel lblemail  = new JLabel("E-mail Id:");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lblx  = new JLabel("Clas X (%)");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);

        JLabel labelx= new JLabel();
        labelx.setBounds(600,300,150,30);
        labelx.setFont(new Font("serif",Font.PLAIN,20));
        add(labelx);

        JLabel lblxii  = new JLabel("Clas XII (%)");
        lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        JLabel labelxii = new JLabel();
        labelxii.setBounds(200,350,150,30);
        labelxii.setFont(new Font("serif",Font.PLAIN,18));
        add(labelxii);


        JLabel lbladdhar  = new JLabel("Aaddhar Number");
        lbladdhar.setBounds(400,350,200,30);
        lbladdhar.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdhar);

        JLabel labeladdhar = new JLabel();
        labeladdhar.setBounds(600,350,150,30);
        labeladdhar.setFont(new Font("serif",Font.PLAIN,18));
        add(labeladdhar);

        JLabel lblcousre  = new JLabel("Course");
        lblcousre.setBounds(50,400,200,30);
        lblcousre.setFont(new Font("serif",Font.BOLD,20));
        add(lblcousre);


        tfcourse = new JTextField();
        tfcourse.setBounds(200,400,150,30);
        add(tfcourse);

        JLabel lblbranch  = new JLabel("Branch");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(600,400,150,30);
        add(tfbranch);

        try{
            Conn c = new Conn();
            String  query = "select * from AddStudent where Roll_No='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("Name"));
                labelfname.setText(rs.getString("Father_Name"));
                labeldob.setText(rs.getString("DOB"));
                tfaddress.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone_Number"));
                tfemail.setText(rs.getString("Email_Id"));
                labelx.setText(rs.getString("Class_X"));
                labelxii.setText(rs.getString("Class_XII"));
                labeladdhar.setText(rs.getString("Addhaar_Number"));
                labelrollno.setText(rs.getString("Roll_No"));
                tfcourse.setText(rs.getString("Course"));
                tfbranch.setText(rs.getString("Branch"));
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
                        labeldob.setText(rs.getString("DOB"));
                        tfaddress.setText(rs.getString("Address"));
                        tfphone.setText(rs.getString("Phone_Number"));
                        tfemail.setText(rs.getString("Email_Id"));
                        labelx.setText(rs.getString("Class_X"));
                        labelxii.setText(rs.getString("Class_XII"));
                        labeladdhar.setText(rs.getString("Addhaar_Number"));
                        labelrollno.setText(rs.getString("Roll_No"));
                        tfcourse.setText(rs.getString("Course"));
                        tfbranch.setText(rs.getString("Branch"));
                    }


                }catch (Exception e)
                {
                    e.printStackTrace();
                }


            }
        });

        submit = new JButton("Update");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 16));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit){

            String roll_no = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course =tfcourse.getText();
            String branch = tfbranch.getText();

            try{

                String queryy = "update AddStudent set address ='"+address+"',Phone_Number ='"+phone+"',Email_Id = '"+email+"',course='"+course+"',branch ='"+branch+"' where Roll_No='"+roll_no+"'";

                Conn con = new Conn();
                con.s.executeUpdate(queryy);

                JOptionPane.showMessageDialog(null,"Student Details Updated Successfully");
                setVisible(false);


            } catch(Exception e){
                e.printStackTrace();

            }

        }else{
            setVisible(false);
        }
    }


    public static void main(String [] args)
    {

        UpdateStudent us = new UpdateStudent();

    }
}
