package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Report extends JFrame implements ActionListener {

    JButton Salary_expenditure, resturant_expenditure, resturant_income, logout, back, room_income;
    Report(){

        Salary_expenditure = new JButton( "SALARY REPORT");
        Salary_expenditure.setBounds(10,20,280,50);
        Salary_expenditure.setBackground(Color.BLACK);
        Salary_expenditure.setForeground(Color.WHITE);
        Salary_expenditure.setFont(new Font("Tahoma", Font.BOLD, 20));
        Salary_expenditure.addActionListener(this);
        add(Salary_expenditure);

        resturant_expenditure = new JButton( "RESTURANT EXPENSE");
        resturant_expenditure.setBounds(10,90,280,50);
        resturant_expenditure.setBackground(Color.BLACK);
        resturant_expenditure.setForeground(Color.WHITE);
        resturant_expenditure.setFont(new Font("Tahoma", Font.BOLD, 20));
        resturant_expenditure.addActionListener(this);
        add(resturant_expenditure);

        resturant_income = new JButton( "RESTURANT INCOME");
        resturant_income.setBounds(10,160,280,50);
        resturant_income.setBackground(Color.BLACK);
        resturant_income.setForeground(Color.WHITE);
        resturant_income.setFont(new Font("Tahoma", Font.BOLD, 20));
        resturant_income.addActionListener(this);
        add(resturant_income);

        room_income = new JButton( "ROOM INCOME");
        room_income.setBounds(10,230,280,50);
        room_income.setBackground(Color.BLACK);
        room_income.setForeground(Color.WHITE);

        room_income.setFont(new Font("Tahoma", Font.BOLD, 20));
        room_income.addActionListener(this);
        add(room_income);


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
        setLocation(500,250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Salary_expenditure){
            new Salary();
        } else if (e.getSource() == resturant_expenditure) {
            new ResturantExpense();
        } else if (e.getSource() ==  resturant_income) {
            new ResturantIncome();
        } else if (e.getSource() == room_income) {
            new RoomIncome();
        } else if (e.getSource() == back) {
            setVisible(false);
            dispose();
        }

    }

    public static void main(String[] args) {
        new Report();
    }
}
