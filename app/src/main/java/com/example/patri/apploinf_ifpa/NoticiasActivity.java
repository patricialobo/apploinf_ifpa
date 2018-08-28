package com.example.patri.apploinf_ifpa;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class NoticiasActivity extends AppCompatActivity {
    private RecyclerView mNoticiasList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticias);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Notícias");
        mDatabase.keepSynced(true);

        mNoticiasList = (RecyclerView) findViewById(R.id.myrecyclerview);
        mNoticiasList.setHasFixedSize(true);
        mNoticiasList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Noticias2Activity, NoticiasViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Noticias2Activity, NoticiasViewHolder>
                (Noticias2Activity.class, R.layout.noticias_row, NoticiasViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(NoticiasViewHolder viewHolder, final Noticias2Activity model, int position) {
                viewHolder.setTitulo(model.getTitulo());
                viewHolder.setDescricao(model.getDescricao());
                viewHolder.setUrl(model.getUrl());
                viewHolder.setImagem(getApplicationContext(), model.getImagem());

                //teste url
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String url = model.getUrl();
                        Intent intent = new Intent(getApplicationContext(), NoticiasWebUrl.class);
                        intent.putExtra("id", url);
                        startActivity(intent);


                    }
                });
            }

            @Override
            public NoticiasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.noticias_row, parent, false);

                return new NoticiasViewHolder(view);

                // ate aqui
            }
        };

        mNoticiasList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class NoticiasViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public NoticiasViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setTitulo(String titulo) {
            TextView post_titulo = (TextView) mView.findViewById(R.id.post_titulo);
            post_titulo.setText(titulo);
        }

        public void setDescricao(String descricao) {
            TextView post_descricao = (TextView) mView.findViewById(R.id.post_descricao);
            post_descricao.setText(descricao);
        }

        public void setUrl(String url) {
            TextView post_url = (TextView) mView.findViewById(R.id.post_url);
            post_url.setText(url);
        }

        public void setImagem(Context ctx, String image) {
            ImageView post_imagem = (ImageView) mView.findViewById(R.id.post_imagem);
            Picasso.with(ctx).load(image).into(post_imagem);
        }
    }
}

