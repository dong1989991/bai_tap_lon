package swing.java79.view.view;

import javax.swing.*;
import java.awt.*;

public class ViDuFlowLayout extends JFrame {
    public ViDuFlowLayout()
    {
        this.setTitle("Vi du Flow layout");
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        FlowLayout flowLayout=new FlowLayout();
        FlowLayout flowLayout1=new FlowLayout(FlowLayout.RIGHT);
        FlowLayout flowLayout2=new FlowLayout(FlowLayout.CENTER,10,10);
        this.setLayout(flowLayout2);

        JButton jButton1=new JButton("1");
        JButton jButton2=new JButton("2");
        JButton jButton3=new JButton("3");

        this.add(jButton1);
        this.add(jButton2);
        this.add(jButton3);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
         ViDuFlowLayout viDuFlowLayout=new ViDuFlowLayout();
    }

}
