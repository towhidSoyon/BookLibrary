package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class insertActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        frameLayout=findViewById(R.id.frameLayoutId);
        ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutId,new AddFragment());
        ft.commit();
    }
}