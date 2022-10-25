package serivice.baseService;

import model.User;

public interface BaseService {

    boolean add(Object o, int id);

    Object getById(Object o, int id);

    boolean deleteById(int id);


}
