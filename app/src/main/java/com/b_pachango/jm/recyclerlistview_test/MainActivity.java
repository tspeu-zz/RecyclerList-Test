package com.b_pachango.jm.recyclerlistview_test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.b_pachango.jm.recyclerlistview_test.ui.RecyclerList;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ProgressBar spinner;

    private ProgressBar pbarProgreso;
    private ProgressDialog pDialog;

    private MiTareaAsincrona tarea1;
    private MiTareaAsincronaDialog tarea2;

    //private static final int PROGRESS = 0x1;

    //private int mProgressStatus = 0;
    //private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn = (Button) findViewById(R.id.btnToRecList);
        spinner = (ProgressBar)findViewById(R.id.progressBar);
       spinner.setVisibility(View.GONE);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //LoadingActivity
              /*  spinner.setVisibility(View.VISIBLE);

                Handler handler = new Handler();
                //runnablable ong y toempo
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //startActivity(new Intent(MainActivity.this, LoadingActivity.class));
                        //para acabar la activity y evitar el back button
                        //finish();
                        ProgressDialog pd = new ProgressDialog(MainActivity.this);
                        pd.setTitle("BlueTooth Connection");
                        pd.setMessage("Autonected ....");
                        pd.setCancelable(false);
                        pd.show();
                    }
                }, 4000);




*/
                pDialog = new ProgressDialog(MainActivity.this);
                pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pDialog.setTitle("Autonected...");
                pDialog.setMessage("Loading Bluetooth...");
                pDialog.setCancelable(true);
                pDialog.setMax(100);
                tarea2 = new MiTareaAsincronaDialog();
                tarea2.execute();
          /*      pbarProgreso=(ProgressBar)findViewById(R.id.progressBar);
                tarea1 = new MiTareaAsincrona();
                tarea1.execute();
*/


               // spinner.setVisibility(View.GONE);

            }
        });

    }
/*El tipo de datos que recibiremos como entrada de la tarea en el método doInBackground().
El tipo de datos con el que actualizaremos el progreso de la tarea, y que recibiremos como
parámetro del método onProgressUpdate() y que a su vez tendremos que incluir como parámetro del
método publishProgress().
El tipo de datos que devolveremos como resultado de nuestra tarea, que será el tipo de
retorno del método doInBackground() y el tipo del parámetro recibido en el método onPostExecute().*/





    private class MiTareaAsincrona extends AsyncTask<Void, Integer, Boolean> {

        private void tareaLarga()
        {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
        }

    @Override
    protected Boolean doInBackground(Void... params) {

        for(int i=1; i<=10; i++) {
            tareaLarga();

            publishProgress(i*10);

            if(isCancelled())
                break;
        }

        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progreso = values[0].intValue();

        pbarProgreso.setProgress(progreso);
    }

    @Override
    protected void onPreExecute() {
        pbarProgreso.setMax(100);
        pbarProgreso.setProgress(0);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if(result)
            Toast.makeText(MainActivity.this, "Tarea finalizada!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this , RecyclerList.class);
        startActivity(intent);
    }

    @Override
    protected void onCancelled() {
        Toast.makeText(MainActivity.this, "Tarea cancelada!",
                Toast.LENGTH_SHORT).show();
    }
}


    private class MiTareaAsincronaDialog extends AsyncTask<Void, Integer, Boolean> {

        private void tareaLarga()
        {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            for(int i=1; i<=10; i++) {
                tareaLarga();

                publishProgress(i*10);

                if(isCancelled())
                    break;
            }

            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int progreso = values[0].intValue();

            pDialog.setProgress(progreso);
        }

        @Override
        protected void onPreExecute() {

        /*    pDialog.setOnCancelListener(new OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    MiTareaAsincronaDialog.this.cancel(true);
                }
            });
*/
            pDialog.setProgress(0);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(result)
            {
                pDialog.dismiss();
                //Toast.makeText(MainActivity.this, "Tarea finalizada!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this , RecyclerList.class);
                startActivity(intent);
            }
        }

        @Override
        protected void onCancelled() {
            Toast.makeText(MainActivity.this, "Tarea cancelada!", Toast.LENGTH_SHORT).show();
        }
    }

}
