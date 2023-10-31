package u2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class L7_AddingJComponents implements ActionListener {

    JButton button1;

    // Constructor
    public L7_AddingJComponents() {
        JFrame myFrame = new JFrame("My FUN Program");

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        myPanel.setPreferredSize(new Dimension(600, 800));
        myPanel.setBackground(new Color(166, 166, 166));

        button1 = new JButton("CLICK MEEEEEEEEEEEEEEEE");
        button1.addActionListener(this);
        // button1.setBounds(new Rectangle(300, 400, 200, 100));

        JLabel text = new JLabel("HAPPY HALLOWEEENNNN!!!!");
        text.setForeground(Color.ORANGE);
        // text.setBounds(new Rectangle(100, 100, 300, 100));

        topPanel.add(button1);

        myPanel.add(BorderLayout.CENTER, topPanel);
        myPanel.add(BorderLayout.SOUTH, text);

        myFrame.add(myPanel);
        myFrame.pack();
        myFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new L7_AddingJComponents();
    }

    public void actionPerformed(ActionEvent e) {
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
    }
}
