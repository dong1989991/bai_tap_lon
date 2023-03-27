package bai61.sql;

import java.util.ArrayList;

public class KhachHangDAO implements DAOInterface {
    public  static KhachHangDAO getInstance(){
        return  new KhachHangDAO();
    }
    @Override
    public int insert(Object o) {
        return 0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @Override
    public ArrayList selectAll() {
        return null;
    }

    @Override
    public Object selectByID(Object o) {
        return null;
    }

    @Override
    public ArrayList selectByCondition(String condition) {
        return null;
    }
}
