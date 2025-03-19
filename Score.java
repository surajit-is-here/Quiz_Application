import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {


    JButton submit,quit;

    Score(String name , int score)
    {
        setBounds(600,150,900,600);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("score.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,250,600,250);
        add(image);

        JLabel heading = new JLabel("Thank You "+ name+" for playing");
        heading.setBounds(130,30,700,45);
        heading.setFont(new Font("Georgia",Font.PLAIN,40));
        heading.setForeground(Color.blue);
        add(heading);

        JLabel total = new JLabel("Your Score is "+score+"/10");
        total.setBounds(280,170,300,30);
        total.setFont(new Font("Comic Sans MS",Font.PLAIN,26));
        total.setForeground(Color.red);
        add(total);

        Timer timer = new Timer(500, new ActionListener() {
            private boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                visible = !visible; // Toggle visibility
                total.setVisible(visible);
            }
        });

        timer.start();

        submit = new JButton("Play Again");
        submit.setBounds(500,270,200,40);
        submit.setFont(new Font("Georgia",Font.BOLD,18));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.MAGENTA);
        submit.addActionListener(this);
        add(submit);

        quit = new JButton("Exit");
        quit.setBounds(500,350,200,40);
        quit.setFont(new Font("Georgia",Font.BOLD,18));
        quit.setBackground(new Color(30,144,255));
        quit.setForeground(Color.MAGENTA);
        quit.addActionListener(this);
        add(quit);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit)
        {
            setVisible(false);
            new Login();
        }
        else
        {
            setVisible(false);
            dispose();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Score("User",0);
    }
}
