package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Services extends JFrame implements ActionListener {

    JButton show_schedule, show_service_Employee, book_service, logout, back, finish_service,show_rooms;
    Services(){

        show_rooms = new JButton( "SHOW ROOMS");
        show_rooms.setBounds(800,130,200,30);
        show_rooms.setBackground(Color.WHITE);
        show_rooms.setForeground(Color.BLACK);
        show_rooms.setFont(new Font("Tahoma", Font.BOLD, 15));
        show_rooms.addActionListener(this);
        add(show_rooms);


        show_schedule = new JButton( "SHOW SCHEDULE");
        show_schedule.setBounds(250,130,200,30);
        show_schedule.setBackground(Color.WHITE);
        show_schedule.setForeground(Color.BLACK);
        show_schedule.setFont(new Font("Tahoma", Font.BOLD, 15));
        show_schedule.addActionListener(this);
        add(show_schedule);

        show_service_Employee = new JButton( "SHOW EMPLOYEES");
        show_service_Employee.setBounds(250,280,200,30);
        show_service_Employee.setBackground(Color.WHITE);
        show_service_Employee.setForeground(Color.BLACK);
        show_service_Employee.setFont(new Font("Tahoma", Font.BOLD, 15));
        show_service_Employee.addActionListener(this);
        add(show_service_Employee);

        book_service = new JButton( "ASSIGN SERVICE");
        book_service.setBounds(250,430,200,30);
        book_service.setBackground(Color.WHITE);
        book_service.setForeground(Color.BLACK);
        book_service.setFont(new Font("Tahoma", Font.BOLD, 15));
        book_service.addActionListener(this);
        add(book_service);

        finish_service = new JButton( "FINISH SERVICE");
        finish_service.setBounds(250,580,200,30);
        finish_service.setBackground(Color.WHITE);
        finish_service.setForeground(Color.BLACK);
        finish_service.setFont(new Font("Tahoma", Font.BOLD, 15));
        finish_service.addActionListener(this);
        add(finish_service);

        logout = new JButton( "Logout");
        logout.setBounds(10,750,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.BOLD, 15));
        logout.addActionListener(this);
        add(logout);

        back = new JButton( "Back");
        back.setBounds(110,750,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);


        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/show_schedule.jpg"));
        Image l11 = l1.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(l11);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(70,80,120,120);
        add(label);

        ImageIcon l2 = new ImageIcon(ClassLoader.getSystemResource("icon/show_rooms.png"));
        Image l22 = l2.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon5 = new ImageIcon(l22);
        JLabel label5 = new JLabel(imageIcon5);
        label5.setBounds(620,80,120,120);
        add(label5);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/show_employees.jpg"));
        Image image = imageIcon1.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(70,230,120,120);
        add(label1);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/request_service.jpg"));
        Image image1 = imageIcon2.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon12 = new ImageIcon(image1);
        JLabel label2 = new JLabel(imageIcon12);
        label2.setBounds(70,380,120,120);
        add(label2);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/login_new.gif"));
        Image image2 = imageIcon3.getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon13 = new ImageIcon(image2);
        JLabel label3 = new JLabel(imageIcon13);
        label3.setBounds(1000,250,400,400);
        add(label3);

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("icon/finish_service.jpg"));
        Image image4 = imageIcon4.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon14 = new ImageIcon(image4);
        JLabel label4 = new JLabel(imageIcon14);
        label4.setBounds(70,530,120,120);
        add(label4);


        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == show_schedule){
            new Schedule();
        } else if (e.getSource() == show_service_Employee) {
            new ServiceEmployee();
        } else if (e.getSource() ==  book_service) {
            new service();
        } else if (e.getSource() == finish_service) {
            new finishservice();
        } else if (e.getSource() == logout){
            System.exit(102);
        } else if (e.getSource() == back) {
            dispose();
            new Dashboard();
            setVisible(false);
        } else if (e.getSource()==show_rooms) {
            new Room();
            //setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Services();
    }
}
