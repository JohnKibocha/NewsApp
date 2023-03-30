package com.news.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText inputUserName, inputEmail, inputPassword, inputConfirmPassword;
    Button btnRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView btn=findViewById(R.id.goToLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        inputUserName = findViewById(R.id.inputUserName);
        inputEmail = findViewById(R.id.inputEmailAddress);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.confirmPassword);
        progressDialog = new ProgressDialog(this);
        btnRegister = findViewById(R.id.btnRegister);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = inputUserName.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                String confirmPassword = inputConfirmPassword.getText().toString();
                if (userName.isEmpty()) {
                    inputUserName.setError("Please enter your username");
                    inputUserName.requestFocus();
                } else if (email.isEmpty()) {
                    inputEmail.setError("Please enter your email");
                    inputEmail.requestFocus();
                } else if (!email.matches(emailPattern)) {
                    inputEmail.setError("Please enter a valid email");
                    inputEmail.requestFocus();
                }
                if (password.isEmpty()) {
                    inputPassword.setError("Please enter your password");
                    inputPassword.requestFocus();
                } else if (password.length() < 6) {
                    inputPassword.setError("Password must be at least 6 characters");
                    inputPassword.requestFocus();
                }
                if (confirmPassword.isEmpty()) {
                    inputConfirmPassword.setError("Please confirm your password");
                    inputConfirmPassword.requestFocus();
                } else if (!password.equals(confirmPassword)) {
                    inputConfirmPassword.setError("Password does not match");
                    inputConfirmPassword.requestFocus();
                } else {
                    progressDialog.setMessage("Registering user...");
                    progressDialog.setTitle("Please wait");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();
                                Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                finish();
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}