import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DiceSimulator2 extends JFrame {
    private final JLabel numberLabel = new JLabel("—", SwingConstants.CENTER);
    private final JLabel statsLabel =
            new JLabel("已擲 0 次，總和 0，平均 0.00", SwingConstants.CENTER);
    private final DicePanel dicePanel = new DicePanel();
    private final JButton rollButton = new JButton("擲骰子");
    private final Random random = new Random();

    private int count = 0;
    private int sum = 0;

    public DiceSimulator2() {
        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        numberLabel.setFont(new Font("SansSerif", Font.BOLD, 60));

        JPanel center = new JPanel(new BorderLayout());
        center.add(numberLabel, BorderLayout.NORTH);
        center.add(dicePanel, BorderLayout.CENTER);

        add(statsLabel, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(rollButton, BorderLayout.SOUTH);

        // 按鈕事件：擲骰、更新文字與統計，並通知圖案重畫
        rollButton.addActionListener(e -> rollDice());

        setLocationRelativeTo(null);
    }

    private void rollDice() {
        int value = random.nextInt(6) + 1;

        count++;
        sum += value;
        double average = (double) sum / count;

        Color color = value == 6 ? Color.GREEN : value == 1 ? Color.RED : Color.BLACK;

        numberLabel.setText(String.valueOf(value));
        numberLabel.setForeground(color);
        dicePanel.setPoint(value, color);
        statsLabel.setText(String.format("已擲 %d 次，總和 %d，平均 %.2f", count, sum, average));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DiceSimulator2().setVisible(true));
    }
}
