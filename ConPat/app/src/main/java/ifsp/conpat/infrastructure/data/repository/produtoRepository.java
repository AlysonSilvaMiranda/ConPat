package ifsp.conpat.infrastructure.data.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import ifsp.conpat.domain.entities.produto;
import ifsp.conpat.domain.interfaces.IprodutoRepository;
import ifsp.conpat.infrastructure.data.context.applicationDbContext;

/**
 * Created by Carlos Zucherato on 02/11/2016.
 */
public class produtoRepository extends applicationDbContext implements IprodutoRepository {

    private static applicationDbContext _applicationDbContex = null;
    public Context context;

    public produtoRepository(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public boolean Add(produto produto) {

        ContentValues values = serializeContentValues(produto);

        return getWritableDatabase().insert("produtos", "nome", values) > 0 ? true : false;
    }

    @Override
    public boolean Update(produto produto) {

        ContentValues values = serializeContentValues(produto);

        return getWritableDatabase().update("produtos", values, "produtoId=?",
                new String[] { String.valueOf(produto.getProdutoId()) }) > 0 ? true : false;
    }

    @Override
    public boolean Remove(produto produto) {
        return getWritableDatabase().delete("produtos", "produtoId=?",
                new String[]{String.valueOf(produto.getProdutoId())}) > 0 ? true : false;
    }

    @Override
    public produto Get(int id) {

        //Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM produtos WHERE produtoId = " + id, null);
        Cursor cursor = getReadableDatabase().query(
                "produtos", new String[]{"produtoId", "nome","descricao",
                "ean", "marca", "modelo", "status", "ncm", "serie", "valor", "foto", "dataAquisicao",
                "dataCadastro", "taxaDepreciacao"}, "produtoId=?", new String[]{String.valueOf(id)}, null, null, null);

        produto produto = new produto();

        if(cursor != null && cursor.moveToFirst())
            produto = serializeByCursor(cursor, produto);

        if(!cursor.isClosed())
            cursor.close();

        return produto;
    }

    @Override
    public List<produto> All() {

        produto produto = new produto();
        List<produto> produtos = new ArrayList<produto>();

        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM produtos", null);

        if(cursor != null && cursor.moveToNext())
        {
            do
            {
                produtos.add(serializeByCursor(cursor, produto));
            }
            while(cursor.moveToNext());

            if(!cursor.isClosed())
                cursor.close();
        }

        return produtos;
    }

    @Override
    public ContentValues serializeContentValues(produto produto) {

        ContentValues values = new ContentValues();

        values.put("nome", produto.getNome());
        values.put("descricao", produto.getDescricao());
        values.put("ean", produto.getEan());
        values.put("marca", produto.getMarca());
        values.put("modelo", produto.getModelo());
        values.put("status", produto.getStatus());
        values.put("ncm", produto.getNcm());
        values.put("serie", produto.getSerie());
        values.put("valor", produto.getValor());
        values.put("foto", String.valueOf(produto.getFoto()));
        values.put("dataCadastro", String.valueOf(produto.getDataCadastro()));
        values.put("dataAquisicao", String.valueOf(produto.getDataAquisicao()));
        values.put("taxaDepreciacao", String.valueOf(produto.getTaxaDepreciacao()));

        return values;
    }

    @Override
    public produto serializeByCursor(Cursor cursor, produto produto) {

        produto.setProdutoId(cursor.getInt(0));
        produto.setNome(cursor.getString(1));
        produto.setDescricao(cursor.getString(2));
        produto.setEan(cursor.getString(3));
        produto.setMarca(cursor.getString(4));
        produto.setModelo(cursor.getString(5));
        produto.setStatus(cursor.getString(6));
        produto.setNcm(cursor.getString(7));
        produto.setSerie(cursor.getString(8));
        produto.setValor(cursor.getDouble(9));
        produto.setFoto(cursor.getBlob(10), context);
        produto.setDataCadastro(cursor.getString(11));
        produto.setDataAquisicao(cursor.getString(12));
        produto.setTaxaDepreciacao(cursor.getDouble(13));

        return produto;
    }
}
