package com.sergioviera.proyectofumar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private TextView descripcionTV, descripcionTV2;
    private Toolbar toolbar;
    private ImageView imagenIV;
    private Button accionBTN;

    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        descripcionTV = (TextView) findViewById(R.id.descripcionTV);
        descripcionTV2 = (TextView) findViewById(R.id.descripcionTV2);
        accionBTN = (Button) findViewById(R.id.accionBTN);
        imagenIV = (ImageView) findViewById(R.id.imagenIV);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nicotinaitem) {
            descripcionTV.setText(R.string.nicotina_description);
            descripcionTV2.setText(R.string.nicotina_description2);
            setTitle("Nicotina");
            url = "https://i.blogs.es/25dcbc/tabaco/400_300.jpg";
            accionBTN.setText("Objetivo 1");
            LoadImage();

            accionBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }

        if (id == R.id.menuitem) {
            setTitle("Bienvenido");
            descripcionTV.setText(R.string.menu_description);
            descripcionTV2.setText("");
            url = "http://enlinea.santotomas.cl/wp-content/uploads/sites/2/2016/05/dia-no-fumar-744x465.jpg";
            accionBTN.setText("Deseo de fumar");
            LoadImage();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        setTitle("Bienvenido");
        descripcionTV.setText(R.string.menu_description);
        descripcionTV2.setText("");
        url = "http://enlinea.santotomas.cl/wp-content/uploads/sites/2/2016/05/dia-no-fumar-744x465.jpg";
        accionBTN.setText("Deseo de fumar");
        LoadImage();

    }


    private void LoadImage() {
        Glide.with(this)
                .load(url)
                .crossFade()
                .into(imagenIV);
    }
}
