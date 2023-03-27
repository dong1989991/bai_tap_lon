package swing.view;

import javax.swing.*;

public class MyWindow extends JFrame {
    public MyWindow()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void show1()
    {
        this.setVisible(true);
    }
    public void show1(String title)
    {
        this.setTitle(title);
        this.setVisible(true);
    }
    public void show1(String title,int rong,int cao)
    {
        this.setTitle(title);
        this.setSize(rong,cao);
        this.setVisible(true);
      //  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MyWindow m1=new MyWindow();
        MyWindow m2=new MyWindow();
        m1.show1("xin chao cac ban",500,500);
        m2.show1("hello");
    }
}
