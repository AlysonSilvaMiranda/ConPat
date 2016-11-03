package ifsp.conpat.infrastructure.data.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.List;

import ifsp.conpat.domain.entities.produto;
import ifsp.conpat.domain.interfaces.IprodutoRepository;
import ifsp.conpat.infrastructure.data.context.applicationDbContext;

/**
 * Created by Carlos Zucherato on 02/11/2016.
 */
public class produtoRepository extends applicationDbContext implements IprodutoRepository {

    private static applicationDbContext _applicationDbContex = null;

    public produtoRepository(Context context) {
        super(context);
    }

    @Override
    public void Add(produto produto) {
        ContentValues values = new ContentValues();

        values.put("nome", produto.getNome());
        values.put("descricao", produto.getDescricao());
        values.put("ean", produto.getEan());
        values.put("marca", produto.getMarca());
        values.put("modelo", produto.getModelo());
        values.put("status", produto.getStatus());
        values.put("ncm", produto.getNcm());

        getWritableDatabase().insert("produtos", "nome", values);
    }

    @Override
    public void Remove(produto produto) {

    }

    @Override
    public produto Get(int id) {

        //Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM produtos WHERE produtoId = " + id, null);
        Cursor cursor = getReadableDatabase().query(
                "produto", new String[]{"produtoId", "nome","descricao",
                "ean", "marca", "modelo", "status", "ncm"}, "produtoId=?", new String[]{String.valueOf(id)}, null, null, null);

        produto produto = new produto();

        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();

            produto.setProdutoId(cursor.getInt(0));
            produto.setDescricao(cursor.getString(1));
            produto.setEan(cursor.getString(2));
            produto.setMarca(cursor.getString(3));
            produto.setModelo(cursor.getString(4));
            produto.setStatus(cursor.getString(5));
            produto.setNcm(cursor.getString(5));
        }
        return produto;
    }

    @Override
    public List<produto> All() {
        return null;
    }
}
