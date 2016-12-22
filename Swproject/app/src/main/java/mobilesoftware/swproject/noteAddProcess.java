package mobilesoftware.swproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class noteAddProcess extends Activity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        String content = intent.getStringExtra("noteContent");
        writeCheck(content);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void writeCheck(String content) {
        if (isContentNull(content)) {
            Toast.makeText(getApplicationContext(), "내용을 채워 주세요.", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }

    public boolean isContentNull(String content){
        if (content == null)
            return true;
        else
            return false;
    }
}

