package College.Management.System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.*;


public class UpdateTeacher extends JFrame implements ActionListener{

    JTextField tfqualification,tfaddress,tfphone,tfemail,tfdepartment;
    JLabel labelempid;

    // JComboBox cbcourse,cbbranch;

    JButton submit,cancel;

    Choice cempid;

    UpdateTeacher(){

        setSize(900,700);
        setLocation(300,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Employee Id");
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollnumber);

        cempid = new Choice();
        cempid.setBounds(250,100,200,20);
        add(cempid);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select  * from addTeacher");
            while(rs.next()){
                cempid.add(rs.getString("Empid"));
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

        JLabel lblrollno  = new JLabel("Employee Id");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        labelempid  = new JLabel();
        labelempid.setBounds(200,200,200,30);
        labelempid.setFont(new Font("serif",Font.PLAIN,18));
        add(labelempid);

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

        JLabel lblqualification  = new JLabel("Qualification");
        lblqualification.setBounds(50,400,200,30);
        lblqualification.setFont(new Font("serif",Font.BOLD,20));
        add(lblqualification);


        tfqualification = new JTextField();
        tfqualification.setBounds(200,400,150,30);
        add(tfqualification);

        JLabel lbldepartment  = new JLabel("Department");
        lbldepartment.setBounds(400,400,200,30);
        lbldepartment.setFont(new Font("serif",Font.BOLD,20));
        add(lbldepartment);

        tfdepartment = new JTextField();
        tfdepartment.setBounds(600,400,150,30);
        add(tfdepartment);

        try{
            Conn c = new Conn();
            String  query = "select * from addTeacher where Empid='"+cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("Name"));
                labelfname.setText(rs.getString("FatherName"));
                labeldob.setText(rs.getString("DOB"));
                tfaddress.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone_Number"));
                tfemail.setText(rs.getString("Email_Id"));
                labelx.setText(rs.getString("Class_X"));
                labelxii.setText(rs.getString("Class_XII"));
                labeladdhar.setText(rs.getString("Addhaar_Number"));
                labelempid.setText(rs.getString("Empid"));
                tfqualification.setText(rs.getString("Qualification"));
                tfdepartment.setText(rs.getString("Department"));
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }

        cempid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {

                try{
                    Conn c = new Conn();
                    String  query = "select * from addTeacher where Empid='"+cempid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("Name"));
                        labelfname.setText(rs.getString("FatherName"));
                        labeldob.setText(rs.getString("DOB"));
                        tfaddress.setText(rs.getString("Address"));
                        tfphone.setText(rs.getString("Phone_Number"));
                        tfemail.setText(rs.getString("Email_Id"));
                        labelx.setText(rs.getString("Class_X"));
                        labelxii.setText(rs.getString("Class_XII"));
                        labeladdhar.setText(rs.getString("Addhaar_Number"));
                        labelempid.setText(rs.getString("Empid"));
                        tfqualification.setText(rs.getString("Qualification"));
                        tfdepartment.setText(rs.getString("Department"));
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

            String empid = labelempid.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String qualification =tfqualification.getText();
            String department = tfdepartment.getText();

            try{

                String queryy = "update addTeacher set address ='"+address+"',Phone_Number ='"+phone+"',Email_Id = '"+email+"',Qualification='"+qualification+"',Department ='"+department+"' where Empid='"+empid+"'";

                Conn con = new Conn();
                con.s.executeUpdate(queryy);

                JOptionPane.showMessageDialog(null,"Teacher Details Updated Successfully");
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

        UpdateTeacher ut = new UpdateTeacher();

    }
}
