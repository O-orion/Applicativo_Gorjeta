package com.jesuscristo.calculargojeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView gorjeta,total,porcentagen;
    private SeekBar seekPorcentagem;
    private TextInputEditText dinheiro;
    private double troco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textViews
        gorjeta = findViewById(R.id.textGorjeta);
        porcentagen = findViewById(R.id.textPorcent);
        total = findViewById(R.id.textTotal);

        //seekBar
        seekPorcentagem = findViewById(R.id.seekPorcent);

        //TextInput
        dinheiro = findViewById(R.id.textValor);

        //adicionando ouvite no seekBar
        seekPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagen.setText(i + "%");
                troco = i;
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){
        String valorEntrada = dinheiro.getText().toString();

        if(valorEntrada == null || valorEntrada.equals("")){

            Toast.makeText(
                    getApplicationContext(),
                    "Prencha o campo valor",
                    Toast.LENGTH_SHORT
            ).show();

        }else{
            double valorDouble = Double.parseDouble(valorEntrada);
            double totalGorjeta = valorDouble * (troco/100);

            gorjeta.setText("R$: " + Math.round(totalGorjeta));
            total.setText("R$: " + Math.round(valorDouble + totalGorjeta));
        }






    }

}