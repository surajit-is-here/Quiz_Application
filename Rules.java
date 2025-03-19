import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    Rules(String name)
    {
        this.name = name;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Welcome "+name+" to Simple Quiz");
        heading.setBounds(50,20,700,28);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
        heading.setForeground(Color.PINK);
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20,90,700,350);
        rules.setFont(new Font("Tahoma",Font.PLAIN,16));
        rules.setText(
                "<html>"+
                        "1. Each question carries 1 point. Answer wisely!" + "<br><br>" +
                        "2. No cheating! But creative guessing is highly encouraged." + "<br><br>" +
                        "3. Googling is strictly prohibited – trust your brain (or your luck!)." + "<br><br>" +
                        "4. Smiling is allowed, but laughing at wrong answers is at your own risk!" + "<br><br>" +
                        "5. If you're unsure of an answer, pick the funniest option – it might just be right!" + "<br><br>" +
                        "6. Teamwork makes the dream work, but whispering too loud might make you a solo player." + "<br><br>" +
                        "7. The quizmaster’s decision is final (even if it feels unfair – deal with it!)." + "<br><br>" +
                        "8. Have fun, enjoy the game, and may the best brain (or the luckiest guesser) win!" + "<br><br>" +
                        "</html>"

        );

        add(rules);

        start = new JButton("Start");
        start.setBounds(550,480,110,30);
        start.setBackground(Color.green);
        start.addActionListener(this);
        add(start);

        back = new JButton("Back");
        back.setBounds(90,480,110,30);
        back.setBackground(Color.YELLOW);
        back.addActionListener(this);
        add(back);

        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==start)
        {
            setVisible(false);
            new Quiz(name);
        }
        else
        {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
