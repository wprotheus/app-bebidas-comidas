package com.wprotheus.mobile1drinknfood.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.wprotheus.mobile1drinknfood.R;
import com.wprotheus.mobile1drinknfood.model.Bebida;
import com.wprotheus.mobile1drinknfood.model.Comida;
import com.wprotheus.mobile1drinknfood.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText tilNome, tilIdade;
    private RadioGroup rgSexo;
    private RadioButton rbSelecionado;
    private CheckBox boxB1, boxB2, boxB3, boxB4, boxB5;
    private CheckBox boxC1, boxC2, boxC3, boxC4, boxC5;
    private Pessoa pessoa = new Pessoa();
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tilNome = (TextInputEditText) findViewById(R.id.nome);
        tilIdade = (TextInputEditText) findViewById(R.id.idade);
        rgSexo = (RadioGroup) findViewById(R.id.rgSexo);
        boxB1 = (CheckBox) findViewById(R.id.ckbAgua);
        boxB2 = (CheckBox) findViewById(R.id.ckbCafe);
        boxB3 = (CheckBox) findViewById(R.id.ckbCerveja);
        boxB4 = (CheckBox) findViewById(R.id.ckbRefrigerante);
        boxB5 = (CheckBox) findViewById(R.id.ckbTerere);
        boxC1 = (CheckBox) findViewById(R.id.ckbAcai);
        boxC2 = (CheckBox) findViewById(R.id.ckbChurrasco);
        boxC3 = (CheckBox) findViewById(R.id.ckbHamburguer);
        boxC4 = (CheckBox) findViewById(R.id.ckbMassa);
        boxC5 = (CheckBox) findViewById(R.id.ckbPizza);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PreferenciaActivity.class);

                if (!tilNome.getText().toString().isEmpty() && !tilIdade.getText().toString().isEmpty() && rbSelecionado != null) {
                    pessoa.setNome(tilNome.getText().toString());
                    pessoa.setIdade(tilIdade.getText().toString());
                    pessoa.setSexo(rbSelecionado.getText().toString());
                    intent.putExtra("pessoa", pessoa);
                    startActivity(intent);
                } else if (tilNome.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "O nome não pode ficar em branco, favor preenchê-lo.", Toast.LENGTH_LONG).show();
                else if (tilIdade.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "A idade não pode ficar em branco, favor preenchâ-la.", Toast.LENGTH_LONG).show();
                else if (rgSexo.getCheckedRadioButtonId() == -1)
                    Toast.makeText(MainActivity.this, "O sexo não pode ficar em branco, favor marcar uma opção.", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        int idRBSelecionado = rgSexo.getCheckedRadioButtonId();
        if (idRBSelecionado > 0)
            rbSelecionado = findViewById(idRBSelecionado);
        else
            rbSelecionado = null;
    }

    public void ckbOnClick(View view) {
        if (boxB1.isChecked() && !pessoa.bebidaIgual(new Bebida(boxB1.getText().toString())))
            pessoa.getBebidas().add(new Bebida(boxB1.getText().toString()));
        if (boxB2.isChecked() && !pessoa.bebidaIgual(new Bebida(boxB2.getText().toString())))
            pessoa.getBebidas().add(new Bebida(boxB2.getText().toString()));
        if (boxB3.isChecked() && !pessoa.bebidaIgual(new Bebida(boxB3.getText().toString())))
            pessoa.getBebidas().add(new Bebida(boxB3.getText().toString()));
        if (boxB4.isChecked() && !pessoa.bebidaIgual(new Bebida(boxB4.getText().toString())))
            pessoa.getBebidas().add(new Bebida(boxB4.getText().toString()));
        if (boxB5.isChecked() && !pessoa.bebidaIgual(new Bebida(boxB5.getText().toString())))
            pessoa.getBebidas().add(new Bebida(boxB5.getText().toString()));

        if (boxC1.isChecked() && !pessoa.comidaIgual(new Comida(boxC1.getText().toString())))
            pessoa.getComidas().add(new Comida(boxC1.getText().toString()));
        if (boxC2.isChecked() && !pessoa.comidaIgual(new Comida(boxC2.getText().toString())))
            pessoa.getComidas().add(new Comida(boxC2.getText().toString()));
        if (boxC3.isChecked() && !pessoa.comidaIgual(new Comida(boxC3.getText().toString())))
            pessoa.getComidas().add(new Comida(boxC3.getText().toString()));
        if (boxC4.isChecked() && !pessoa.comidaIgual(new Comida(boxC4.getText().toString())))
            pessoa.getComidas().add(new Comida(boxC4.getText().toString()));
        if (boxC5.isChecked() && !pessoa.comidaIgual(new Comida(boxC5.getText().toString())))
            pessoa.getComidas().add(new Comida(boxC5.getText().toString()));
    }
}