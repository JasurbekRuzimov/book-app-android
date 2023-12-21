package uz.bookapp.book_category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import uz.bookapp.R;

public class Audio extends AppCompatActivity {
    ImageView backHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        backHome = findViewById(R.id.backHome);

        backHome.setOnClickListener(v -> {
            finish();
        });
    }
}