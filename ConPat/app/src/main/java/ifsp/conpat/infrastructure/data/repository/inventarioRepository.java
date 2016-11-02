package ifsp.conpat.infrastructure.data.repository;

import java.util.List;

import ifsp.conpat.domain.entities.inventario;
import ifsp.conpat.domain.interfaces.IinventarioRepository;

/**
 * Created by Carlos Zucherato on 02/11/2016.
 */
public class inventarioRepository implements IinventarioRepository {
    @Override
    public void Add(inventario inventario) {

    }

    @Override
    public void Remove(inventario inventario) {

    }

    @Override
    public inventario Get(int id) {
        return null;
    }

    @Override
    public List<inventario> All() {
        return null;
    }
}