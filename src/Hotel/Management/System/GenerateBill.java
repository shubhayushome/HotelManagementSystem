package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class GenerateBill extends  JFrame{
    
    GenerateBill(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,650);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/recp.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500,200,250,250);
        panel.add(label1);

        JLabel label = new JLabel("Resturant Receipt");
        label.setBounds(100,20,200,30);
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel BillId = new JLabel("Bill Id");
        BillId.setBounds(30,80,150,30);
        BillId.setFont(new Font("Tahoma",Font.BOLD,14));
        BillId.setForeground(Color.WHITE);
        panel.add(BillId);

        Choice Service = new Choice();
        Service.setBounds(200,80,150,25);
        panel.add(Service);

        try{
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from booking");
            while (resultSet.next()){
                Service.add(resultSet.getString("bill_Id"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel customer = new JLabel("Customer Id");
        customer.setBounds(30,130,150,30);
        customer.setFont(new Font("Tahoma",Font.BOLD,14));
        customer.setForeground(Color.WHITE);
        panel.add(customer);

        JLabel cust = new JLabel();
        cust.setBounds(200,130,150,30);
        cust.setFont(new Font("Tahoma",Font.BOLD,14));
        cust.setForeground(Color.WHITE);
        panel.add(cust);

        JLabel table = new JLabel("Table Number");
        table.setBounds(30,180,150,30);
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        table.setForeground(Color.WHITE);
        panel.add(table);

        JLabel tab = new JLabel();
        tab.setBounds(200,180,150,30);
        tab.setFont(new Font("Tahoma",Font.BOLD,14));
        tab.setForeground(Color.WHITE);
        panel.add(tab);

        JLabel meal1 = new JLabel("Meal Type");
        meal1.setBounds(30,230,150,30);
        meal1.setFont(new Font("Tahoma",Font.BOLD,14));
        meal1.setForeground(Color.WHITE);
        panel.add(meal1);

        JLabel meal2 = new JLabel("Quantity");
        meal2.setBounds(180,230,150,30);
        meal2.setFont(new Font("Tahoma",Font.BOLD,14));
        meal2.setForeground(Color.WHITE);
        panel.add(meal2);

        JLabel meal3 = new JLabel("Price");
        meal3.setBounds(330,230,150,30);
        meal3.setFont(new Font("Tahoma",Font.BOLD,14));
        meal3.setForeground(Color.WHITE);
        panel.add(meal3);

        JLabel veg1 = new JLabel("Veg Meal");
        veg1.setBounds(30,280,150,30);
        veg1.setFont(new Font("Tahoma",Font.BOLD,14));
        veg1.setForeground(Color.WHITE);
        panel.add(veg1);

        JLabel veg2 = new JLabel();
        veg2.setBounds(180,280,150,30);
        veg2.setFont(new Font("Tahoma",Font.ITALIC,14));
        veg2.setForeground(Color.WHITE);
        panel.add(veg2);

        JLabel veg3 = new JLabel();
        veg3.setBounds(330,280,150,30);
        veg3.setFont(new Font("Tahoma",Font.ITALIC,14));
        veg3.setForeground(Color.WHITE);
        panel.add(veg3);

        JLabel egg1 = new JLabel("Egg Meal");
        egg1.setBounds(30,320,150,30);
        egg1.setFont(new Font("Tahoma",Font.BOLD,14));
        egg1.setForeground(Color.WHITE);
        panel.add(egg1);

        JLabel egg2 = new JLabel();
        egg2.setBounds(180,320,150,30);
        egg2.setFont(new Font("Tahoma",Font.ITALIC,14));
        egg2.setForeground(Color.WHITE);
        panel.add(egg2);

        JLabel egg3 = new JLabel();
        egg3.setBounds(330,320,150,30);
        egg3.setFont(new Font("Tahoma",Font.ITALIC,14));
        egg3.setForeground(Color.WHITE);
        panel.add(egg3);

        JLabel fish1 = new JLabel("Fish Meal");
        fish1.setBounds(30,360,150,30);
        fish1.setFont(new Font("Tahoma",Font.BOLD,14));
        fish1.setForeground(Color.WHITE);
        panel.add(fish1);

        JLabel fish2 = new JLabel();
        fish2.setBounds(180,360,150,30);
        fish2.setFont(new Font("Tahoma",Font.ITALIC,14));
        fish2.setForeground(Color.WHITE);
        panel.add(fish2);

        JLabel fish3 = new JLabel();
        fish3.setBounds(330,360,150,30);
        fish3.setFont(new Font("Tahoma",Font.ITALIC,14));
        fish3.setForeground(Color.WHITE);
        panel.add(fish3); 

        JLabel chicken1 = new JLabel("Chicken Meal");
        chicken1.setBounds(30,400,150,30);
        chicken1.setFont(new Font("Tahoma",Font.BOLD,14));
        chicken1.setForeground(Color.WHITE);
        panel.add(chicken1);

        JLabel chicken2 = new JLabel();
        chicken2.setBounds(180,400,150,30);
        chicken2.setFont(new Font("Tahoma",Font.ITALIC,14));
        chicken2.setForeground(Color.WHITE);
        panel.add(chicken2);

        JLabel chicken3 = new JLabel();
        chicken3.setBounds(330,400,150,30);
        chicken3.setFont(new Font("Tahoma",Font.ITALIC,14));
        chicken3.setForeground(Color.WHITE);
        panel.add(chicken3);

        JLabel mutton1 = new JLabel("Mutton Meal");
        mutton1.setBounds(30,440,150,30);
        mutton1.setFont(new Font("Tahoma",Font.BOLD,14));
        mutton1.setForeground(Color.WHITE);
        panel.add(mutton1);

        JLabel mutton2 = new JLabel();
        mutton2.setBounds(180,440,150,30);
        mutton2.setFont(new Font("Tahoma",Font.ITALIC,14));
        mutton2.setForeground(Color.WHITE);
        panel.add(mutton2);

        JLabel mutton3 = new JLabel();
        mutton3.setBounds(330,440,150,30);
        mutton3.setFont(new Font("Tahoma",Font.ITALIC,14));
        mutton3.setForeground(Color.WHITE);
        panel.add(mutton3);

        JLabel ala1 = new JLabel("A-la Carte Meal");
        ala1.setBounds(30,480,150,30);
        ala1.setFont(new Font("Tahoma",Font.BOLD,14));
        ala1.setForeground(Color.WHITE);
        panel.add(ala1);

        JLabel ala2 = new JLabel();
        ala2.setBounds(180,480,150,30);
        ala2.setFont(new Font("Tahoma",Font.ITALIC,14));
        ala2.setForeground(Color.WHITE);
        panel.add(ala2);

        JLabel ala3 = new JLabel();
        ala3.setBounds(330,480,150,30);
        ala3.setFont(new Font("Tahoma",Font.ITALIC,14));
        ala3.setForeground(Color.WHITE);
        panel.add(ala3);

        JLabel Bill = new JLabel("Bill(in Rs)");
        Bill.setBounds(30,530,150,30);
        Bill.setFont(new Font("Tahoma",Font.BOLD,14));
        Bill.setForeground(Color.WHITE);
        panel.add(Bill);

        JLabel bill = new JLabel();
        bill.setBounds(330,530,150,30);
        bill.setFont(new Font("Tahoma",Font.ITALIC,14));
        bill.setForeground(Color.WHITE);
        panel.add(bill);

        JLabel cost = new JLabel();
        
        //panel.add(bill);


        JButton checkOut = new JButton("Generate");
        checkOut.setBounds(30,580,120,30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con cv = new con();
                    String total= bill.getText();
                    String prod=cost.getText();
                    String bills=Service.getSelectedItem();
                    String custom= cust.getText();
                    String table_n=tab.getText();

                    cv.statement.executeUpdate("insert into rest_expend values ('"+bills+"','"+custom+"','"+table_n+"','"+prod+"')");
                    cv.statement.executeUpdate("insert into rest_income values ('"+bills+"','"+custom+"','"+table_n+"','"+total+"')");
                    cv.statement.executeUpdate("update table_s set avail = 'Available'  where number = '"+table_n+"'");
                    cv.statement.executeUpdate("delete from booking where bill_Id = '"+bills+"'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                    dispose();
                }catch (Exception E ){
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,580,120,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con c = new con();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from booking where bill_Id = '"+Service.getSelectedItem()+"'");

                    int arr1[]=new int[6];
                    while (resultSet.next()){
                        cust.setText(resultSet.getString("customer"));
                        tab.setText(resultSet.getString("table_number"));
                        arr1[0]=Integer.parseInt(resultSet.getString("veg"));
                        arr1[1]=Integer.parseInt(resultSet.getString("egg"));
                        arr1[2]=Integer.parseInt(resultSet.getString("fish"));
                        arr1[3]=Integer.parseInt(resultSet.getString("chicken"));
                        arr1[4]=Integer.parseInt(resultSet.getString("mutton"));
                        arr1[5]=Integer.parseInt(resultSet.getString("ala"));
                    }

                    veg2.setText(String.valueOf(arr1[0]));
                    egg2.setText(String.valueOf(arr1[1]));
                    fish2.setText(String.valueOf(arr1[2]));
                    chicken2.setText(String.valueOf(arr1[3]));
                    mutton2.setText(String.valueOf(arr1[4]));
                    ala2.setText(String.valueOf(arr1[5]));
                    int arr2[]=new int[6];
                    int i=0;
                    int cost2=0,sell=0;
                    ResultSet resultSet2 = c.statement.executeQuery("select * from menu");
                    while (resultSet2.next()){
                        cost2+=(Integer.parseInt(resultSet2.getString("cost"))*arr1[i]);
                        int hold=(Integer.parseInt(resultSet2.getString("price"))*arr1[i]);
                        //System.out.println(hold);
                        arr2[i]=hold;
                        sell+=hold;
                        i++;
                    }
                    veg3.setText(String.valueOf(arr2[0]));
                    egg3.setText(String.valueOf(arr2[1]));
                    fish3.setText(String.valueOf(arr2[2]));
                    chicken3.setText(String.valueOf(arr2[3]));
                    mutton3.setText(String.valueOf(arr2[4]));
                    ala3.setText(String.valueOf(arr2[5]));
                    bill.setText(String.valueOf(sell));
                    cost.setText(String.valueOf(cost2));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170,580,120,30);
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
        setSize(800,660);
        setLocation(500,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GenerateBill();
    }
}
