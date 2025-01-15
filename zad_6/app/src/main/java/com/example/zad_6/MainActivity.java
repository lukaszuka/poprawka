package com.example.zad_6;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private Button confirm;
    private TextView alert;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmpassword);
        confirm = findViewById(R.id.confirm);
        alert = findViewById(R.id.alert);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                String e = email.getText().toString().trim();
                String p = password.getText().toString().trim();
                String cp = confirmPassword.getText().toString().trim();

                if(!e.contains("@")){
                    alert.setText("Nieprawidłowy adres email@2");
                } else if (!cp.equals(p)){
                    alert.setText(("Hasla sie różnią"));
                } else {
                    alert.setText("Witaj " + e);
                }

            }
        });
    }
}
