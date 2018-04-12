package pa.senac.br.greencoin;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    private VideoView mVideoView;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.wechatLoginButton).setOnClickListener(this);
        findViewById(R.id.fbLoginButton).setOnClickListener(this);
        findViewById(R.id.otherAccButton).setOnClickListener(this);
        findViewById(R.id.createAccountButton).setOnClickListener(this);



        //In the onCreate() method, initialize the FirebaseAuth instance.
        mAuth = FirebaseAuth.getInstance();

        //mAuth.createUserWithEmailAndPassword("caiolobatogon@gmail.com","12345678");

        verificaUserLogado();

        videoBG();

    }



    private void verificaUserLogado() {
        //Verificar usuario logado
        if(mAuth.getCurrentUser()!=null){

            Log.i("verificarUsuario","Usuario está logado");

        }else {
            Log.i("verificarUsuario","Usuario não está logado");
        }
    }


    /*private void updateUI(FirebaseUser user) {
        //hideProgressDialog();
        if (user != null) {

            findViewById(R.id.email_password_buttons).setVisibility(View.GONE);
            findViewById(R.id.email_password_fields).setVisibility(View.GONE);
            findViewById(R.id.signed_in_buttons).setVisibility(View.VISIBLE);

            findViewById(R.id.verify_email_button).setEnabled(!user.isEmailVerified());
        } else {
            mStatusTextView.setText(R.string.signed_out);
            mDetailTextView.setText(null);

            findViewById(R.id.email_password_buttons).setVisibility(View.VISIBLE);
            findViewById(R.id.email_password_fields).setVisibility(View.VISIBLE);
            findViewById(R.id.signed_in_buttons).setVisibility(View.GONE);
        }
    }*/


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.wechatLoginButton) {
            Toast.makeText(this,"Google",Toast.LENGTH_LONG).show();
        } else if (i == R.id.fbLoginButton) {
            Toast.makeText(this,"Facebook",Toast.LENGTH_SHORT).show();
        } else if (i == R.id.otherAccButton) {
            criarContaUI();
            Toast.makeText(this,"Outras Contas",Toast.LENGTH_SHORT).show();
        } else if (i== R.id.createAccountButton){
            Toast.makeText(this,"Criar conta",Toast.LENGTH_SHORT).show();
        }
    }

    private void criarContaUI() {
        findViewById(R.id.field_email).setVisibility(View.VISIBLE);
        findViewById(R.id.field_password).setVisibility(View.VISIBLE);
        findViewById(R.id.createAccountButton).setVisibility(View.VISIBLE);

        findViewById(R.id.wechatLoginButton).setVisibility(View.INVISIBLE);
        findViewById(R.id.fbLoginButton).setVisibility(View.INVISIBLE);
        findViewById(R.id.otherAccButton).setVisibility(View.INVISIBLE);
    }

    //---------video
    private void videoBG() {
        //Codigo do video começa aqui
        mVideoView = findViewById(R.id.bgVideoView);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bg_video);

        mVideoView.setVideoURI(uri);
        mVideoView.start();


        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        //Codigo do video termina aqui
    }


}
