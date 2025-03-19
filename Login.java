import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JButton back,rules;
    JTextField tf;

    Login()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,600,500);
        add(image);

        JLabel heading = new JLabel("Simple Quiz");
        heading.setBounds(750,60,300,60);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setForeground(Color.green);
        add(heading);

        JLabel name = new JLabel("Enter your Name");
        name.setBounds(810,150,500,60);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        name.setForeground(Color.CYAN);
        add(name);

        tf = new JTextField();
        tf.setBounds(730,200,300,40);
        tf.setFont(new Font(("Times New Roman"),Font.ITALIC,20));
        add(tf);

        rules = new JButton("Rules");
        rules.setBounds(745,280,110,30);
        rules.setBackground(new Color(30,144,254));
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(900,280,110,30);
        back.setBackground(new Color(30,144,254));
        back.addActionListener(this);
        add(back);



        setSize(1200,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public  void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==rules)
        {
            String name = tf.getText();
            setVisible(false);
            new Rules(name);
        }
        else if(e.getSource()==back)
        {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}


