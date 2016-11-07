package ifsp.conpat.infrastructure.data.repository;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.List;

import ifsp.conpat.domain.entities.departamento;
import ifsp.conpat.domain.interfaces.IdepartamentoRepository;

/**
 * Created by Carlos Zucherato on 02/11/2016.
 */
public class departamentoRepository implements IdepartamentoRepository {
    @Override
    public boolean Add(departamento departamento) {
        return false;
    }

    @Override
    public boolean Update(departamento departamento) {
        return false;
    }

    @Override
    public boolean Remove(departamento departamento) {
        return false;
    }

    @Override
    public departamento Get(int id) {
        return null;
    }

    @Override
    public List<departamento> All() {
        return null;
    }

    @Override
    public ContentValues serializeContentValues(departamento departamento) {
        return null;
    }

    @Override
    public departamento serializeByCursor(Cursor cursor, departamento departamento) {
        return null;
    }
}
