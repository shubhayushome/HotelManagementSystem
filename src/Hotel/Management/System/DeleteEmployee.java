package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class DeleteEmployee extends  JFrame{
    DeleteEmployee(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/demp.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500,125,250,250);
        panel.add(label1);

        JLabel label = new JLabel("Remove Employee");
        label.setBounds(100,20,200,30);
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel ServiceId = new JLabel("Employee Id");
        ServiceId.setBounds(30,80,150,30);
        ServiceId.setFont(new Font("Tahoma",Font.BOLD,14));
        ServiceId.setForeground(Color.WHITE);
        panel.add(ServiceId);

        Choice Service = new Choice();
        Service.setBounds(200,80,150,25);
        panel.add(Service);

        try{
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                Service.add(resultSet.getString("aadhar"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel eName = new JLabel("Employee Name");
        eName.setBounds(30,130,150,30);
        eName.setFont(new Font("Tahoma",Font.BOLD,14));
        eName.setForeground(Color.WHITE);
        panel.add(eName);

        JLabel serv_mem = new JLabel();
        serv_mem.setBounds(200,130,150,30);
        serv_mem.setFont(new Font("Tahoma",Font.BOLD,14));
        serv_mem.setForeground(Color.WHITE);
        panel.add(serv_mem);

        JLabel job = new JLabel("Job");
        job.setBounds(30,180,150,30);
        job.setFont(new Font("Tahoma",Font.BOLD,14));
        job.setForeground(Color.WHITE);
        panel.add(job);

        JLabel serv_memn = new JLabel();
        serv_memn.setBounds(200,180,150,30);
        serv_memn.setFont(new Font("Tahoma",Font.BOLD,14));
        serv_memn.setForeground(Color.WHITE);
        panel.add(serv_memn);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(30,230,150,30);
        salary.setFont(new Font("Tahoma",Font.BOLD,14));
        salary.setForeground(Color.WHITE);
        panel.add(salary);

        JLabel serv_ty = new JLabel();
        serv_ty.setBounds(200,230,150,30);
        serv_ty.setFont(new Font("Tahoma",Font.BOLD,14));
        serv_ty.setForeground(Color.WHITE);
        panel.add(serv_ty);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(30,280,150,30);
        phone.setFont(new Font("Tahoma",Font.BOLD,14));
        phone.setForeground(Color.WHITE);
        panel.add(phone);

        JLabel p_n = new JLabel();
        p_n.setBounds(200,280,150,30);
        p_n.setFont(new Font("Tahoma",Font.BOLD,14));
        p_n.setForeground(Color.WHITE);
        panel.add(p_n);

        JLabel email = new JLabel("Email");
        email.setBounds(30,330,150,30);
        email.setFont(new Font("Tahoma",Font.BOLD,14));
        email.setForeground(Color.WHITE);
        panel.add(email);

        JLabel em = new JLabel();
        em.setBounds(200,330,150,30);
        em.setFont(new Font("Tahoma",Font.BOLD,14));
        em.setForeground(Color.WHITE);
        panel.add(em);


        JButton checkOut = new JButton(" Remove");
        checkOut.setBounds(30,430,120,30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con cv = new con();
                   String q= "delete from employee where aadhar ='"+Service.getSelectedItem()+"'";
                   cv.statement.executeUpdate(q);
                   q="delete from expenditure where aadhar ='"+Service.getSelectedItem()+"'";
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
        check.setBounds(300,430,120,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con c = new con();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where aadhar = '"+Service.getSelectedItem()+"'");
                    while (resultSet.next()){
                        serv_mem.setText(resultSet.getString("name"));
                        serv_memn.setText(resultSet.getString("job"));
                        serv_ty.setText(resultSet.getString("salary"));
                        p_n.setText(resultSet.getString("phone"));
                        em.setText(resultSet.getString("email"));
                       // cust.setText(resultSet.getString("customer_id"));
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
        new DeleteEmployee();
    }
}
