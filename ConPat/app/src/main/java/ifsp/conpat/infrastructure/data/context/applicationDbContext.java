package ifsp.conpat.infrastructure.data.context;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Carlos Zucherato on 02/11/2016.
 */
public class applicationDbContext extends SQLiteOpenHelper {

    private static final String _databaseName = "database.db";
    private static final int _versionSchema = 1;

    public applicationDbContext(Context context)
    {
        super(context, _databaseName, null, _versionSchema);
        //context.deleteDatabase(_databaseName);
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(
                "CREATE TABLE produtos (produtoId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR, descricao VARCHAR, ean VARCHAR, marca VARCHAR, modelo VARCHAR, " +
                "status VARCHAR, ncm VARCHAR,  serie VARCHAR, valor DOUBLE, foto BLOB, " +
                "dataCadastro DATETIME, dataAquisicao DATETIME);");

        //database.execSQL("DROP TABLE IF EXISTS produtos");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
    {

    }
}
