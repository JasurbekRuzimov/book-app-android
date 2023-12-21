package uz.bookapp.book_category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import uz.bookapp.R;

public class Ertak extends AppCompatActivity {
    ImageView backHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ertak);

        backHome = findViewById(R.id.backHomeErtak);
        backHome.setOnClickListener(v -> {
            finish();
        });
    }
}