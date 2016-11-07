package ifsp.conpat.infrastructure.data.repository;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.List;

import ifsp.conpat.domain.entities.gestor;
import ifsp.conpat.domain.interfaces.IgestorRepository;

/**
 * Created by Carlos Zucherato on 02/11/2016.
 */
public class gestorRepository implements IgestorRepository {
    @Override
    public boolean Add(gestor gestor) {
        return false;
    }

    @Override
    public boolean Update(gestor gestor) {
        return false;
    }

    @Override
    public boolean Remove(gestor gestor) {
        return false;
    }

    @Override
    public gestor Get(int id) {
        return null;
    }

    @Override
    public List<gestor> All() {
        return null;
    }

    @Override
    public ContentValues serializeContentValues(gestor gestor) {
        return null;
    }

    @Override
    public gestor serializeByCursor(Cursor cursor, gestor gestor) {
        return null;
    }
}
