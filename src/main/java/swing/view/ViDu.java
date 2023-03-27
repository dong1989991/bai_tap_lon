package swing.view;

import javax.swing.*;

public class ViDu {
    public static void main(String[] args) {
        JFrame jf=new JFrame();

        //setup chieu cao chieu rong cua cua so
        jf.setSize(400,800);

        // hien thi tieu de
        jf.setTitle("doan van dong");

        //gan vi tri hien thi
        jf.setLocation(300,300);

        // thoat ra khoi chuong trinh khi dong cua so jframe
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //cho phep chay cua so
        jf.setVisible(true);
    }
}
