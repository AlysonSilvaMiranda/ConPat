package ifsp.conpat.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import ifsp.conpat.R;
import ifsp.conpat.domain.entities.produto;
import ifsp.conpat.infrastructure.data.repository.produtoRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        produtoRepository pr = new produtoRepository(this);
        List<produto> p = new ArrayList<produto>();

        p = pr.All();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButtonAquisicao);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivityAquisicaoStepOne(v);
            }
        });
    }

    public void startActivityAquisicaoStepOne(View v)
    {
        Intent aquisicaoStepOneActivity = new Intent(this, aquisicaoStepOneActivity.class);
        startActivity(aquisicaoStepOneActivity);
    }
}
