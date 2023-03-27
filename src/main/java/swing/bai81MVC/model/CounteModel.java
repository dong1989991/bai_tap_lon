package swing.bai81MVC.model;

public class CounteModel {
    private int values;
    public CounteModel()
    {
        this.values=0;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }
    public  void incresment()
    {
        this.values++;
    }
    public  void decrement()
    {
        this.values--;
    }
    public void reset()
    {
        this.values=0;
    }
}
