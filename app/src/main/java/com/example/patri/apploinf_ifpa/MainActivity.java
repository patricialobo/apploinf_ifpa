package com.example.patri.apploinf_ifpa;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painel_controle);
    }

    public void selecionarOpcao(View view){
        switch (view.getId()){
            case R.id.pontos_principais:
                startActivity(new Intent(this, PontosPrincipaisActivity.class));
                break;
            case R.id.ler_qrcode:
                startActivity(new Intent(this, LerQrcodeActivity.class));
                break;
            case R.id.mapa:
                startActivity(new Intent(this, MapsActivity.class));
                break;
            case R.id.noticias:
                startActivity(new Intent(this, NoticiasActivity.class));
                break;
        }

    }


}

