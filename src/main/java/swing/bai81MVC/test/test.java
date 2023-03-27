package swing.bai81MVC.test;

import swing.bai81MVC.model.CounteModel;
import swing.bai81MVC.view.CounterView;

public class test {
    public static void main(String[] args) {
        CounteModel ct=new CounteModel();
        ct.incresment();
        ct.incresment();
        ct.incresment();
        System.out.println(ct.getValues());
        ct.decrement();
        System.out.println(ct.getValues());

        CounterView ctv=new CounterView();
    }
}
