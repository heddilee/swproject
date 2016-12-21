package mobilesoftware.swproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class scheduleAddProcess extends Activity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        int date = intent.getIntExtra("scheduleDate",0);
        String description = intent.getStringExtra("scheduleDescription");
        writeCheck(date, description);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void writeCheck(int date, String description) {
        if(date == 0 && description == null){
            alertDialogShow("빈칸을 채워 주세요.");
            Toast.makeText(getApplicationContext(), "빈칸을 채워 주세요.", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
        else if(date == 0) {
            alertDialogShow("날짜를 입력해 주세요.");
            Toast.makeText(getApplicationContext(), "날짜를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
        else if(description == null) {
            alertDialogShow("내용을 입력해 주세요.");
            Toast.makeText(getApplicationContext(), "내용을 입력해 주세요.", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
        else if(!isRightDateForm(date)) {
            alertDialogShow("날짜를 20161223 처럼 입력해 주세요.");
            Toast.makeText(getApplicationContext(), "날짜를 20161223 처럼 입력해 주세요.", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }

    public void alertDialogShow(String text) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Error");
        alert.setMessage(text);
        alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.show();
    }

    public boolean isRightDateForm(int date) {
        int year = date / 10000;
        int month = (date % 10000) / 100;
        int day = (date % 10000) % 100;
        if(year < 1000 || year > 9999)
            return false;
        else if(month < 1 || month > 12)
            return false;
        else if(day < 1 || day > 31)
            return false;
        return true;
    }
}
