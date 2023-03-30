package com.news.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    Button resetPasswordButton;
    EditText resetEmail;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        
        mAuth=FirebaseAuth.getInstance();
        resetPasswordButton=findViewById(R.id.resetPasswordButton);
        resetEmail=findViewById(R.id.resetEmailPrompt);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Sending Email");
        progressDialog.setMessage("Please wait while we are sending you the reset link");
        progressDialog.setCancelable(false);
        
        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=resetEmail.getText().toString();
                if(email.isEmpty()){
                    resetEmail.setError("Please enter your email");
                    resetEmail.requestFocus();
                }
                else{
                    progressDialog.show();
                    mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                progressDialog.dismiss();
                                Toast.makeText(ForgotPasswordActivity.this, "Reset link sent to your email", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else{
                                progressDialog.dismiss();
                                Toast.makeText(ForgotPasswordActivity.this, "Error sending reset link", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}