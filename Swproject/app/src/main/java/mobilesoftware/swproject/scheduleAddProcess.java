package mobilesoftware.swproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class scheduleAddProcess extends Activity {
    int date;
    String description;
    AlertDialog.Builder alert;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        date = Integer.parseInt(intent.getStringExtra("scheduleDate"));
        description = intent.getStringExtra("scheduleDescription");
        alert = new AlertDialog.Builder(this);
        writeCheck();
        setResult(RESULT_OK, intent);
        finish();
    }

    public void writeCheck() {
        int year = date / 10000;
        int month = (date % 10000) / 100;
        int day = (date % 10000) % 100;
        if(date == 0 && description == null) {
            alertDialogShow("빈칸을 채워주세요.");
            setResult(RESULT_CANCELED, intent);
            finish();
        }
        else if(date == 0) {
            alertDialogShow("날짜를 입력해 주세요.");
            setResult(RESULT_CANCELED, intent);
            finish();
        }
        else if(description == null) {
            alertDialogShow("내용을 입력해 주세요.");
            setResult(RESULT_CANCELED, intent);
            finish();
        }
        else if(year < 1000 || year > 9999)
            ;
        else if(month < 1 || month > 12)
            ;
        else if(day < 1 || day > 31)
            ;
    }

    public void alertDialogShow(String text) {
        alert.setTitle("Error");
        alert.setMessage(text);
        alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.show();
    }
}
