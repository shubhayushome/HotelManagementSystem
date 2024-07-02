package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userResturant extends JFrame implements ActionListener {

    JButton show_menu, show_table, book_table, logout, back, generate_Receipt,bookings;
    userResturant(){

        bookings = new JButton( "SHOW BOOKINGS");
        bookings.setBounds(800,130,200,30);
        bookings.setBackground(Color.WHITE);
        bookings.setForeground(Color.BLACK);
        bookings.setFont(new Font("Tahoma", Font.BOLD, 15));
        bookings.addActionListener(this);
        add(bookings);

        ImageIcon l2 = new ImageIcon(ClassLoader.getSystemResource("icon/bookings.jpg"));
        Image l22 = l2.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon5 = new ImageIcon(l22);
        JLabel label5 = new JLabel(imageIcon5);
        label5.setBounds(620,80,120,120);
        add(label5);

        show_menu = new JButton( "SHOW MENU");
        show_menu.setBounds(250,130,200,30);
        show_menu.setBackground(Color.WHITE);
        show_menu.setForeground(Color.BLACK);
        show_menu.setFont(new Font("Tahoma", Font.BOLD, 15));
        show_menu.addActionListener(this);
        add(show_menu);

        show_table = new JButton( "SHOW TABLES");
        show_table.setBounds(250,280,200,30);
        show_table.setBackground(Color.WHITE);
        show_table.setForeground(Color.BLACK);
        show_table.setFont(new Font("Tahoma", Font.BOLD, 15));
        show_table.addActionListener(this);
        add(show_table);

        book_table = new JButton( "BOOK TABLE");
        book_table.setBounds(250,430,200,30);
        book_table.setBackground(Color.WHITE);
        book_table.setForeground(Color.BLACK);
        book_table.setFont(new Font("Tahoma", Font.BOLD, 15));
        book_table.addActionListener(this);
        add(book_table);

        generate_Receipt = new JButton( "GENERATE RECEIPT");
        generate_Receipt.setBounds(250,580,200,30);
        generate_Receipt.setBackground(Color.WHITE);
        generate_Receipt.setForeground(Color.BLACK);
        generate_Receipt.setFont(new Font("Tahoma", Font.BOLD, 15));
        generate_Receipt.addActionListener(this);
        add(generate_Receipt);

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


        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/menu_card.jpg"));
        Image l11 = l1.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(l11);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(70,80,120,120);
        add(label);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/tables_icon.jpg"));
        Image image = imageIcon1.getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(70,230,120,120);
        add(label1);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/book_table.jpg"));
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

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("icon/receipt.jpg"));
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

        if (e.getSource() == show_menu){
            new Menu();
        } else if (e.getSource() == show_table) {
            new Table();
        } else if (e.getSource() ==  book_table) {
            new BookTable();
        } else if (e.getSource() == generate_Receipt) {
            new GenerateBill();
        } else if (e.getSource()== bookings) {
            new Booking();
        } else if (e.getSource() == logout){
            System.exit(102);
        } else if (e.getSource() == back) {
            new userDashboard();
            setVisible(false);
            dispose();
        }

    }

    public static void main(String[] args) {
        new userResturant();
    }
}
