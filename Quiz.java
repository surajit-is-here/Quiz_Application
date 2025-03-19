import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    String [][]questions= new String[10][5];
    String [][]answers = new String[10][2];
    String [][]userans = new String[10][1];
    String name;
    JLabel qno,question;
    JRadioButton opt1,opt2,opt3,opt4;
    JButton next,lifeline,submit;
    JProgressBar progressBar;
    ButtonGroup group;
    public static int ans_count =0;
    public static int timer = 15;
    public static int score = 0;
    public static boolean ans_given = false;

    Quiz(String name)
    {
        this.name = name;

        setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        progressBar = new JProgressBar(1, 10); // Assuming 10 questions
        progressBar.setValue(1);// Start at Question 1
        progressBar.setBounds(600, 750, 200, 30);
        progressBar.setStringPainted(true);    // Show "Question x/10"
        add(progressBar); // Add to the top of the frame

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1440,400);
        add(image);

        qno = new JLabel();
        qno.setBounds(100,450,50,30);
        qno.setFont(new Font("Arial",Font.PLAIN,24));
        add(qno);

        question = new JLabel();
        question.setBounds(140,450,900,30);
        question.setFont(new Font("Arial",Font.PLAIN,24));
        add(question);


        /* Please find the Questions with Options of Quiz Application */


        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        /* Find below the Answers Array of the above Questions */


        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";


        opt1 = new JRadioButton();
        opt1.setBounds(170,520,700,30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170,560,700,30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170,600,700,30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170,640,700,30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt4);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);


        next = new JButton("Next");
        next.setBounds(1100,550,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100,620,200,40);
        lifeline.setFont(new Font("Tahoma",Font.PLAIN,22));
        lifeline.setBackground(new Color(30,144,255));
        lifeline.setForeground(Color.white);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100,690,200,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.white);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(ans_count);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==next)
        {
            repaint();

            progressBar.setValue(ans_count+1);                        // Update the bar
            progressBar.setString("Question " + (ans_count+2) + "/10"); // Show question text

            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given=true;
            if(group.getSelection()==null)
                userans[ans_count][0] = "";
            else
                userans[ans_count][0] = group.getSelection().getActionCommand();

            if(ans_count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            ans_count++;
            start(ans_count);
        }
        else if(e.getSource()==lifeline)
        {
            if(ans_count==2 || ans_count==4 || ans_count==6 || ans_count==8 || ans_count==9)
            {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }
            else
            {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
        else if(e.getSource()==submit)
        {
            ans_given=true;
            if(group.getSelection()==null)
                userans[ans_count][0] = "";
            else
                userans[ans_count][0] = group.getSelection().getActionCommand();

            for(int i=0;i<userans.length;i++)
            {
                if(userans[i][0].equals(answers[i][1]))
                    score+=1;
            }
            setVisible(false);
            //Call Score frame
            new Score(name,score);
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        String time = "Time Left - "+ timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,20));

        if(timer>0)
        {
            g.drawString(time,1100,500);
        }
        else
        {
            g.drawString("Times Up!!!",1100,500);
        }

        timer--;

        try
        {
            Thread.sleep(1000);
            repaint();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        if(ans_given)
        {
            ans_given=false;
            timer = 15;
        }
        else if(timer<0)
        {
            timer=15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if(ans_count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(ans_count==9)    //submit button not clicked at end
            {
                if(group.getSelection()==null)
                    userans[ans_count][0] = "";
                else
                    userans[ans_count][0] = group.getSelection().getActionCommand();

                for(int i=0;i<userans.length;i++)
                {
                    if(userans[i][0].equals(answers[i][1]))
                        score+=1;
                }
                setVisible(false);
                new Score(name,score);
            }
            else    //next button not clicked
            {
                if(group.getSelection()==null)
                    userans[ans_count][0] = "";
                else
                    userans[ans_count][0] = group.getSelection().getActionCommand();

                ans_count++;
                start(ans_count);
            }
        }
    }

    public void start(int count)
    {
        qno.setText(""+(count+ 1)+".  ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        group.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
