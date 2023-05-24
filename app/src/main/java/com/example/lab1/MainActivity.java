package com.example.lab1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Animal> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ініціалізуємо список тварин
        animalList = new ArrayList<>();
        animalList.add(new Animal("Кіт", "Кіт — домашній ссавець родини котових. Це одна з найпоширеніших тварин в домашньому господарстві людини.", R.drawable.cat));
        animalList.add(new Animal("Собака", "Собака — це домашня тварина, яка використовується як компаньйон людини або службовець.", R.drawable.dog));
        animalList.add(new Animal("Ведмідь", "Ведмідь — це великий ссавець родини ведмежих. Вони живуть в різних середовищах, включаючи ліси, гори та тундру.", R.drawable.bear));

        // Знаходимо ListView у макеті
        listView = findViewById(R.id.listView);

        // Створюємо адаптер для ListView
        ArrayAdapter<Animal> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, animalList);

        // Встановлюємо адаптер для ListView
        listView.setAdapter(adapter);

        // Встановлюємо обробник натискання на елемент ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Отримуємо вибрану тварину
                Animal selectedAnimal = animalList.get(position);

                // Переходимо на другу Activity, передаючи дані про вибрану тварину
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("animal", selectedAnimal);
                startActivity(intent);
            }
        });
    }
}
