package tribble.dao;

import java.util.List;

public interface Dao<T,K> {

    void create(T t);

    T read(K id);

    void update(T t);

    void delete(K k);

    List<T> getAll();
}
