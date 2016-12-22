package mobilesoftware.swproject;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.id.edit;

public class noteAdd extends Activity {
    DBHelper helper;
    SQLiteDatabase db;
    EditText noteContent;
    static final int REQUEST_ACT = 1;
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);
        helper = new DBHelper(this);

        noteContent = (EditText) findViewById(R.id.noteContent);

        try {
            db = helper.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }
    }


    public void mainClick(View v) {
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

    public void phoneBookClick(View v) {
        Intent intent = new Intent(noteAdd.this, phoneBookView.class);
        startActivity(intent);
    }

    public void scheduleClick(View v) {
        Intent intent = new Intent(noteAdd.this, scheduleView.class);
        startActivity(intent);
    }

    public void noteClick(View v) {
        Intent intent = new Intent(noteAdd.this, noteView.class);
        startActivity(intent);
    }

    public void noteAddClick(View target) {
        content = noteContent.getText().toString();

        if(!emptyEditTextCheck(content))
            content = null;

        Intent intent = new Intent(this, noteAddProcess.class);
        intent.putExtra("noteContent", content);
        startActivityForResult(intent,REQUEST_ACT);
    }

    public boolean emptyEditTextCheck(String string) {
        if(string.getBytes().length <= 0)
            return false;
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ACT) {
            if (resultCode == RESULT_OK) {
                db.execSQL("INSERT INTO noteTable VALUES (null,'" + content + "');");
                Toast.makeText(getApplicationContext(), "성공적으로 추가되었음", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, noteView.class);
                startActivity(intent);
            }
        }
    }
}
