import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DiceSimulator extends JFrame {
    private final JLabel numberLabel =
            new JLabel("0", SwingConstants.CENTER);

    private final JLabel statsLabel =
            new JLabel("已擲 0 次，總和 0，平均 0.00",
                       SwingConstants.CENTER);

    private final Random random = new Random();

    private int count = 0;  
    private int sum = 0;    

    public DiceSimulator() {
        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        numberLabel.setFont(new Font("SansSerif", Font.BOLD, 60));
        numberLabel.setForeground(Color.BLACK);

        JButton rollButton = new JButton("擲骰子");

        add(statsLabel, BorderLayout.NORTH);
        add(numberLabel, BorderLayout.CENTER);
        add(rollButton, BorderLayout.SOUTH);

        rollButton.addActionListener(e -> rollDice());

        setLocationRelativeTo(null); // 視窗置中
    }

    private void rollDice() {
        int value = random.nextInt(6) + 1; // 產生 1～6

        count++;
        sum += value;
        double average = (double) sum / count;

        numberLabel.setText(String.valueOf(value));

        if (value == 6) {
            numberLabel.setForeground(Color.GREEN);
        } else if (value == 1) {
            numberLabel.setForeground(Color.RED);
        } else {
            numberLabel.setForeground(Color.BLACK);
        }

        statsLabel.setText(String.format(
                "已擲 %d 次，總和 %d，平均 %.2f",
                count, sum, average
        ));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DiceSimulator window = new DiceSimulator();
            window.setVisible(true);
        });
    }
}