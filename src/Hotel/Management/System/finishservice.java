package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class finishservice extends  JFrame{
    finishservice(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/finish.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500,150,250,250);
        panel.add(label1);

        JLabel label = new JLabel("Finish Service");
        label.setBounds(100,20,100,30);
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel ServiceId = new JLabel("Service Id");
        ServiceId.setBounds(30,80,150,30);
        ServiceId.setFont(new Font("Tahoma",Font.BOLD,14));
        ServiceId.setForeground(Color.WHITE);
        panel.add(ServiceId);

        Choice Service = new Choice();
        Service.setBounds(200,80,150,25);
        panel.add(Service);

        try{
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from scheduled_service");
            while (resultSet.next()){
                Service.add(resultSet.getString("serviceId"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel serviceMember = new JLabel("Service Member Id");
        serviceMember.setBounds(30,130,150,30);
        serviceMember.setFont(new Font("Tahoma",Font.BOLD,14));
        serviceMember.setForeground(Color.WHITE);
        panel.add(serviceMember);

        JLabel serv_mem = new JLabel();
        serv_mem.setBounds(200,130,150,30);
        serv_mem.setFont(new Font("Tahoma",Font.BOLD,14));
        serv_mem.setForeground(Color.WHITE);
        panel.add(serv_mem);

        JLabel serviceMemberName = new JLabel("Service Member Name");
        serviceMemberName.setBounds(30,180,150,30);
        serviceMemberName.setFont(new Font("Tahoma",Font.BOLD,14));
        serviceMemberName.setForeground(Color.WHITE);
        panel.add(serviceMemberName);

        JLabel serv_memn = new JLabel();
        serv_memn.setBounds(200,180,150,30);
        serv_memn.setFont(new Font("Tahoma",Font.BOLD,14));
        serv_memn.setForeground(Color.WHITE);
        panel.add(serv_memn);

        JLabel serviceType = new JLabel("Service Type");
        serviceType.setBounds(30,230,150,30);
        serviceType.setFont(new Font("Tahoma",Font.BOLD,14));
        serviceType.setForeground(Color.WHITE);
        panel.add(serviceType);

        JLabel serv_ty = new JLabel();
        serv_ty.setBounds(200,230,150,30);
        serv_ty.setFont(new Font("Tahoma",Font.BOLD,14));
        serv_ty.setForeground(Color.WHITE);
        panel.add(serv_ty);

        JLabel room = new JLabel("Room Number");
        room.setBounds(30,280,150,30);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        room.setForeground(Color.WHITE);
        panel.add(room);

        JLabel room_n = new JLabel();
        room_n.setBounds(200,280,150,30);
        room_n.setFont(new Font("Tahoma",Font.BOLD,14));
        room_n.setForeground(Color.WHITE);
        panel.add(room_n);

        JLabel times = new JLabel("Time Of Service");
        times.setBounds(30,380,150,30);
        times.setFont(new Font("Tahoma",Font.BOLD,14));
        times.setForeground(Color.WHITE);
        panel.add(times);

        JLabel time = new JLabel();
        time.setBounds(200,380,150,30);
        time.setFont(new Font("Tahoma",Font.BOLD,14));
        time.setForeground(Color.WHITE);
        panel.add(time);

        JLabel customer = new JLabel("Customer Id");
        customer.setBounds(30,330,150,30);
        customer.setFont(new Font("Tahoma",Font.BOLD,14));
        customer.setForeground(Color.WHITE);
        panel.add(customer);

        JLabel cust = new JLabel();
        cust.setBounds(200,330,150,30);
        cust.setFont(new Font("Tahoma",Font.BOLD,14));
        cust.setForeground(Color.WHITE);
        panel.add(cust);

        JButton checkOut = new JButton(" Finish ");
        checkOut.setBounds(30,430,120,30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con cv = new con();
                    String service_id=Service.getSelectedItem();
                    String service_type=serv_ty.getText();
                    String roomnumber = room_n.getText();
                    String customer=cust.getText();
                    String amount= "";
                    if(Objects.equals(service_type, "Room Service"))
                        amount="100";
                    else if (Objects.equals(service_type, "House Keeping")) {
                        amount="150";
                    } else if (Objects.equals(service_type, "Laundry")) {
                        amount="180";
                    }
                    ResultSet r=cv.statement.executeQuery("select * from service_charge where customer = '"+customer+"'");
                    while (r.next())
                        amount= String.valueOf((Integer.parseInt(r.getString("due"))+Integer.parseInt(amount)));
                    cv.statement.executeUpdate("delete from service_charge where customer = '"+customer+"'");
                    cv.statement.executeUpdate("insert into service_charge values ('"+customer+"','"+amount+"')");
                    cv.statement.executeUpdate("delete from scheduled_service where serviceId = '"+service_id+"'");
                    cv.statement.executeUpdate("update room set cleaning_status = 'Cleaned' where roomnumber = '"+roomnumber+"'");
                    cv.statement.executeUpdate("update employee set avail = 'Available'  where aadhar = '"+serv_mem.getText()+"'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                    dispose();
                }catch (Exception E ){
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,430,120,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con c = new con();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from scheduled_service where serviceId = '"+Service.getSelectedItem()+"'");
                    while (resultSet.next()){
                        serv_mem.setText(resultSet.getString("service_member"));
                        serv_memn.setText(resultSet.getString("service_member_name"));
                        serv_ty.setText(resultSet.getString("service_type"));
                        room_n.setText(resultSet.getString("room_number"));
                        time.setText(resultSet.getString("time_of_service"));
                        cust.setText(resultSet.getString("customer_id"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170,430,120,30);
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
        setSize(800,500);
        setLocation(500,210);
        setVisible(true);
    }
    public static void main(String[] args) {
        new finishservice();
    }
}
