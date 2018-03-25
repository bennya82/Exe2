package afeka.com.exe2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle data = getIntent().getExtras();
        String num1Str =data.getString(Main2Activity.NUM1);
        String num2Str = data.getString(Main2Activity.NUM2);

        String result = String.format("%s :) %s",num1Str,num2Str);
        Intent resIntent = new Intent();
        resIntent.putExtra(Main2Activity.RESULT,result);
        setResult(RESULT_OK,resIntent);
        finish();
    }
}
