import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class calculator extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField tf;
    String s0, s1, s2;

    calculator()
    {
        s0 = s1 = s2 = "";
        frame = new JFrame("calculator");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        tf = new JTextField(16);

        tf.setEditable(false);

        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1,
                bsign, bpower, bmod, bfactorial;

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        beq1 = new JButton("=");

        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");

        bsign = new JButton("+/-");
        bpower = new JButton("^");
        bmod = new JButton("%");
        bfactorial = new JButton("!");


        be = new JButton(".");

        JPanel p = new JPanel();
        bm.addActionListener(this);
        bd.addActionListener(this);
        bs.addActionListener(this);
        ba.addActionListener(this);
        b9.addActionListener(this);
        b8.addActionListener(this);
        b7.addActionListener(this);
        b6.addActionListener(this);
        b5.addActionListener(this);
        b4.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
        b1.addActionListener(this);
        b0.addActionListener(this);
        be.addActionListener(this);
        beq.addActionListener(this);
        beq1.addActionListener(this);

        bsign.addActionListener(this);
        bpower.addActionListener(this);
        bmod.addActionListener(this);
        bfactorial.addActionListener(this);
        p.add(tf);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);

        p.add(beq);

        p.add(bpower);
        p.add(bmod);
        p.add(bfactorial);
        p.add(bsign);
        p.add(beq1);
        p.setBackground(Color.GRAY);

        frame.add(p);
        frame.setSize(200, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;
            tf.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";
            tf.setText(s0 + s1 + s2);
        }

        else if (s.charAt(0) == '=') {

            double te ;
            double t = 1;
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else if (s1.equals("*"))
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));


            else if(s1.equals("+/-")){
                te = ((Double.parseDouble(s0) * -1));
            }

            else if (s1.equals("^")) {
                for (int i = 0; i < Integer.parseInt(s2); i++) {
                    t *= Double.parseDouble(s0);
                }
                te = t;
            }
            else if (s1.equals("%")){
                te = (Double.parseDouble(s0) % Double.parseDouble(s2));
            }


            else if (s1.equals("!")) {
                for (int i = 1; i <= Integer.parseInt(s0); i++) {
                    t *= (i);
                }
                te = t;
            }
            else {
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            }
            tf.setText(s0 + s1 + s2 + "=" + te);
            s0 = Double.toString(te);
            s1 = s2 = "";
        }

        else {

            if (s1.equals("") || s2.equals(""))
                s1 = s;
            else {
                double te;
                double t = 1;
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else if (s1.equals("*"))
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));

                else if(s1.equals("+/-")){
                    te = ((Double.parseDouble(s0) * -1));
                }
                else if (s1.equals("^")) {
                    for (int i = 0; i < Integer.parseInt(s2); i++) {
                        t *= Double.parseDouble(s0);
                    }
                    te = t;
                }
                else if (s1.equals("%")){
                    te = (Double.parseDouble(s0) % Double.parseDouble(s2));
                }

                else if (s1.equals("!")) {
                    for (int i = 1; i <= Integer.parseInt(s0); i++) {
                        t *= (i);
                    }
                    te = t;
                }
                else {
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                }

                s0 = Double.toString(te);
                s1 = s;
                s2 = "";
            }
            tf.setText(s0 + s1 + s2);
        }
    }
}


class Main {
    public static void main(String[] args) {
        calculator c = new calculator();
    }

}