package ifsp.conpat.domain.interfaces.common;

import java.util.List;

/**
 * Created by Carlos Zucherato on 01/11/2016.
 */
public interface Irepository<TEntity> {

    void Add(TEntity entity);
    void Remove(TEntity entity);
    TEntity Get(int id);
    List<TEntity> All();
}
