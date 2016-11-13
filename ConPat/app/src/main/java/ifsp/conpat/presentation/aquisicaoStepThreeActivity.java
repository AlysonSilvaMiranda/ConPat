package ifsp.conpat.presentation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import ifsp.conpat.R;
import ifsp.conpat.domain.entities.produto;

public class aquisicaoStepThreeActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView imageView;
    private static final int CAMERA_REQUEST = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquisicao_step_three);
        this.imageView = (ImageView) this.findViewById(R.id.imagePreview);

        Button button = (Button) findViewById(R.id.buttonSalvar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizeActivityAquisicaoStepThree(v);
            }
        });

        Button buttonTakePicture = (Button) findViewById(R.id.buttonCamera);
        buttonTakePicture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        Intent aquisicaoStepTwoActivity = getIntent();
        produto produto = (produto) aquisicaoStepTwoActivity.getSerializableExtra("produto");

        Toast toast = Toast.makeText(this, produto.getNome(), Toast.LENGTH_SHORT);
        toast.show();
    }

    public void finalizeActivityAquisicaoStepThree(View v) {
        //
        //    Intent finalizeAquisicaoStepTwoActivity = new Intent(this, cameraActivity.class);

        //    startActivity(finalizeAquisicaoStepTwoActivity);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
}
