package com.example.booklibrary;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private EditText updateBookTitle, updateBookAuthor, updateBookPages;
    private Button updateButton,deleteButton;

    String id,title,author,page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        updateBookTitle=findViewById(R.id.updateTitleId);
        updateBookAuthor=findViewById(R.id.updateAuthorId);
        updateBookPages=findViewById(R.id.updatePageNumberId);
        updateButton=findViewById(R.id.updateButton);
        deleteButton=findViewById(R.id.deleteButton);

        getAndSetIntentData();
        ActionBar ab = getSupportActionBar();
        if(ab != null) {
            ab.setTitle(title);
        }
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB=new MyDatabaseHelper(UpdateActivity.this);
                title = updateBookTitle.getText().toString().trim();
                author = updateBookAuthor.getText().toString().trim();
                page = updateBookPages.getText().toString().trim();
                myDB.updateData(id,title,author,page);
                finish();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDelete();
            }
        });


    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
        getIntent().hasExtra("author") && getIntent().hasExtra("page")){
          id=getIntent().getStringExtra("id");
          title=getIntent().getStringExtra("title");
          author=getIntent().getStringExtra("author");
          page=getIntent().getStringExtra("page");

            updateBookTitle.setText(title);
            updateBookAuthor.setText(author);
            updateBookPages.setText(page);
            Log.d("stev",title+" "+author+" "+page);
        }
        else{
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDelete(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete "+title+" ?").setMessage("Are you sure you want to delete "+title+" ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB=new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).create().show();
    }
}