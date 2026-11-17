import javax.swing.*;
import java.awt.*;

public class MyLittleHouse extends JPanel {
    public MyLittleHouse() {
        setPreferredSize(new Dimension(500, 400)); // 1. 畫布 500 × 400
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 2. 天空與草地
        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, 500, 300);
        g.setColor(new Color(60, 160, 70));
        g.fillRect(0, 300, 500, 100);

        // 3. 太陽：黃色正圓 + 12 條 drawLine 光芒（cos / sin）
        int sx = 420, sy = 70;
        g.setColor(Color.YELLOW);
        g.fillOval(sx - 30, sy - 30, 60, 60);
        for (int i = 0; i < 12; i++) {
            double a = Math.toRadians(i * 30);
            g.drawLine(sx + (int) (38 * Math.cos(a)), sy + (int) (38 * Math.sin(a)),
                       sx + (int) (52 * Math.cos(a)), sy + (int) (52 * Math.sin(a)));
        }

        // 4. 雲：3 個互相重疊的白色橢圓
        g.setColor(Color.WHITE);
        g.fillOval(50, 60, 80, 45);
        g.fillOval(90, 45, 90, 55);
        g.fillOval(140, 62, 70, 40);

        // 5. 房屋主體
        int hx = 150, hy = 200, hw = 200, hh = 140;
        g.setColor(new Color(250, 225, 180));
        g.fillRect(hx, hy, hw, hh);
        g.setColor(Color.BLACK);
        g.drawRect(hx, hy, hw, hh);

        // 6. 屋頂：只用 3 條 drawLine 畫三角形
        g.setColor(Color.RED);
        g.drawLine(hx - 20, hy, hx + hw / 2, 120);
        g.drawLine(hx + hw / 2, 120, hx + hw + 20, hy);
        g.drawLine(hx + hw + 20, hy, hx - 20, hy);

        // 7. 門與門把
        g.setColor(new Color(120, 70, 30));
        g.fillRoundRect(228, 265, 44, 75, 12, 12);
        g.setColor(Color.YELLOW);
        g.fillOval(260, 300, 7, 7);

        // 8. 兩扇十字窗
        drawWindow(g, 168, 225, 45, 45);
        drawWindow(g, 287, 225, 45, 45);

        // 9. 簽名
        g.setColor(Color.BLACK);
        g.drawString("A1131351 孟祥文", 15, 385);
    }

    private void drawWindow(Graphics g, int x, int y, int w, int h) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, w, h);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, w, h);
        g.drawLine(x, y + h / 2, x + w, y + h / 2);
        g.drawLine(x + w / 2, y, x + w / 2, y + h);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("我的小房子");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new MyLittleHouse());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
