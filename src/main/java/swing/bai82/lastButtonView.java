package swing.bai82;

import javax.swing.*;
import java.awt.*;

public class lastButtonView extends JFrame {
    private lastButtonModel model;
    public lastButtonView()
    {
        this.model=new lastButtonModel();
        this.init();
    }

    private void init() {
        this.setTitle("last button");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);

        JPanel jPanel_center=new JPanel();
        jPanel_center.setLayout((new GridLayout(2,2)));
        JButton jButton_1=new JButton("1");
        JButton jButton_2=new JButton("2");
        JButton jButton_3=new JButton("3");
        JButton jButton_4=new JButton("4");
        jPanel_center.add(jButton_1);
        jPanel_center.add(jButton_2);
        jPanel_center.add(jButton_3);
        jPanel_center.add(jButton_4);

        JPanel jPanel_footer=new JPanel();
        JLabel jLabel=new JLabel("----------");
        jPanel_footer.add(jLabel);


    }


}
