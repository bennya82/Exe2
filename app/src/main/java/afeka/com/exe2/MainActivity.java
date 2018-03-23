package afeka.com.exe2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import afeka.com.exe2.common.Person;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncTask<Person,Integer,Person> task = new AsyncTask<Person, Integer, Person>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected Person doInBackground(Person... voids) {

                //1
                publishProgress(1);
                //2
                publishProgress(2);
                //3
                publishProgress(3);

                return null;
            }

            @Override
            protected void onPostExecute(Person aVoid) {
                super.onPostExecute(aVoid);
            }
        };
    }
}
