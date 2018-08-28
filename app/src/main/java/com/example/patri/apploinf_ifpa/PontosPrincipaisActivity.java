package com.example.patri.apploinf_ifpa;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//importação da pasta galeria_pontos_principais
import com.example.patri.apploinf_ifpa.galeria_pontos_principais.GaleriaAuditorioActivity;
import com.example.patri.apploinf_ifpa.galeria_pontos_principais.GaleriaBiblioActivity;
import com.example.patri.apploinf_ifpa.galeria_pontos_principais.GaleriaDocumentosActivity;
import com.example.patri.apploinf_ifpa.galeria_pontos_principais.GaleriaRefeitorioActivity;


public class PontosPrincipaisActivity extends Activity {

    Button btn_auditorio, btn_biblioteca, btn_documentos, btn_refeitorio;

    @Override
    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.locais_principais);
        //referencia do id criado de cada botão no xml
        btn_auditorio = (Button) findViewById(R.id.btn_auditorio);
        btn_biblioteca = (Button) findViewById(R.id.btn_biblioteca);
        btn_documentos = (Button) findViewById(R.id.btn_documentos);
        btn_refeitorio = (Button) findViewById(R.id.btn_refeitorio);


        // Ação de cada botão para chamar outra  tela
        btn_auditorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PontosPrincipaisActivity.this, GaleriaAuditorioActivity.class);
                startActivity(it);
            }
        });

        btn_biblioteca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PontosPrincipaisActivity.this, GaleriaBiblioActivity.class);
                startActivity(it);
            }
        });

        btn_documentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PontosPrincipaisActivity.this, GaleriaDocumentosActivity.class);
                startActivity(it);
            }
        });

        btn_refeitorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PontosPrincipaisActivity.this, GaleriaRefeitorioActivity.class);
                startActivity(it);

            }
        });
    }
}

