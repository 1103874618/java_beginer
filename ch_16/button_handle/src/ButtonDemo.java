import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonDemo implements ActionListener {
  JLabel jlab;
  ButtonDemo(){
    JFrame jfrm = new JFrame("A Button Example ");
    jfrm.setLayout(new FlowLayout());

    jfrm.setSize(220,90);
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton jbtnUp = new JButton("Up");
    JButton jbtnDown = new JButton("Down");

    jbtnUp.addActionListener(this);//给自己添加事件监听
    jbtnDown.addActionListener(this);

    jfrm.add(jbtnUp);
    jfrm.add(jbtnDown);
    jlab = new JLabel("Press a button.");
    jfrm.add(jlab);

    jfrm.setVisible(true);

  }

  public void actionPerformed (ActionEvent ae){
    if (ae.getActionCommand().equals("Up"))
      jlab.setText("You pressed Up");
    else
      jlab.setText("Your pressed Down");
  }

  public static void main(String args[]){
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new ButtonDemo();
      }
    });
  }
}
//此程序演示了获取按钮的信息的方法
