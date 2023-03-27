package swing.bai81MVC.controller;

import swing.bai81MVC.view.CounterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterListener implements ActionListener {
   private CounterView ctv;

    public CounterListener(CounterView ctv)
    {
        this.ctv=ctv;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       // System.out.println("ban da nhan nut");
        String src=e.getActionCommand();
        System.out.println("ban da nhan nut:"+src);
        if(src.equals("up"))
        {
            this.ctv.increment();
        }
        else if(src.equals("reset"))
        {
            this.ctv.reset();
        }
        else if (src.equals("down"))
        {
            this.ctv.decrement();
        }
    }
}
