package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Info extends JFrame implements ActionListener {

    JButton Employee_Info, Customer_Info, Room_Info, back, Table_Info;
    Info(){

        Employee_Info = new JButton( "Employees");
        Employee_Info.setBounds(10,20,280,50);
        Employee_Info.setBackground(Color.BLACK);
        Employee_Info.setForeground(Color.WHITE);
        Employee_Info.setFont(new Font("Tahoma", Font.BOLD, 20));
        Employee_Info.addActionListener(this);
        add(Employee_Info);

        Customer_Info = new JButton( "Customers");
        Customer_Info.setBounds(10,90,280,50);
        Customer_Info.setBackground(Color.BLACK);
        Customer_Info.setForeground(Color.WHITE);
        Customer_Info.setFont(new Font("Tahoma", Font.BOLD, 20));
        Customer_Info.addActionListener(this);
        add(Customer_Info);

        Room_Info = new JButton( "Rooms");
        Room_Info.setBounds(10,160,280,50);
        Room_Info.setBackground(Color.BLACK);
        Room_Info.setForeground(Color.WHITE);
        Room_Info.setFont(new Font("Tahoma", Font.BOLD, 20));
        Room_Info.addActionListener(this);
        add(Room_Info);

        Table_Info = new JButton( "Tables");
        Table_Info.setBounds(10,230,280,50);
        Table_Info.setBackground(Color.BLACK);
        Table_Info.setForeground(Color.WHITE);

        Table_Info.setFont(new Font("Tahoma", Font.BOLD, 20));
        Table_Info.addActionListener(this);
        add(Table_Info);


        back = new JButton( "Back");
        back.setBounds(100,310,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);


        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setSize(315,400);
        setLocation(700,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Employee_Info){
            new Employee();
        } else if (e.getSource() == Customer_Info) {
            new CustomerInfo();
        } else if (e.getSource() ==  Room_Info) {
            new Room();
        } else if (e.getSource() == Table_Info) {
            new Table();
        } else if (e.getSource() == back) {
            setVisible(false);
            dispose();
        }

    }

    public static void main(String[] args) {
        new Info();
    }
}
