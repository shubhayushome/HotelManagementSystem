package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ResturantExpense extends JFrame {
    ResturantExpense(){
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
            String q = "select * from rest_expend";
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

        JLabel billId = new JLabel("Bill_Id");
        billId.setBounds(41,11,120,19);
        billId.setForeground(Color.WHITE);
        billId.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(billId);





        JLabel customer = new JLabel("Customer");
        customer.setBounds(161,11,120,19);
        customer.setForeground(Color.WHITE);
        customer.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(customer);



        JLabel tablen = new JLabel("Table");
        tablen.setBounds(281,11,120,19);
        tablen.setForeground(Color.WHITE);
        tablen.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(tablen);

        JLabel cost = new JLabel("Cost");
        cost.setBounds(401,11,120,19);
        cost.setForeground(Color.WHITE);
        cost.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(cost);



        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(505,505);
        setVisible(true);

    }
    public static void main(String[] args) {
        new ResturantExpense();
    }
}
