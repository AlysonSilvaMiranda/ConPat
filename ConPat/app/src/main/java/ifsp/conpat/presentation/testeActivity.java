package ifsp.conpat.presentation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

import ifsp.conpat.R;
import ifsp.conpat.domain.entities.produto;
import ifsp.conpat.infrastructure.data.repository.produtoRepository;

public class testeActivity extends AppCompatActivity {

    private ImageView imageView;
    private static final int CAMERA_REQUEST = 1888;
    produto produto;
    produtoRepository produtoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);
        this.imageView = (ImageView) this.findViewById(R.id.imagePreview);

        produtoRepository = new produtoRepository(this);

        Intent aquisicaoStepTwoActivity = getIntent();
        produto = (produto) aquisicaoStepTwoActivity.getSerializableExtra("produto");

        Button buttonTakePicture = (Button) findViewById(R.id.buttonCamera);
        buttonTakePicture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        Button buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){

                produtoRepository.Add(produto);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            produto.setFoto(getBitmapAsByteArray(photo));
        }
    }

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }
}
