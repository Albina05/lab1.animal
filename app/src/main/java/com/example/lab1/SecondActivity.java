package com.example.lab1;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Отримуємо дані про вибрану тварину з Intent
        Animal selectedAnimal = getIntent().getParcelableExtra("animal");

        // Знаходимо елементи в макеті
        ImageView imageView = findViewById(R.id.imageView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        // Встановлюємо дані про вибрану тварину в елементи
        imageView.setImageResource(selectedAnimal.getImageResourceId());
        nameTextView.setText(selectedAnimal.getName());
        descriptionTextView.setText(selectedAnimal.getDescription());
    }
}
