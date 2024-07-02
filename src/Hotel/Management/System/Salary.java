package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Salary extends JFrame {
    Salary(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,620,620);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,600,450);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        panel.add(table);

        try {
            con c = new con();
            String q = "select * from expenditure";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e ){
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(250,480,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });

        JLabel name = new JLabel("Name");
        name.setBounds(40,11,100,19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(name);





        JLabel job = new JLabel("Job");
        job.setBounds(141,11,100,19);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(job);



        JLabel salary = new JLabel("Salary(in Rs)");
        salary.setBounds(211,11,100,19);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(335,11,120,19);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(phone);

        JLabel pay_i= new JLabel("Pay Interval");
        pay_i.setBounds(416,11,120,19);
        pay_i.setForeground(Color.WHITE);
        pay_i.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(pay_i);


        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(531,11,120,19);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(aadhar);

        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(630,630);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Salary();
    }
}
