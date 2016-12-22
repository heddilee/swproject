package mobilesoftware.swproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class phoneBookAddProcess extends Activity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        int number = intent.getIntExtra("phoneNumber",0);
        String name = intent.getStringExtra("phoneName");
        writeCheck(number, name);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void writeCheck(int number, String name) {
        if(number == 0 && name == null){
            Toast.makeText(getApplicationContext(), "빈칸을 채워주세요.", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
        else if(number == 0) {
            Toast.makeText(getApplicationContext(), "번호를 작성해주세요.", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
        else if(name == null) {
            Toast.makeText(getApplicationContext(), "이름을 작성해주세요.", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }
}
