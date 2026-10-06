import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/** A login form demonstration; no account authentication or storage. */
public class LoginWindow extends JFrame {
    private final JTextField usernameField = new JTextField(18);
    private final JPasswordField passwordField = new JPasswordField(18);
    private final JLabel statusLabel = new JLabel("請輸入帳號與密碼（介面示範）");

    public LoginWindow() {
        super("登入視窗");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel form = new JPanel(new GridLayout(2, 2, 10, 12));
        JLabel usernameLabel = new JLabel("帳號：");
        JLabel passwordLabel = new JLabel("密碼：");
        usernameLabel.setLabelFor(usernameField);
        passwordLabel.setLabelFor(passwordField);
        form.add(usernameLabel);
        form.add(usernameField);
        form.add(passwordLabel);
        form.add(passwordField);

        JButton loginButton = new JButton("登入");
        loginButton.addActionListener(event -> submitForm());
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actions.add(loginButton);
        JPanel bottom = new JPanel(new BorderLayout(0, 8));
        bottom.add(statusLabel, BorderLayout.CENTER);
        bottom.add(actions, BorderLayout.SOUTH);

        JPanel content = new JPanel(new BorderLayout(0, 18));
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 16, 20));
        content.add(form, BorderLayout.CENTER);
        content.add(bottom, BorderLayout.SOUTH);
        setContentPane(content);
        getRootPane().setDefaultButton(loginButton);
        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
    }

    private void submitForm() {
        char[] password = passwordField.getPassword();
        try {
            if (usernameField.getText().trim().isEmpty() || password.length == 0) {
                statusLabel.setText("請填寫帳號與密碼。");
            } else {
                statusLabel.setText("已收到輸入；此示範未進行身分驗證。");
            }
        } finally {
            Arrays.fill(password, '\0');
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginWindow().setVisible(true));
    }
}
