package fenetre;

import javax.swing.*;

public class Paint {
    private JPanel rootPanel;
    private JPanel helloLabel;
    private JButton pressMeButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paint");
        frame.setContentPane(new Paint().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
