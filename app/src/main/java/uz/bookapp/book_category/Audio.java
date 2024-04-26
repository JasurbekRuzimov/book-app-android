package uz.bookapp.book_category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import uz.bookapp.R;

public class Audio extends AppCompatActivity {
    ImageView backHome;
    CardView audio1, audio2, audio3, audio4, audio5, audio6, audio7;
    TextView playingNameId;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    Button toggleButton;
    boolean isPlaying = false;
    Handler handler = new Handler();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        backHome = findViewById(R.id.backHome);

        backHome.setOnClickListener(v -> {
            finish();
        });

        audio1 = findViewById(R.id.audio1);
        audio2 = findViewById(R.id.audio2);
        audio3 = findViewById(R.id.audio3);
        audio4 = findViewById(R.id.audio4);
        audio5 = findViewById(R.id.audio5);
        audio6 = findViewById(R.id.audio6);
        audio7 = findViewById(R.id.audio7);


        playingNameId = findViewById(R.id.playingNameId);
        seekBar = findViewById(R.id.seekBar);
        toggleButton = findViewById(R.id.toggleButton);


        toggleButton.setOnClickListener(v -> toggleAudio());

        audio1.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            playAudio(R.raw.asalari_billan_orgimchak,
                    "Asalari Billan Orgimchak");
        });

        audio2.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            playAudio(R.raw.badaviyning_ziyrakligi,
                    "Badaviyning Ziyrakligi");
        });

        audio3.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            playAudio(R.raw.ambe_va_rambe,
                    "Ambe va Rambe");
        });

        audio4.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            playAudio(R.raw.dengiz_nega_shor,
                    "Dengiz Nega Sho`r");
        });

        audio5.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            playAudio(R.raw.dogda_qolgan_qarga,
                    "Dog`da Qolgan Qarg'a");
        });

        audio6.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            playAudio(R.raw.ilon_ila_mingoyoq,
                    "Ilon ila Ming`oyoq");
        });

        audio7.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            playAudio(R.raw.olmaxon,
                    "Olmaxon");
        });


        // SeekBar o'zgartirilganda amalga oshiriladigan kod
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mediaPlayer != null) {
                    int newPosition = progress * mediaPlayer.getDuration() / 100;
                    mediaPlayer.seekTo(newPosition);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // SeekBar bosilganda
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // SeekBar qo'ymay olib tashlanib qolganida
            }
        });

        // Ovoz ijrosini o'zgartirish vaqtini aniqlash
        Runnable updateSeekBar = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    int totalDuration = mediaPlayer.getDuration();
                    seekBar.setProgress((currentPosition * 100) / totalDuration);
                    handler.postDelayed(this, 1000);
                }
            }
        };

        handler.postDelayed(updateSeekBar, 1000);
    }

    private void toggleAudio() {
        if (mediaPlayer != null) {
            if (isPlaying) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
            isPlaying = !isPlaying;
            updateToggleButton();
        }
    }

    private void updateToggleButton() {
        if (isPlaying) {
            toggleButton.setText("Pause");
        } else {
            toggleButton.setText("Play️");
        }
    }

    private void playAudio(int audioResId, String ertakName) {
        mediaPlayer = MediaPlayer.create(this, audioResId);
        mediaPlayer.start();
        isPlaying = true;
        updateToggleButton();
        playingNameId.setText(ertakName);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}