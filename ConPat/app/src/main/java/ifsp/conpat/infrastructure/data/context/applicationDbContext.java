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
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL("CREATE TABLE produtos (produtoId INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "nome TEXT, descricao TEXT, ean TEXT, marca TEXT, modelo TEXT, status TEXT, ncm TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
    {

    }
}
