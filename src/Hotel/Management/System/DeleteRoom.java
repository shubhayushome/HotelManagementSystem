package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class DeleteRoom extends  JFrame{
    DeleteRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,400);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/droom.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500,100,250,250);
        panel.add(label1);

        JLabel label = new JLabel("Remove Room");
        label.setBounds(100,20,200,30);
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel RoomId = new JLabel("Room Id");
        RoomId.setBounds(30,80,150,30);
        RoomId.setFont(new Font("Tahoma",Font.BOLD,14));
        RoomId.setForeground(Color.WHITE);
        panel.add(RoomId);

        Choice Room = new Choice();
        Room.setBounds(200,80,150,25);
        panel.add(Room);

        try{
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while (resultSet.next()){
                Room.add(resultSet.getString("roomnumber"));
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

        JLabel cleaned_status = new JLabel("Clean Status");
        cleaned_status.setBounds(30,180,150,30);
        cleaned_status.setFont(new Font("Tahoma",Font.BOLD,14));
        cleaned_status.setForeground(Color.WHITE);
        panel.add(cleaned_status);

        JLabel availn = new JLabel();
        availn.setBounds(200,180,150,30);
        availn.setFont(new Font("Tahoma",Font.BOLD,14));
        availn.setForeground(Color.WHITE);
        panel.add(availn);

        JLabel price = new JLabel("Price(in Rs)");
        price.setBounds(30,230,150,30);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setForeground(Color.WHITE);
        panel.add(price);

        JLabel serv_ty = new JLabel();
        serv_ty.setBounds(200,230,150,30);
        serv_ty.setFont(new Font("Tahoma",Font.BOLD,14));
        serv_ty.setForeground(Color.WHITE);
        panel.add(serv_ty);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(30,280,150,30);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        bed.setForeground(Color.WHITE);
        panel.add(bed);

        JLabel p_n = new JLabel();
        p_n.setBounds(200,280,150,30);
        p_n.setFont(new Font("Tahoma",Font.BOLD,14));
        p_n.setForeground(Color.WHITE);
        panel.add(p_n);



        JButton checkOut = new JButton(" Remove");
        checkOut.setBounds(30,350,120,30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con cv = new con();
                    String q= "delete from room where roomnumber ='"+Room.getSelectedItem()+"'";
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
        check.setBounds(300,350,120,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con c = new con();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from room where roomnumber = '"+Room.getSelectedItem()+"'");
                    while (resultSet.next()){
                        avail.setText(resultSet.getString("availabilty"));
                        availn.setText(resultSet.getString("cleaning_status"));
                        serv_ty.setText(resultSet.getString("price"));
                        p_n.setText(resultSet.getString("bed_type"));
                        //em.setText(resultSet.getString("email"));
                        // cust.setText(resultSet.getString("customer_id"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170,350,120,30);
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
        setSize(800,410);
        setLocation(500,210);
        setVisible(true);
    }
    public static void main(String[] args) {
        new DeleteRoom();
    }
}
