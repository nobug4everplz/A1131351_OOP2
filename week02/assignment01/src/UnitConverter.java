import javax.swing.*;
import java.awt.*;

public class UnitConverter extends JFrame {
    private static final String[] CATEGORIES = {"長度", "重量", "溫度"};
    private static final String[][] UNITS = {
            {"公尺", "公分", "英吋", "英尺"},
            {"公斤", "公克", "磅", "盎司"},
            {"攝氏", "華氏", "克氏"}
    };
    // 長度、重量：各單位換成基準單位（公尺、公斤）的倍率
    private static final double[][] TO_BASE = {
            {1, 0.01, 0.0254, 0.3048},
            {1, 0.001, 0.45359237, 0.028349523125}
    };

    private final JComboBox<String> categoryBox = new JComboBox<>(CATEGORIES);
    private final JTextField inputField = new JTextField();
    private final JTextField resultField = new JTextField();
    private final JComboBox<String> fromUnitBox = new JComboBox<>(UNITS[0]);
    private final JComboBox<String> toUnitBox = new JComboBox<>(UNITS[0]);

    public UnitConverter() {
        setTitle("單位換算器");
        setSize(480, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        resultField.setEditable(false);
        toUnitBox.setSelectedIndex(1);

        JPanel center = new JPanel(new GridLayout(2, 2, 10, 10));
        center.add(inputField);
        center.add(fromUnitBox);
        center.add(resultField);
        center.add(toUnitBox);

        JButton convertButton = new JButton("換算");

        add(categoryBox, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(convertButton, BorderLayout.SOUTH);

        categoryBox.addActionListener(e -> updateUnits());
        convertButton.addActionListener(e -> onConvert());

        setLocationRelativeTo(null);
    }

    // 切換類型時，兩個單位選單一起換成該類型的單位
    private void updateUnits() {
        String[] units = UNITS[categoryBox.getSelectedIndex()];
        fromUnitBox.setModel(new DefaultComboBoxModel<>(units));
        toUnitBox.setModel(new DefaultComboBoxModel<>(units));
        toUnitBox.setSelectedIndex(1);
        resultField.setText("");
    }

    private void onConvert() {
        double value;
        try {
            value = Double.parseDouble(inputField.getText().trim());
        } catch (NumberFormatException ex) {
            value = Double.NaN;
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            JOptionPane.showMessageDialog(this, "請輸入有效的數字", "輸入錯誤",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        double result = convert(categoryBox.getSelectedIndex(),
                fromUnitBox.getSelectedIndex(), toUnitBox.getSelectedIndex(), value);
        resultField.setText(String.format("%.4f", result));
    }

    // 先換成基準單位，再換成目標單位
    static double convert(int category, int from, int to, double value) {
        if (category == 2) {
            double celsius = toCelsius(from, value);
            return fromCelsius(to, celsius);
        }
        return value * TO_BASE[category][from] / TO_BASE[category][to];
    }

    private static double toCelsius(int unit, double v) {
        switch (unit) {
            case 1: return (v - 32) * 5 / 9;
            case 2: return v - 273.15;
            default: return v;
        }
    }

    private static double fromCelsius(int unit, double c) {
        switch (unit) {
            case 1: return c * 9 / 5 + 32;
            case 2: return c + 273.15;
            default: return c;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UnitConverter().setVisible(true));
    }
}
