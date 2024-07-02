package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class DeleteTable extends  JFrame{
    DeleteTable(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,300);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/dtable.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500,75,150,150);
        panel.add(label1);

        JLabel label = new JLabel("Remove Table");
        label.setBounds(100,20,200,30);
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel tableId = new JLabel("Table Id");
        tableId.setBounds(30,80,150,30);
        tableId.setFont(new Font("Tahoma",Font.BOLD,14));
        tableId.setForeground(Color.WHITE);
        panel.add(tableId);

        Choice Table = new Choice();
        Table.setBounds(200,80,150,25);
        panel.add(Table);

        try{
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from table_s");
            while (resultSet.next()){
                Table.add(resultSet.getString("number"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel availabilty = new JLabel("Availabilty");
        availabilty.setBounds(30,130,150,30);
        availabilty.setFont(new Font("Tahoma",Font.BOLD,14));
        availabilty.setForeground(Color.WHITE);
        panel.add(availabilty);

        JLabel avail = new JLabel();
        avail.setBounds(200,130,150,30);
        avail.setFont(new Font("Tahoma",Font.BOLD,14));
        avail.setForeground(Color.WHITE);
        panel.add(avail);

        JLabel occupancy = new JLabel("Occupancy");
        occupancy.setBounds(30,180,150,30);
        occupancy.setFont(new Font("Tahoma",Font.BOLD,14));
        occupancy.setForeground(Color.WHITE);
        panel.add(occupancy);

        JLabel availn = new JLabel();
        availn.setBounds(200,180,150,30);
        availn.setFont(new Font("Tahoma",Font.BOLD,14));
        availn.setForeground(Color.WHITE);
        panel.add(availn);




        JButton checkOut = new JButton(" Remove");
        checkOut.setBounds(30,250,120,30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con cv = new con();
                    String q= "delete from table_s where number ='"+Table.getSelectedItem()+"'";
                    cv.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                    dispose();
                }catch (Exception E ){
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,250,120,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con c = new con();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from table_s where number = '"+Table.getSelectedItem()+"'");
                    while (resultSet.next()){
                        avail.setText(resultSet.getString("avail"));
                        availn.setText(resultSet.getString("people"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170,250,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
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
        setSize(800,310);
        setLocation(500,210);
        setVisible(true);
    }
    public static void main(String[] args) {
        new DeleteTable();
    }
}
