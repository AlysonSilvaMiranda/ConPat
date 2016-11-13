package ifsp.conpat.presentation;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import ifsp.conpat.R;
import ifsp.conpat.domain.entities.produto;

public class aquisicaoStepTwoActivity extends Activity {

    private DatePicker datePicker;
    private Calendar calendar;
    TextView dateView;
    private int year, month, day;
    produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquisicao_step_two);

        Intent aquisicaoStepTwoActivity = getIntent();
        produto = (produto) aquisicaoStepTwoActivity.getSerializableExtra("produto");

        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        Button button = (Button) findViewById(R.id.buttonAvancar);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                startActivityAquisicaoStepThree(v);
            }
        });
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public void startActivityAquisicaoStepThree(View v)
    {
        String dataAquisicao = new StringBuilder().append(year).append("-")
                .append(month).append("-").append(day).toString();
        produto.setDataAquisicao(dataAquisicao);

        TextView txtValor = (TextView) findViewById(R.id.txt_valor);

        if(!txtValor.getText().toString().equals(""))
        {
            String valor = txtValor.getText().toString();
            produto.setValor(Double.parseDouble(valor));
        }

        TextView txtTaxaDepreciacao = (TextView) findViewById(R.id.txt_taxa_depreciacao);

        if(!txtTaxaDepreciacao.getText().toString().equals(""))
        {

        }

        Double taxaDepreciacao = Double.parseDouble(txtTaxaDepreciacao.getText().toString());
        produto.setTaxaDepreciacao(taxaDepreciacao);

        Intent aquisicaoStepThreeActivity = new Intent(this, testeActivity.class);

        aquisicaoStepThreeActivity.putExtra("produto", produto);

        startActivity(aquisicaoStepThreeActivity);
    }
}


