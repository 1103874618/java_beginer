import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TFDemo implements ActionListener {
  JTextField jtf;
  JButton jbtnRev;
  JLabel prompt,contents;
  TFDemo(){
    JFrame rm = new JFrame("Use a Text Field");
    rm.setLayout(new FlowLayout());
    rm.setSize(240,120);
    rm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jtf = new JTextField(10);
    jtf.setActionCommand("myTF");//给文本框的动作取个名字

    JButton jbtnRev = new JButton("Reserve");

    jtf.addActionListener(this);
    jbtnRev.addActionListener(this);

    prompt = new JLabel("Enter text: ");
    contents = new JLabel("");
    rm.add(prompt);
    rm.add(jtf);
    rm.add(contents);
    rm.add(jbtnRev);

    rm.setVisible(true);
  }

  public  void actionPerformed(ActionEvent ae){
    if (ae.getActionCommand().equals("Reserve")){ //动作名字对比
      String orgStr = jtf.getText();
      String resStr = "";

      for (int i= orgStr.length()-1;i>=0;i--){//文本框中字母顺序反转
        resStr +=orgStr.charAt(i);
        jtf.setText(resStr);
      }
    }else
      contents.setText("You pressed Enter. Text is: "+ jtf.getText());
  }

  public static void  main(String[] args){
    SwingUtilities.invokeLater(new Runnable() {

      public void run() {
          new TFDemo();
        }

    });
  }
}
