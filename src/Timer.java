
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Timer extends JFrame {

    JPanel p;
    Container c;
    JButton b1, b2, b3, b4;
    JLabel l1, l2, l3, l4, l5,hl,ml,sl,msl,lp,l;
    //
    static int ms = 0;
    static int s = 0;
    static int m = 0;
    static int hr = 0;
    static boolean state = false;

    Timer() {
//        c=this.getContentPane();//coloring container
//        c.setBounds(0,0,500,100);
//        c.setBackground(Color.ORANGE);
//        c.setLayout(null);
        setLayout(null);
        p = new JPanel();
        p.setBounds(0, 0, 550, 100);
        p.setBackground(Color.yellow);
        add(p);
        
        ImageIcon img = new ImageIcon("timer.png");
        lp = new JLabel();
        lp.setBounds(17, 9, 330, 95);
        lp.setIcon(img);
        p.add(lp);
        
        l = new JLabel("TIMER");
        l.setBounds(50, 20, 100, 60);
        l.setFont(new Font("Segoe UI", Font.BOLD, 50));
        p.add(l);
        l1 = new JLabel("00:");
        l1.setBounds(50, 150, 100, 60);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 50));
        add(l1);
        l2 = new JLabel("00:");
        l2.setBounds(140, 150, 100, 60);
        l2.setFont(new Font("Segoe UI", Font.BOLD, 50));
        add(l2);
        l3 = new JLabel("00:");
        l3.setBounds(250, 150, 100, 60);
        l3.setFont(new Font("Segoe UI", Font.BOLD, 50));
        add(l3);
        l4 = new JLabel("00");
        l4.setBounds(360, 150, 150, 60);
        l4.setFont(new Font("Segoe UI", Font.BOLD, 55));
        add(l4);
        
         hl = new JLabel("Hours");
        hl.setBounds(50, 110, 100, 60);
        hl.setFont(new Font("Segoe UI", Font.BOLD, 13));
        add(hl);
         ml = new JLabel("Minutes");
        ml.setBounds(150, 110, 100, 60);
        ml.setFont(new Font("Segoe UI", Font.BOLD, 13));
        add(ml);
         sl = new JLabel("Seconds");
        sl.setBounds(250, 110, 100, 60);
        sl.setFont(new Font("Segoe UI", Font.BOLD, 13));
        add(sl);
         msl = new JLabel("Mili-Seconds");
       msl.setBounds(365, 110, 100, 60);
        msl.setFont(new Font("Segoe UI", Font.BOLD, 13));
        add(msl);

        b1 = new JButton("Start");
        b1.setFont(new Font("Raleway", Font.PLAIN, 15));
        b1.setBounds(80, 250, 90, 38);
        b1.setFocusable(false);
        add(b1);
        b2 = new JButton("Stop");
        b2.setFont(new Font("Raleway", Font.PLAIN, 15));
        b2.setBounds(220, 250, 90, 38);
        b2.setFocusable(false);
        add(b2);
        b3 = new JButton("Reset");
        b3.setFont(new Font("Raleway", Font.PLAIN, 15));
        b3.setBounds(350, 250, 90, 38);
        b3.setFocusable(false);
        add(b3);
        getContentPane().setBackground(Color.WHITE);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                state = true;
                Thread t = new Thread() {
                    public void run() {
                        for (;;) {
                            if (state == true) {
                                try {
                                    sleep(1);
                                    if (ms > 1000) {
                                        ms = 0;
                                        s++;
                                    }
                                    if (s > 60) {
                                        ms = 0;
                                        s = 0;
                                        m++;
                                    }
                                    if (m > 60) {
                                        ms = 0;
                                        s = 0;
                                        m = 0;
                                        hr++;
                                    }
                                    l4.setText(" : " + ms);
                                    ms++;
                                    l3.setText(" : " + s);
                                    l2.setText(" : " + m);
                                    l1.setText("" + hr);
                                } catch (Exception e) {

                                }
                            } else {
                                break;
                            }
                        }
                    }
                };//thread
                t.start();
            }
        });//end of ActionListener
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                state = false;
            }

        });//end of ActionListener
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                state = false;
                int ms = 0;
                s = 0;
                m = 0;
                hr = 0;
                l4.setText("00");
                l3.setText("00:");
                l2.setText("00:");
                l1.setText("00:");
            }

        });//end of ActionListener
    }

    public static void main(String[] args) {
        Timer frame = new Timer();
        frame.setBounds(100, 100, 550, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
