package afeka.com.exe2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import afeka.com.exe2.common.Person;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main_imageview_example);

        ImageView img = (ImageView)findViewById(R.id.act_main_imgView);
        String url = getString(R.string.image_url);
        //AsyncImageView asyncImageView = new AsyncImageView(img,url);
        AsyncImageView asyncImageView = new AsyncImageView(img);
        asyncImageView.loadUrl(url);

        Button btn = (Button)findViewById(R.id.btn_act_main_continue);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity2();
            }
        });



        //Simple AsyncTask Example;
//        AsyncTask<Person,Integer,Person> task = new AsyncTask<Person, Integer, Person>() {
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//            }
//
//            @Override
//            protected void onProgressUpdate(Integer... values) {
//                super.onProgressUpdate(values);
//            }
//
//            @Override
//            protected Person doInBackground(Person... voids) {
//
//                //1
//                publishProgress(1);
//                //2
//                publishProgress(2);
//                //3
//                publishProgress(3);
//
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Person aVoid) {
//                super.onPostExecute(aVoid);
//            }
//        };
    }

    private void goToActivity2(){
        Intent intent = new Intent(this,Main2Activity.class);
        //Example:
        //intent.putExtra("Key","Value");
        intent.putExtra(Main2Activity.NUM1,1);
        intent.putExtra(Main2Activity.NUM2,2);
        intent.putExtra(Main2Activity.NUM3,3);
        startActivity(intent);


    }
}
