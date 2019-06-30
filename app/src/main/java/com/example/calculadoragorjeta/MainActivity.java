package com.example.calculadoragorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editValor;
    private TextView textPorcentagem, textGorjeta, textTotal;
    private SeekBar seekGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.etValor);
        textPorcentagem = findViewById(R.id.tvPorcentagem);
        textGorjeta = findViewById(R.id.tvGorjeta);
        textTotal = findViewById(R.id.tvTotal);
        seekGorjeta = findViewById(R.id.seekBar);

        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = seekBar.getProgress();
                textPorcentagem.setText(Math.round(porcentagem) + "%");
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
        double valorDigitado = Double.parseDouble(editValor.getText().toString());

        double gorjeta = (valorDigitado * porcentagem)/100;
        double total = gorjeta + valorDigitado;

        textGorjeta.setText("R$ " + Math.round(gorjeta));
        textTotal.setText("R$ " +total);
    }
}
