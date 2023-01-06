package com.example.dark_mode;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.dark_mode.Adapter.ListAdapter;

public class HomeScreen extends AppCompatActivity {

    ListView listView;
    int[] image = {R.drawable.img4,R.drawable.img5,R.drawable.img6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        listView = findViewById(R.id.list_view);

        ListAdapter adapter = new ListAdapter(getApplicationContext(), image);
        listView.setAdapter(adapter);

    }
}