package com.example.buscando_api;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.buscando_api.Activity.abas;
import com.example.buscando_api.model.CEP;
import com.example.buscando_api.service.HTTPService;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    public void abas (View v){
        Intent md = new Intent(this, abas.class);
        startActivity(md);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText eCep = findViewById(R.id.etCep2);
        final TextView end = findViewById(R.id.txtEnd);

        Button buscar = findViewById(R.id.btnBuscar);

        Button aba = findViewById(R.id.button);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eCep.getText().toString().length() > 0 && !eCep.getText().toString().equals("") && eCep.getText().toString().length() == 8){
                   HTTPService service = new HTTPService(eCep.getText().toString());
                    try {
                        CEP retorno = service.execute().get();

                        //teste = retorno.toString();
                        if (retorno.toString() != "" || retorno.toString() != null) {
                            end.setText(retorno.toString());
                        }else end.setText("Não foi possível acessar o servidor");
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }

}
