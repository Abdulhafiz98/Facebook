package serivice.baseService;

import model.User;

public interface BaseService {

    boolean add(Object o);

    boolean add(Object o, int groupId);

    Object getById(int id);

    int getById(Object o);

    boolean deleteById(Object o);

    boolean deleteById(int id);


}
