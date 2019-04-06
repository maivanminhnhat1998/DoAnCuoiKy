package com.example.doancuoiky;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName,edtPass;
    Button btnSubmit;
    CheckBox saveLoginCheckBox;

    String Name;
    String Pass;

    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;

    String KEY_USER = "";
    String KEY_PASS ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onInit();

        preferences = getSharedPreferences("LoginPref",MODE_PRIVATE);

        edtName.setText(preferences.getString("KEY_USER",""));
        edtPass.setText(preferences.getString("KEY_PASS",""));

        saveLoginCheckBox.setChecked(true);
        if (edtName.getText().length() > 0){
            Login();
        }
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

    }

    private void Login() {
       Name = edtName.getText().toString();
       Pass = edtPass.getText().toString();
       if (CheckText()){
           if (Name.equals("1606020072")  && Pass.equals("admin")){
               Intent intent = new Intent(MainActivity.this,ContactActiviti.class);
               startActivity(intent);

               if (saveLoginCheckBox.isChecked()){
                   preferencesEditor = preferences.edit();
                   preferencesEditor.putString("KEY_USER",Name);
                   preferencesEditor.putString("KEY_PASS",Pass);
                   preferencesEditor.commit();
               }else {
                   preferencesEditor = preferences.edit();
                   preferencesEditor.putString("KEY_USER","");
                   preferencesEditor.putString("KEY_PASS","");
                   preferencesEditor.commit();
               }
           }
       }

       else{
            Toast.makeText(MainActivity.this,"Dang nhap khong thanh cong",Toast.LENGTH_LONG).show();
       }


    }

    private boolean CheckText(){
        if (edtName.length()<0){
            edtName.setError("User cannot null !");
            return false;
        }
        if (edtPass.length()<0){
            edtPass.setError("Password cannot null !");
            return false;
        }
            return true;
    }


    private void onInit() {
        saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
        edtName =(EditText)findViewById(R.id.edtName);
        edtPass = (EditText)findViewById(R.id.edtPass);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
    }
}
