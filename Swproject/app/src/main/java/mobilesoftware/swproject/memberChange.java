package mobilesoftware.swproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2016-12-21.
 */
public class memberChange extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;
    EditText idview,passview;
    Cursor cursor;
    String DBid;
    String DBpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }

        idview=(EditText)findViewById(R.id.newId);
        passview=(EditText)findViewById(R.id.newPass);

        cursor = db.rawQuery("SELECT userid,userpass FROM contactsTable where num='1';", null);
        if (cursor != null)
            cursor.moveToFirst();
        DBid = cursor.getString(cursor.getColumnIndex("userid"));

        DBpass=cursor.getString(cursor.getColumnIndex("userpass"));




        idview.setText(DBid);
        passview.setText(DBpass);


    }

    public void modify(View v){

        idview=(EditText)findViewById(R.id.newId);
        passview=(EditText)findViewById(R.id.newPass);
        String nId=idview.getText().toString();
        String npass=passview.getText().toString();

        if (cursor != null)
            cursor.moveToFirst();

        cursor = db.rawQuery("UPDATE contactsTable SET userid='"+nId+"', userpass='"+npass+"' where num='1';", null);
       db.execSQL("UPDATE contactsTable SET userid='"+nId+"', userpass='"+npass+"' where num='1';");
        //db.close();
        /*ContentValues args = new ContentValues();
        args.put("userid", nId);
        args.put("userpass", npass);*/




        Intent intent = new Intent(this, Main.class);
        startActivity(intent);


    }



}
