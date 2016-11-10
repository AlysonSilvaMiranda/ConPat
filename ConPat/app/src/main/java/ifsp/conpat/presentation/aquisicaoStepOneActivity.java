package ifsp.conpat.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

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

        produto.setNome("Notebook");

        Intent aquisicaoStepTwoActivity = new Intent(this, aquisicaoStepTwoActivity.class);

        aquisicaoStepTwoActivity.putExtra("produto", produto);

        startActivity(aquisicaoStepTwoActivity);
    }

}