package com.musicasporlukas.player1;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
public class MainActivity extends AppCompatActivity {
Button playBtn, pauseBtn;
MediaPlayer mediaPlayer;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  playBtn = findViewById(R.id.idBtnPlay);
  pauseBtn = findViewById(R.id.idBtnPause);
  playBtn.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    playAudio();
   }
  });
  pauseBtn.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    if (mediaPlayer.isPlaying()) {
     mediaPlayer.stop();
     mediaPlayer.reset();
     mediaPlayer.release();
     Toast.makeText(MainActivity.this, "Musicas Por Lukas se ha pausado en línea.", Toast.LENGTH_SHORT).show();
    }
    else {
     Toast.makeText(MainActivity.this, "Musicas Por Lukas no se tocó en línea.", Toast.LENGTH_SHORT).show();
    }
   }
  });
 }
 private void playAudio() {
  String audioUrl = "https://eu8.fastcast4u.com/proxy/lukasito?mp=/1";
  mediaPlayer = new MediaPlayer();
  mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
  try {
   mediaPlayer.setDataSource(audioUrl);
   mediaPlayer.prepare();
   mediaPlayer.start();
  }
  catch (IOException e) {
   e.printStackTrace();
  }
  Toast.makeText(this, "Reproducción de Musicas Por Lukas en línea.", Toast.LENGTH_SHORT).show();
 }
}
