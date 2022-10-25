package serivice.baseService;

import model.User;

public interface BaseService {

    boolean add(Object o);

    Object getById(int id);

    boolean deleteById(int id);


}
