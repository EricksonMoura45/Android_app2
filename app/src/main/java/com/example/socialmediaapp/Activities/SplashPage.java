package com.example.socialmediaapp.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.socialmediaapp.Adapters.RetroFitAPI;
import com.example.socialmediaapp.R;

public class SplashPage extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_page);

        progressBar = findViewById(R.id.progressBar);
        RetroFitAPI retroFitAPI = new RetroFitAPI();

    }

    public void startAsyncTask(View view){

        MyAsyncTask task = new MyAsyncTask();
        task.execute(10);
        Intent intent = new Intent(this, MainActivity.class);
    }

    class MyAsyncTask extends AsyncTask<Integer, Integer,String> {

        @Override
        protected String doInBackground(Integer... integers) {

            int num = integers[0];
            for(int i = 0; i <= num; i++){
                publishProgress(i);
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return "Bem Vindo!";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(SplashPage.this,s, Toast.LENGTH_SHORT).show();
            progressBar.setProgress(0);
            progressBar.setVisibility(View.INVISIBLE);

            //startActivity(intent);
            //TODO: homepage -> splashpage
        }
    }


}
