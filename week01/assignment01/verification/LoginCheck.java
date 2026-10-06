import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
public class LoginCheck {
 static LoginWindow window;
 static ArrayList<Component> components = new ArrayList<>();
 static void collect(Container c) { for (Component x:c.getComponents()) { components.add(x); if(x instanceof Container) collect((Container)x); } }
 static void check(boolean value,String message) { if(!value) throw new AssertionError(message); System.out.println("PASS: "+message); }
 public static void main(String[] args) throws Exception {
  try {
   SwingUtilities.invokeAndWait(()-> {window=new LoginWindow();window.setVisible(true);window.toFront();collect(window);});
   Thread.sleep(1200);
   Robot robot=new Robot();
   ImageIO.write(robot.createScreenCapture(window.getBounds()),"png",new File(args[0]+"/result-01.png"));
   SwingUtilities.invokeAndWait(()-> {
    JTextField user=(JTextField)components.stream().filter(c->c.getClass()==JTextField.class).findFirst().get();
    JPasswordField pass=(JPasswordField)components.stream().filter(c->c instanceof JPasswordField).findFirst().get();
    JButton button=window.getRootPane().getDefaultButton();
    JLabel status=(JLabel)components.stream().filter(c->c instanceof JLabel && ((JLabel)c).getText().contains("介面示範")).findFirst().get();
    check(user.isShowing()&&pass.isShowing()&&button.isShowing(),"input fields and button visible");
    check(pass.getEchoChar()!=0,"password is masked");
    button.doClick();check(status.getText().equals("請填寫帳號與密碼。"),"empty submission feedback");
    user.setText("student-demo");button.doClick();check(status.getText().equals("請填寫帳號與密碼。"),"missing password feedback");
    user.setText("   ");pass.setText("demo-only");button.doClick();check(status.getText().equals("請填寫帳號與密碼。"),"blank username feedback");
    user.setText("student-demo");pass.setText("demo-only");
   });
   Thread.sleep(400);
   ImageIO.write(robot.createScreenCapture(window.getBounds()),"png",new File(args[0]+"/result-02.png"));
   SwingUtilities.invokeAndWait(()->{
    window.getRootPane().getDefaultButton().doClick();
    check(components.stream().anyMatch(c->c instanceof JLabel && ((JLabel)c).getText().equals("已收到輸入；此示範未進行身分驗證。")),"filled form feedback does not claim authentication");
    JPasswordField pass=(JPasswordField)components.stream().filter(c->c instanceof JPasswordField).findFirst().get();
    check(pass.getPassword().length==0,"password cleared after submission");
   });
   Thread.sleep(400);
   ImageIO.write(robot.createScreenCapture(window.getBounds()),"png",new File(args[0]+"/result-03.png"));
  } finally { if(window!=null) SwingUtilities.invokeAndWait(()->window.dispose()); }
 }
}
