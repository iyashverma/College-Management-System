package College.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ExaminationDetails extends JFrame implements ActionListener {

    JTextField search;
    JButton result,back;
    JTable table;

    ExaminationDetails(){

        setSize(1000,475);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(heading);

        search = new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(search);

        result = new JButton("Result");
        result.setBounds(300, 90, 120, 30);
        result.setBackground(Color.BLACK);
        result.setForeground(Color.WHITE);
        result.addActionListener(this);
        result.setFont(new Font("serif", Font.BOLD, 16));
        add(result);

        back = new JButton("Back");
        back.setBounds(440, 90, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("serif", Font.BOLD, 15));
        add(back);

        table = new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from AddStudent");
            table.setModel(DbUtils.resultSetToTableModel(rs));


        }catch(Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == result) {
            setVisible(false);
            new Marks(search.getText());

        }else {
            setVisible(false);
        }
    }

    public static void main(String [] args){

        ExaminationDetails ed = new ExaminationDetails();

    }
}
