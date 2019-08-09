package com.example.buscando_api.service;

import android.os.AsyncTask;
import android.util.Xml;

import com.example.buscando_api.model.CEP;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPService extends AsyncTask<Void, Void, CEP> {

    private final String cep;

    public HTTPService(String cep) {
        this.cep = cep;
    }

    @Override
    protected CEP doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        try {
            //http://ws.matheuscastiglioni.com.br/ws/cep/find/" + this.cep + "/json/
            //https://viacep.com.br/ws/" + this.cep + "/json/
            URL url = new URL("https://viacep.com.br/ws/" + this.cep + "/json/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
           // connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                resposta.append(scanner.next() + " ");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(resposta.toString(), CEP.class);
    }
}
