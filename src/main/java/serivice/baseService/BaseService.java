package serivice.baseService;

public interface BaseService {

    boolean add(Object o);

    boolean add(Object o, int groupId);

    Object getById(int id);
    boolean deleteById(int id);


}
