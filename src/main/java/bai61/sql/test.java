package bai61.sql;
public class test {
    public static void main(String[] args) {
//        Sach sach1 = new Sach("LTJV", "Lập trình Java", 50000, 2025);
//        Sach sach2 = new Sach("LTC", "Lập trình C", 70000, 2030);
//
//        SachDAO.getInstance().insert(sach2);
//        for(int i=0;i<1000;i++)
//        {
//            Sach sach=new Sach("LT"+i,"lap trinh"+i,2000,2015);
//            SachDAO.getInstance().insert(sach);
//        }
        Sach sach2 = new Sach("LTC", "Lập trình C", 70000, 2030);
        SachDAO.getInstance().update(sach2);
    }
}
