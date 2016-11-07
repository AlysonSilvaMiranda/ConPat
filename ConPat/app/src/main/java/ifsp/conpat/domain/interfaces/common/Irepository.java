package ifsp.conpat.domain.interfaces.common;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.List;

/**
 * Created by Carlos Zucherato on 01/11/2016.
 */
public interface Irepository<TEntity> {

    boolean Add(TEntity entity);
    boolean Update(TEntity entity);
    boolean Remove(TEntity entity);
    TEntity Get(int id);
    List<TEntity> All();
    ContentValues serializeContentValues(TEntity entity);
    TEntity serializeByCursor(Cursor cursor, TEntity entity);
}
