package com.example.lavinia.eventappauth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private FirebaseAuth firebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        emailEditText=(EditText) findViewById(R.id.emailEditText);
        passwordEditText=(EditText) findViewById(R.id.passwordEditText);
        firebaseauth=FirebaseAuth.getInstance();

    }
    public void btnRegister_Click(View v){
        final ProgressDialog progressDialog=ProgressDialog.show(RegistrationActivity.this,"Wait a bit..", "We are trying..",true);
        (firebaseauth.createUserWithEmailAndPassword(emailEditText.getText().toString(),passwordEditText.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    Toast.makeText(RegistrationActivity.this,"Registration successful",Toast.LENGTH_LONG).show();
                    Intent i= new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(i);
                }else{
                    Log.e("ERROR",task.getException().toString());
                    Toast.makeText(RegistrationActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                }
            }
        });
    }

}


