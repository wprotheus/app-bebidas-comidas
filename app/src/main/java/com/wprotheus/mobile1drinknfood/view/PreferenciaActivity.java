package com.wprotheus.mobile1drinknfood.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.wprotheus.mobile1drinknfood.R;
import com.wprotheus.mobile1drinknfood.model.Pessoa;

public class PreferenciaActivity extends AppCompatActivity
{
    private Pessoa pessoa =new Pessoa();
    private TextView tvNome, tvIdade, tvSexo, tvBebidas, tvComidas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencia);
        tvNome = (TextView) findViewById(R.id.tvNome);
        tvIdade = (TextView) findViewById(R.id.tvIdade);
        tvSexo = (TextView) findViewById(R.id.tvSexo);
        tvBebidas = (TextView) findViewById(R.id.tvBebidas);
        tvComidas = (TextView) findViewById(R.id.tvComidas);

        pessoa = (Pessoa) getIntent().getSerializableExtra("pessoa");

        tvNome.setText(pessoa.getNome());
        tvIdade.setText(pessoa.getIdade());
        tvSexo.setText(pessoa.getSexo());
        if(!pessoa.getBebidas().isEmpty()) tvBebidas.setText(pessoa.getBebidas().toString());
        else tvBebidas.setText("Você não escolheu nenhuma bebida!");
        if(!pessoa.getComidas().isEmpty()) tvComidas.setText(pessoa.getComidas().toString());
        else tvComidas.setText("Você não escolheu nenhuma comida!");
    }

    public void voltar(View view)
    {
        finish();
        Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
        startActivity(intent);
    }
}