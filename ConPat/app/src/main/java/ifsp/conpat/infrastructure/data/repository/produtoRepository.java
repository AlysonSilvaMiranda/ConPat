package ifsp.conpat.infrastructure.data.repository;

import java.util.List;

import ifsp.conpat.domain.entities.produto;
import ifsp.conpat.domain.interfaces.IprodutoRepository;

/**
 * Created by Carlos Zucherato on 02/11/2016.
 */
public class produtoRepository implements IprodutoRepository {
    @Override
    public void Add(produto produto) {

    }

    @Override
    public void Remove(produto produto) {

    }

    @Override
    public produto Get(int id) {
        return null;
    }

    @Override
    public List<produto> All() {
        return null;
    }
}
