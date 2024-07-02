package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ServiceEmployee extends JFrame {
    ServiceEmployee(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,495,495);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,480,350);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        panel.add(table);

        try {
            con c = new con();
            String q = "select name,job,phone,avail from Employee where  job = 'Laundry' or job = 'HouseKeeping' or job = 'Room Service'";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e ){
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(190,380,120,30);
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
        name.setBounds(41,11,120,19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(name);





        JLabel job = new JLabel("Job");
        job.setBounds(161,11,120,19);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(job);



        JLabel phone = new JLabel("Phone");
        phone.setBounds(281,11,120,19);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(phone);

        JLabel gmail = new JLabel("Availability");
        gmail.setBounds(401,11,120,19);
        gmail.setForeground(Color.WHITE);
        gmail.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(gmail);



        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(505,505);
        setVisible(true);

    }
    public static void main(String[] args) {
        new ServiceEmployee();
    }
}
