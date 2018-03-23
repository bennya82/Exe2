package afeka.com.exe2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;
    TextView textViewResult;
    Boolean isFlipped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindUI();


    }

    private void bindUI(){
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        Button btn = (Button) findViewById(R.id.act2_btn_click);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.act2_btn_click:
                if (editText1.getText().length() == 0 || editText2.getText().length() == 0)
                {
                    editText1.setError("Please Enter Number");
                    return;
                }

                String num1 = editText1.getText().toString();
                String num2 = editText2.getText().toString();
                Intent intent = new Intent(this,Main3Activity.class);
                intent.putExtra("NUM1",num1);
                intent.putExtra("NUM2",num2);
                startActivityForResult(intent,1);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            String result = data.getStringExtra("RESULT");
            Toast.makeText(this,result.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
