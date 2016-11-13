package ifsp.conpat.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import ifsp.conpat.R;
import ifsp.conpat.domain.entities.produto;

public class aquisicaoStepOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquisicao_step_one);

        Button button = (Button) findViewById(R.id.buttonAvancar);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivityAquisicaoStepTwo(v);
            }
        });
    }

    public void startActivityAquisicaoStepTwo(View v)
    {
        produto produto = new produto();

        TextView txtNome = (TextView) findViewById(R.id.txt_nome);
        String nome = txtNome.getText().toString();
        produto.setNome(nome);

        TextView txtDescricao = (TextView) findViewById(R.id.txt_descricao);
        String descricao = txtDescricao.getText().toString();
        produto.setDescricao(descricao);

        TextView txtMarca = (TextView) findViewById(R.id.txt_marca);
        String marca = txtMarca.getText().toString();
        produto.setMarca(marca);

        TextView txtModelo = (TextView) findViewById(R.id.txt_modelo);
        String modelo = txtModelo.getText().toString();
        produto.setModelo(modelo);

        TextView txtSerie = (TextView) findViewById(R.id.txt_serie);
        String serie = txtSerie.getText().toString();
        produto.setSerie(serie);

        Intent aquisicaoStepTwoActivity = new Intent(this, aquisicaoStepTwoActivity.class);

        aquisicaoStepTwoActivity.putExtra("produto", produto);

        startActivity(aquisicaoStepTwoActivity);
    }

}