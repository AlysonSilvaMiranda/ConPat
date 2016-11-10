package ifsp.conpat.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ifsp.conpat.R;
import ifsp.conpat.domain.entities.produto;

public class aquisicaoStepTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquisicao_step_two);

        Button button = (Button) findViewById(R.id.buttonSalvar);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                finalizeActivityAquisicaoStepTwo(v);
            }
        });

        Intent aquisicaoStepTwoActivity = getIntent();
        produto produto = (produto) aquisicaoStepTwoActivity.getSerializableExtra("produto");

        Toast toast = Toast.makeText(this, produto.getNome(),Toast.LENGTH_SHORT);
        toast.show();
    }

    public void finalizeActivityAquisicaoStepTwo(View v)
    {

        Intent finalizeAquisicaoStepTwoActivity = new Intent(this, cameraActivity.class);

        startActivity(finalizeAquisicaoStepTwoActivity);
    }
}
