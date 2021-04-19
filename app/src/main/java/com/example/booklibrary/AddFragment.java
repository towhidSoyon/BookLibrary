package com.example.booklibrary;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddFragment extends Fragment {
    private EditText bookName,authorName, page;
    private Button addButton;
    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bookName=view.findViewById(R.id.titleId);
        authorName=view.findViewById(R.id.authorId);
        page=view.findViewById(R.id.pageNumberId);

        addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB= new MyDatabaseHelper(getContext());
                myDB.addBook(bookName.getText().toString().trim(),
                        authorName.getText().toString().trim(),
                        Integer.valueOf(page.getText().toString().trim()));
                Intent intent=new Intent(getContext(),MainActivity.class);
                startActivity(intent);
                //finish();

            }
        });
    }
}