package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class userDashboard extends JFrame implements ActionListener {
    JButton rec,res,back;
    userDashboard(){
        super("HOTEL MANAGEMENT SYSTEM");

        rec = new JButton("RECEPTION");
        rec.setBounds(425,470,140,30);
        rec.setFont(new Font("Tahoma", Font.BOLD,15));
        rec.setBackground(new Color(255,98,0));
        rec.setForeground(Color.WHITE);
        rec.addActionListener(this);
        add(rec);

        back = new JButton("BACK");
        back.setBounds(650,750,140,30);
        back.setFont(new Font("Tahoma", Font.BOLD,15));
        back.setBackground(new Color(255,98,0));
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                new login4();
            }
        });





        res = new JButton("RESTURANT");
        res.setBounds(880,470,140,30);
        res.setFont(new Font("Tahoma", Font.BOLD,15));
        res.setBackground(new Color(255,98,0));
        res.setForeground(Color.WHITE);
        res.addActionListener(this);
        add(res);





        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icon/reception.png"));
        Image i22 = i111.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon imageIcon111 = new ImageIcon(i22);
        JLabel label11 = new JLabel(imageIcon111);
        label11.setBounds(400,250,200,195);
        add(label11);

        ImageIcon i222 = new ImageIcon(ClassLoader.getSystemResource("icon/resturant.jpg"));
        Image i2222 = i222.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon imageIcon22 = new ImageIcon(i2222);
        JLabel label2 = new JLabel(imageIcon22);
        label2.setBounds(850,250,200,195);
        add(label2);



        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(1950,1090, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0,0,1950,1090);
        add(label);

        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==rec){
            new userReception();
            setVisible(false);
        }
        else if (e.getSource()==res){
            new userResturant();
            setVisible(false);
        }
        dispose();
    }

    public static void main(String[] args) {
        new userDashboard();
        //System.exit(0);
    }
}
