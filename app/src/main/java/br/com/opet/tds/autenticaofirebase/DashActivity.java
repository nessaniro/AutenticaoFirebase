package br.com.opet.tds.autenticaofirebase;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class DashActivity extends AppCompatActivity {

    private TextView textUser;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        textUser = findViewById(R.id.textUser);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        textUser.setText(user.getEmail());
    }

    public void signOut(View view) {
        firebaseAuth.signOut();
        Intent telaPrincipal =
                new Intent(DashActivity.this,
                        MainActivity.class);
        startActivity(telaPrincipal);

    }
}
