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

public class Badiiy extends AppCompatActivity {
    ImageView backHome;
    CardView badiiy1, badiiy2, badiiy3, badiiy4, badiiy5, badiiy6, badiiy7;
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
        setContentView(R.layout.activity_badiiy);

        backHome = findViewById(R.id.backHome);
        backHome.setOnClickListener(v -> {
            finish();
        });

        badiiy1 = findViewById(R.id.badiiy1);
        badiiy2 = findViewById(R.id.badiiy2);
        badiiy3 = findViewById(R.id.badiiy3);
        badiiy4 = findViewById(R.id.badiiy4);
        badiiy5 = findViewById(R.id.badiiy5);
        badiiy6 = findViewById(R.id.badiiy6);
        badiiy7 = findViewById(R.id.badiiy7);


    }
}
