package com.od.validationexamples;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText usernameEditText, emailEditText, passwordEditText, confirmpasswordEditText;
    public Button loginButton;
    public String userNameText, eMailText, passwordText, confirmpasswordText;
    public int numberOfAttempsAllowed = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findComponents();
        setOnClickListeners();
    }

    public void findComponents(){
        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmpasswordEditText = findViewById(R.id.confirmpasswordEditText);
        loginButton = findViewById(R.id.loginButton);
    }

    public void setOnClickListeners(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userNameText = usernameEditText.getText().toString().trim();
                eMailText = usernameEditText.getText().toString().trim();
                passwordText = usernameEditText.getText().toString().trim();
                confirmpasswordText = confirmpasswordEditText.getText().toString().trim();
                checkInputs();
            }
        });
    }

    public boolean checkInputs(){
        if(getIncorrectLoginAttemptCount() >= numberOfAttempsAllowed){
            Toast.makeText(MainActivity.this,
                    "You have entered your password incorrectly " + numberOfAttempsAllowed + " times, " +
                            "so you are temporarily blocked from entering the system.!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(userNameText)) {
            Toast.makeText(MainActivity.this, "Please enter username!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(eMailText)) {
            Toast.makeText(MainActivity.this, "Please enter e-mail address!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(passwordText)) {
            Toast.makeText(MainActivity.this, "Please enter password!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(confirmpasswordText)) {
            Toast.makeText(MainActivity.this, "Please enter password to confirm!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(eMailText).matches()) {
            Toast.makeText(MainActivity.this, "Please enter valid e-mail address!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (passwordText.length() < 6) {
            Toast.makeText(MainActivity.this, "Password must contain 6 characters!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!passwordText.equals(confirmpasswordText)) {
            Toast.makeText(MainActivity.this, "Passwords must be same!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //reDirectToLoginOrSignUpPage()

        return true;
    }

    public static int getIncorrectLoginAttemptCount(){
        int totalWrongAttempt = 0;

        //In this section, you can make special settings to control the number of incorrect entries and block the user.

        return totalWrongAttempt;
    }
}
