package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class service extends JFrame {
    service(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,500);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/house_cleaning.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1  = new JLabel("Schedule Service");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2  = new JLabel("ID :");
        label2.setBounds(25,88,46,14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice c = new Choice();
        c.setBounds(248,85,140,20);
        panel.add(c);

        try {
            con C = new con();
            ResultSet resultSet = C.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                c.add(resultSet.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3  = new JLabel("Room Number :");
        label3.setBounds(25,129,107,14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248,129,140,20);
        panel.add(textField3);

        JLabel label4  = new JLabel("Name :");
        label4.setBounds(25,174,97,14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setBounds(248,174,140,20);
        panel.add(textField4);

        JLabel label5  = new JLabel("Required Service:");
        label5.setBounds(25,216,130,14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField5 = new JTextField();
        textField5.setBounds(248,216,140,20);
        panel.add(textField5);

        JLabel label6  = new JLabel("Service Members:");
        label6.setBounds(25,261,150,14);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);


        Choice c2 = new Choice();
        c2.setBounds(248,261,140,20);
        panel.add(c2);



        JLabel label7  = new JLabel("Schedule Time:");
        label7.setBounds(25,302,150,14);
        label7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JLabel date;

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(248,302,200,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(date);

        JButton schedule = new JButton("Schedule");
        schedule.setBounds(56,378,89,23);
        schedule.setBackground(Color.BLACK);
        schedule.setForeground(Color.WHITE);
        panel.add(schedule);
        schedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con C  = new con();
                    String customer_id = c.getSelectedItem();
                    String room_number = textField3.getText();
                    String service_type = textField5.getText();
                    String service_member=c2.getSelectedItem();
                    String time_of_service= date.getText();
                    String service_member_name=new String();
                    String service_id = service_member+" "+room_number;//textField6.getText();
                    String q= "select * from employee where aadhar = '"+service_member+"'";
                    ResultSet r= C.statement.executeQuery(q);
                    while (r.next())
                    {
                        service_member_name=r.getString("name");
                    }
                    q="update employee set avail = 'Occupied' where aadhar = '"+service_member+"'";
                    C.statement.executeUpdate(q);
                    C.statement.executeUpdate("insert into scheduled_service values ('"+service_id+"','"+service_member+"','"
                    +service_member_name+"','"+service_type+"','"+room_number+"','"+time_of_service+"','"+customer_id+"')");
                    JOptionPane.showMessageDialog(null, "Scheduled Successfully");
                    setVisible(false);
                    dispose();

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        JButton back = new JButton("Back");
        back.setBounds(168,378,89,23);
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

        JButton check = new JButton("Check");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String q = "select * from customer where number = '" + id + "'";
                String day = new String();
                try {
                    con c = new con();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    String room = new String();
                    while (resultSet.next()) {
                        room = resultSet.getString("room");
                        textField3.setText(room);
                        textField4.setText(resultSet.getString("name"));
                    }
                    q = "select * from room where roomnumber = '" + room + "'";

                    ResultSet resultSet1 = c.statement.executeQuery(q);
                    String service = new String();

                    while (resultSet1.next()) {
                        service = resultSet1.getString("cleaning_status");

                        textField5.setText("" + service);
                    }

                    ResultSet resultSet2 = c.statement.executeQuery("select * from employee where job = '"+service+"' and avail = 'Available'");
                    while (resultSet2.next()) {
                        c2.add(resultSet2.getString("aadhar"));

                    }


                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        setLayout(null);
        setSize(950,500);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new service();
    }
}
