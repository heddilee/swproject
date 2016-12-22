package mobilesoftware.swproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class beforeLogin extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    private EditText userid,password;
    String id;
    String pass;
    Cursor cursor;
    String DBid;
    String DBpass;
    int temp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.before_login);
        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }

        userid=(EditText)findViewById(R.id.id);
        password=(EditText)findViewById(R.id.pass);


        cursor = db.rawQuery("SELECT userid,userpass FROM contactsTable where num='1';", null);
        if (cursor != null)
            cursor.moveToFirst();
        DBid = cursor.getString(cursor.getColumnIndex("userid"));

        DBpass=cursor.getString(cursor.getColumnIndex("userpass"));


    }

    public void onClick(View view) {

       // Toast.makeText(getApplicationContext(), DBid+"님 환영합니다", Toast.LENGTH_SHORT).show();


        id = userid.getText().toString();
        pass = password.getText().toString();


        //Toast.makeText(beforeLogin.this,DBid,Toast.LENGTH_LONG).show();

        if (DBid.equals(id) && DBpass.equals(pass)) {
            Toast.makeText(beforeLogin.this,"로그인에 성공하였습니다",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(beforeLogin.this,"로그인실패",Toast.LENGTH_LONG).show();
        }
    }

       // if(id.equals("hello")) {
         //   if(pass.equals("123")){
           // Toast.makeText(beforeLogin.this,"로그인에 성공하였습니다",Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(this, Main.class);

            //intent.putExtra("id", id);
           /* startActivity(intent);
            //intent.putExtra("pass", pass);
            }
            else{
                Toast.makeText(beforeLogin.this,"로그인실패",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(beforeLogin.this,"로그인실패",Toast.LENGTH_LONG).show();
        }

    }*/
    public void Search() {


        cursor = db.rawQuery("SELECT userid FROM contactsTable where num='1';", null);


        if (cursor.moveToNext()) {
            DBid = cursor.getString(2);
            DBpass = cursor.getString(3);


        }

    }


   /*public void first(){
        db.execSQL("INSERT INTO contactsTable VALUES (null, '1', 'hello','123');");
        Toast.makeText(getApplicationContext(), "성공적으로 추가되었음", Toast.LENGTH_SHORT).show();
    }*/


}
