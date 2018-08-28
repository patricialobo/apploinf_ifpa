package com.example.patri.apploinf_ifpa.galeria_pontos_principais;


import android.app.Activity;;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.patri.apploinf_ifpa.R;


public class GaleriaDocumentosActivity extends Activity {

    ImageSwitcher is;

    Button anterior, avancar;

    Integer[] images = {R.drawable.planta_documentos, R.drawable.image_documentos};

    int i = 0;

    @Override
    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.locais_principais_imageswitcher);

        is = (ImageSwitcher) findViewById(R.id.image_sw);

        anterior = (Button) findViewById(R.id.anterior);
        avancar = (Button) findViewById(R.id.avancar);

        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setImageResource(R.drawable.planta_documentos);
                imageView.setLayoutParams(
                        new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        is.setInAnimation(in);
        is.setOutAnimation(out);

        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i > 0) {
                    i--;
                    is.setImageResource(images[i]);
                }
            }
        });

        avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i < images.length - 1) {
                    i++;
                    is.setImageResource(images[i]);
                }
            }
        });

    }

}


