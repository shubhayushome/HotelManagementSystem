package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Table extends JFrame {
    Table(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,490,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);



        JTable table = new JTable();
        table.setBounds(10,34,470,350);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        panel.add(table);

        try {
            con c = new con();
            String q = "select * from table_s";
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

        JLabel name = new JLabel("Table");
        name.setBounds(45,11,120,19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(name);





        JLabel job = new JLabel("Occupancy");
        job.setBounds(205,11,120,19);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(job);

        JLabel avail = new JLabel("Availabilty");
        avail.setBounds(375,11,120,19);
        avail.setForeground(Color.WHITE);
        avail.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(avail);



        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(500,500);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Table();
    }
}
