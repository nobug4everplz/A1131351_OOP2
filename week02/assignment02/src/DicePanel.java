import javax.swing.*;
import java.awt.*;

// 自行繪製骰子圖案：白底外框 + 1～6 點圓點
public class DicePanel extends JPanel {
    // 圓點在 3×3 格中的位置，索引 0～8 由左上到右下
    private static final int[][] PIPS = {
            {},
            {4},
            {0, 8},
            {0, 4, 8},
            {0, 2, 6, 8},
            {0, 2, 4, 6, 8},
            {0, 2, 3, 5, 6, 8}
    };

    private int point = 0;          // 0 代表尚未擲骰，只畫外框
    private Color pipColor = Color.BLACK;

    public void setPoint(int point, Color color) {
        this.point = point;
        this.pipColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = Math.min(getWidth(), getHeight()) - 20;
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        g2.setColor(Color.WHITE);
        g2.fillRoundRect(x, y, size, size, 24, 24);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(x, y, size, size, 24, 24);

        int cell = size / 3;
        int d = size / 6;           // 圓點直徑
        g2.setColor(pipColor);
        for (int idx : PIPS[point]) {
            int cx = x + (idx % 3) * cell + cell / 2;
            int cy = y + (idx / 3) * cell + cell / 2;
            g2.fillOval(cx - d / 2, cy - d / 2, d, d);
        }
        g2.dispose();
    }
}
