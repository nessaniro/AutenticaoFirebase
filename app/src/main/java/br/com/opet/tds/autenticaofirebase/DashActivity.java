package br.com.opet.tds.autenticaofirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class DashActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        mAuth = FirebaseAuth.getInstance();

        textWelcome = findViewById(R.id.textWelcome);
    }

    @Override
    protected void onStart(){
        super.onStart();
        String mensagem = "Bem-vindo! " + mAuth.getCurrentUser().getEmail();
        textWelcome.setText(mensagem);
    }

    public void logout(View view) {
        mAuth.signOut();
        mainRedirect();
    }

    void mainRedirect(){
        Intent novaTela = new Intent(DashActivity.this,MainActivity.class);
        startActivity(novaTela);
    }
}
