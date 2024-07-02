package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTable extends JFrame implements ActionListener {
    JTextField t2;
    JComboBox t3,t4;
    JButton b1,b2;
    AddTable(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel l1 = new JLabel("Add Tables");
        l1.setBounds(194,10,160,22);
        l1.setFont(new Font("Tahoma", Font.BOLD,22));
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        JLabel l2 = new JLabel("Table Number");
        l2.setBounds(64,70,152,22);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setForeground(Color.WHITE);
        panel.add(l2);
        t2 =new JTextField();
        t2.setBounds(200,70,156,20);
        t2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        t2.setForeground(Color.WHITE);
        t2.setBackground(new Color(16,108,115));
        panel.add(t2);

        JLabel l3 = new JLabel("Availability");
        l3.setBounds(64,110,152,22);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setForeground(Color.WHITE);
        panel.add(l3);

        t3 =new JComboBox(new String[] {"Available", "Occupied"});
        t3.setBounds(200,110,156,20);
        t3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);

        JLabel l4 = new JLabel("No. of People");
        l4.setBounds(64,150,152,22);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setForeground(Color.WHITE);
        panel.add(l4);

        t4 =new JComboBox(new String[]{"4","6","8"});
        t4.setBounds(200,150,156,20);
        t4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        t4.setForeground(Color.WHITE);
        t4.setBackground(new Color(16,108,115));
        panel.add(t4);



        b1 = new JButton("Add");
        b1.setBounds(64,221,111,33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(198,221,111,33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/tables.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,50,250,250);
        panel.add(label);



        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        setSize(885,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1){
            try{
                con c = new con();
                String table = t2.getText();
                String ava = (String) t3.getSelectedItem();
                String people = (String)  t4.getSelectedItem();


                String q = "insert into table_s values('"+table+"', '"+ava+"', '"+people+"')";
                c.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"Table Successfully Added");
                setVisible(false);
                dispose();

            }catch (Exception E){
                E.printStackTrace();
                dispose();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddTable();
    }
}
