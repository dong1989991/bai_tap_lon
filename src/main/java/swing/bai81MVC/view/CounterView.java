package swing.bai81MVC.view;

import swing.bai81MVC.controller.CounterListener;
import swing.bai81MVC.model.CounteModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CounterView extends JFrame {
    private CounteModel counteModel;
    private JButton jButton_up;
    private JButton jButton_down;
    private JButton jButton_reset;
    private JLabel jLabel_value;
    public CounterView()
    {
        this.counteModel=new CounteModel();
        this.init();
        this.setVisible(true);
    }
    public void init()
    {
        this.setTitle("Counter");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener ac=new CounterListener(this);

        jButton_reset=new JButton("reset");
        jButton_reset.addActionListener(ac);

        jButton_up=new JButton("up");
        jButton_up.addActionListener(ac);

        jButton_down=new JButton("down");
        jButton_down.addActionListener(ac);

        jLabel_value=new JLabel(this.counteModel.getValues()+"",JLabel.CENTER);
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jButton_up,BorderLayout.WEST);
        jPanel.add(jLabel_value,BorderLayout.CENTER);
        jPanel.add(jButton_down,BorderLayout.EAST);
        jPanel.add(jButton_reset,BorderLayout.SOUTH);


        this.setLayout(new BorderLayout());
        this.add(jPanel,BorderLayout.CENTER);
    }
    public void increment()
    {
        this.counteModel.incresment();
        this.jLabel_value.setText(this.counteModel.getValues()+"");
    }
    public void decrement()
    {
        this.counteModel.decrement();
        this.jLabel_value.setText(this.counteModel.getValues()+"");
    }
    public void reset()
    {
        this.counteModel.reset();
        this.jLabel_value.setText(this.counteModel.getValues()+"");
    }
}
