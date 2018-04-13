package pa.senac.br.greencoin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class AppActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        findViewById(R.id.logout_button).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


        // colocar aqui pra mostrar em um textview o email do user logado

    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.logout_button) {
            Toast.makeText(this,"Deslogou",Toast.LENGTH_LONG).show();
            mAuth.signOut();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }

}
