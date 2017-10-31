import javax.swing.*;

public class RVDriver extends JFrame {
    public static void main(String[] args) {

        JFrame f = new JFrame(); //creating new instance of JFrame

        JButton b = new JButton("click"); //creating instance of JButton
        b.setBounds(100,200,100,50);

        JLabel employeeName = new JLabel("Employee Name");


        JTextField employeeNameText = new JTextField();

        f.add(employeeName);
        f.add(b); //adding button to JFrame

        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);

        DatabaseUser dbUser = new DatabaseUser();

        //create customer
        //dbUser.createCustomer("test", "acc");

        //show all customers
        dbUser.showCustomerInfo();
    }
}
