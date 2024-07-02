package Hotel.Management.System;import javax.swing.*;import java.awt.*;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.sql.ResultSet;public class Dashboard extends JFrame implements ActionListener {    JButton add,rec,res,serve,back;    Dashboard(){        super("HOTEL MANAGEMENT SYSTEM");        rec = new JButton("RECEPTION");        rec.setBounds(425,350,140,30);        rec.setFont(new Font("Tahoma", Font.BOLD,15));        rec.setBackground(new Color(255,98,0));        rec.setForeground(Color.WHITE);        rec.addActionListener(this);        add(rec);        back = new JButton("BACK");        back.setBounds(650,750,140,30);        back.setFont(new Font("Tahoma", Font.BOLD,15));        back.setBackground(new Color(255,98,0));        back.setForeground(Color.WHITE);        add(back);        back.addActionListener(new ActionListener() {            @Override            public void actionPerformed(ActionEvent e) {                setVisible(false);                dispose();                new login4();            }        });        add = new JButton("ADMIN");        add.setBounds(880,350,140,30);        add.setFont(new Font("Tahoma", Font.BOLD,15));        add.setBackground(new Color(255,98,0));        add.setForeground(Color.WHITE);        add.addActionListener(this);        add(add);        res = new JButton("RESTURANT");        res.setBounds(880,700,140,30);        res.setFont(new Font("Tahoma", Font.BOLD,15));        res.setBackground(new Color(255,98,0));        res.setForeground(Color.WHITE);        res.addActionListener(this);        add(res);        serve = new JButton("SERVICES");        serve.setBounds(425,700,140,30);        serve.setFont(new Font("Tahoma", Font.BOLD,15));        serve.setBackground(new Color(255,98,0));        serve.setForeground(Color.WHITE);        serve.addActionListener(this);        add(serve);        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));        Image i2 = i11.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);        ImageIcon imageIcon11 = new ImageIcon(i2);        JLabel label1 = new JLabel(imageIcon11);        label1.setBounds(850,120,200,195);        add(label1);        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icon/reception.png"));        Image i22 = i111.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);        ImageIcon imageIcon111 = new ImageIcon(i22);        JLabel label11 = new JLabel(imageIcon111);        label11.setBounds(400,120,200,195);        add(label11);        ImageIcon i222 = new ImageIcon(ClassLoader.getSystemResource("icon/resturant.jpg"));        Image i2222 = i222.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);        ImageIcon imageIcon22 = new ImageIcon(i2222);        JLabel label2 = new JLabel(imageIcon22);        label2.setBounds(850,470,200,195);        add(label2);        ImageIcon i33 = new ImageIcon(ClassLoader.getSystemResource("icon/services.jpg"));        Image i3 = i33.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);        ImageIcon imageIcon333 = new ImageIcon(i3);        JLabel label3 = new JLabel(imageIcon333);        label3.setBounds(400,470,200,195);        add(label3);        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));        Image i1 = imageIcon.getImage().getScaledInstance(1950,1090, Image.SCALE_DEFAULT);        ImageIcon imageIcon1 = new ImageIcon(i1);        JLabel label = new JLabel(imageIcon1);        label.setBounds(0,0,1950,1090);        add(label);        setLayout(null);        setSize(1950,1090);        setVisible(true);    }    @Override    public void actionPerformed(ActionEvent e) {        if (e.getSource()==rec){            new Reception();            setVisible(false);        }        else if (e.getSource()==res){            new Resturant();            setVisible(false);        } else if (e.getSource()==serve) {            new Services();            setVisible(false);        } else {            new admin();            setVisible(false);        }        dispose();    }    public static void main(String[] args) {        new Dashboard();        //System.exit(0);    }}