package uz.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import uz.bookapp.book_category.Audio;
import uz.bookapp.book_category.Badiiy;
import uz.bookapp.book_category.Detektiv;
import uz.bookapp.book_category.Diniy;
import uz.bookapp.book_category.Ertak;
import uz.bookapp.book_category.Siyosiy;

public class MainActivity extends AppCompatActivity {
    LinearLayout cat_1, cat_2, cat_3, cat_4, cat_5, cat_6;
    ImageView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cat_1 = findViewById(R.id.cat_1);
        cat_2 = findViewById(R.id.cat_2);
        cat_3 = findViewById(R.id.cat_3);
        cat_4 = findViewById(R.id.cat_4);
        cat_5 = findViewById(R.id.cat_5);
        cat_6 = findViewById(R.id.cat_6);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);

        menu.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        cat_1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Badiiy.class);
            startActivity(intent);
        });
        cat_2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ertak.class);
            startActivity(intent);
        });
        cat_3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Audio.class);
            startActivity(intent);
        });
        cat_4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Siyosiy.class);
            startActivity(intent);
        });
        cat_5.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Diniy.class);
            startActivity(intent);
        });
        cat_6.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Detektiv.class);
            startActivity(intent);
        });
    }
}