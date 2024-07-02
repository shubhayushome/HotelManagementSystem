package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Booking extends JFrame {
    Booking(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,900,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {

            con c = new con();
            String q = "select * from booking";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e ){
            e.printStackTrace();
        }

        JLabel id = new JLabel("Bill_Id");
        id.setBounds(41,11,100,14);
        id.setForeground(Color.WHITE);
        id.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(id);

        JLabel number = new JLabel("Table");
        number.setBounds(135,11,100,14);
        number.setForeground(Color.WHITE);
        number.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(number);

        JLabel name = new JLabel("CustomerId");
        name.setBounds(215,11,100,14);
        name.setForeground(Color.WHITE);
        name.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(name);

        JLabel gender = new JLabel("Veg");
        gender.setBounds(346,11,100,14);
        gender.setForeground(Color.WHITE);
        gender.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(gender);

        JLabel country = new JLabel("Egg");
        country.setBounds(446,11,100,14);
        country.setForeground(Color.WHITE);
        country.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(country);

        JLabel room = new JLabel("Fish");
        room.setBounds(541,11,100,14);
        room.setForeground(Color.WHITE);
        room.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(room);

        JLabel Time = new JLabel("Chicken");
        Time.setBounds(625,11,100,14);
        Time.setForeground(Color.WHITE);
        Time.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(Time);

        JLabel Deposit = new JLabel("Mutton");
        Deposit.setBounds(725,11,120,14);
        Deposit.setForeground(Color.WHITE);
        Deposit.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(Deposit);

        JLabel Days = new JLabel("A-la Carte");
        Days.setBounds(815,11,100,14);
        Days.setForeground(Color.WHITE);
        Days.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(Days);

        JButton back = new JButton("Back");
        back.setBounds(390,510,120,30);
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


        setUndecorated(true);
        setLayout(null);
        setSize(910,600);
        setLocation(500,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Booking();
    }
}
