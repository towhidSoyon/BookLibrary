package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText bookName,authorName, page;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        bookName=findViewById(R.id.titleId);
        authorName=findViewById(R.id.authorId);
        page=findViewById(R.id.pageNumberId);

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB= new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(bookName.getText().toString().trim(),
                        authorName.getText().toString().trim(),
                        Integer.valueOf(page.getText().toString().trim()));
                finish();

            }
        });
    }
}