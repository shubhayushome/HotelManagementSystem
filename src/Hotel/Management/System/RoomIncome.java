package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RoomIncome extends JFrame {
    RoomIncome(){


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
            String q = "select * from room_income";
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





        JLabel num = new JLabel("Number");
        num.setBounds(130,11,100,19);
        num.setForeground(Color.WHITE);
        num.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(num);



        JLabel room = new JLabel("Room");
        room.setBounds(235,11,100,19);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(room);

        JLabel checkin = new JLabel("Check-In");
        checkin.setBounds(325,11,120,19);
        checkin.setForeground(Color.WHITE);
        checkin.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(checkin);

        JLabel checkout= new JLabel("Check-Out");
        checkout.setBounds(420,11,120,19);
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(checkout);


        JLabel income = new JLabel("Income(in Rs)");
        income.setBounds(505,11,120,19);
        income.setForeground(Color.WHITE);
        income.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(income);

        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(630,630);
        setVisible(true);

    }
    public static void main(String[] args) {
        new RoomIncome();
    }
}
