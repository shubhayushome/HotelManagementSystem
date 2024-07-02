package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame implements ActionListener {

    JButton Delete_Room, Delete_Employee, Delete_Table, back;
    Delete(){

        Delete_Room = new JButton( "Remove Room");
        Delete_Room.setBounds(10,20,280,50);
        Delete_Room.setBackground(Color.BLACK);
        Delete_Room.setForeground(Color.WHITE);
        Delete_Room.setFont(new Font("Tahoma", Font.BOLD, 20));
        Delete_Room.addActionListener(this);
        add(Delete_Room);

        Delete_Employee = new JButton( "Remove Employee");
        Delete_Employee.setBounds(10,90,280,50);
        Delete_Employee.setBackground(Color.BLACK);
        Delete_Employee.setForeground(Color.WHITE);
        Delete_Employee.setFont(new Font("Tahoma", Font.BOLD, 20));
        Delete_Employee.addActionListener(this);
        add(Delete_Employee);

        Delete_Table = new JButton( "Remove Table");
        Delete_Table.setBounds(10,160,280,50);
        Delete_Table.setBackground(Color.BLACK);
        Delete_Table.setForeground(Color.WHITE);
        Delete_Table.setFont(new Font("Tahoma", Font.BOLD, 20));
        Delete_Table.addActionListener(this);
        add(Delete_Table);




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
        setLocation(700,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Delete_Room){
            new DeleteRoom();
        } else if (e.getSource() == Delete_Employee) {
            new DeleteEmployee();
        } else if (e.getSource() ==  Delete_Table) {
            new DeleteTable();
        } else if (e.getSource() == back) {
            setVisible(false);
            dispose();
        }

    }

    public static void main(String[] args) {
        new Delete();
    }
}
