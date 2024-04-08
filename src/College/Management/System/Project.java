package College.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements  ActionListener{
    Project()
    {
        setSize(2000,1050);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(2000, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        // NEW INFORMATION

        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenuItem facultyinfo = new JMenuItem("New Faculty Information");
        facultyinfo.setBackground(Color.WHITE);
        facultyinfo.addActionListener(this);
        newInformation.add(facultyinfo);

        JMenuItem studentinfo = new JMenuItem("New Student Information");
        studentinfo.setBackground(Color.WHITE);
        studentinfo.addActionListener(this);
        newInformation.add(studentinfo);

        //DETAILS

        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultyinfo.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentinfo.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        // APPLY LEAVE

        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);

        // LEAVE DETAILS

        JMenu leavedetails = new JMenu("Leave Details");
        leavedetails.setForeground(Color.RED);
        mb.add(leavedetails);

        JMenuItem facultyleavedetails = new JMenuItem("View Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("View Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        leavedetails.add(studentleavedetails);

        //EXAMINATION DEPARTMENT

        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);

        JMenuItem examinationdetails = new JMenuItem("Examination Result");
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        //UPDATE INFORMATION

        JMenu updateInformation = new JMenu("Update Details");
        updateInformation.setForeground(Color.RED);
        mb.add(updateInformation);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInformation.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateInformation.add(updatestudentinfo);

        //FEES DEPARTMENT
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);

        //UTILITY

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);


        //EXIT

        JMenu ex = new JMenu("Exit");
        ex.setForeground(Color.RED);
        mb.add(ex);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setBackground(Color.WHITE);

        ex.addActionListener(this);
        ex.add(exit);

        setJMenuBar(mb);

        setVisible(true);

}
public void actionPerformed(ActionEvent ae){

        String msg = ae.getActionCommand();

        if(msg.equals("Exit"))
        {
            setVisible(false);

        }else if(msg.equals("Calculator")){

            try{

                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){

                System.out.println("Print the exception"+e);
            }

        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e)
            {
                System.out.println("Print the exception"+e);
            }

        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
            
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
            
        } else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();

        } else if (msg.equals("View Student Details")) {
            new StudentDetails();
        }
        else if (msg.equals("Faculty Leave")) {
            new TeacherLeave();

        } else if (msg.equals("Student Leave")) {
            new StudentLeave();
        }
        else if (msg.equals("View Faculty Leave Details")) {
            new TeacherLeaveDetails();

        } else if (msg.equals("View Student Leave Details")) {
            new StudentLeaveDetails();

        } else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher();

        } else if (msg.equals("Update Student Details")) {
            new UpdateStudent();

        } else if (msg.equals("Enter Marks")) {
            new EnterMarks();

        } else if (msg.equals("Examination Result")) {
            new ExaminationDetails();

        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();

        } else if (msg.equals("Student Fee Form")) {
            new StudentFeeForm();
        }

}

public static void main(String [] args)
{

    Project p = new Project();

    }
}
