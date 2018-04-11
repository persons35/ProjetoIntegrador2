package pa.senac.br.greencoin;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView;

    private FirebaseAuth mAuth;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //In the onCreate() method, initialize the FirebaseAuth instance.
        mAuth = FirebaseAuth.getInstance();

//        mAuth.createUserWithEmailAndPassword("caio.lobato@gmail.com","caio.lobato123")
//                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                        if(task.isSuccessful()){
//                            //cadastro com sucesso
//                            Log.i("createUser", "Sucesso ao cadastrar o usuario!!!");
//                        } else {
//                            //erro ao cadastrar
//                            Log.i("createUser","Erro ao cadastrar o usuario!!!");
//                        }
//
//                    }
//                });

        //Codigo do video começa aqui
        mVideoView = (VideoView) findViewById(R.id.bgVideoView);

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

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }



}
