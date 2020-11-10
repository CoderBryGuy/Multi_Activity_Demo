package com.example.multi_activity_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    ArrayAdapter<String> myAdapter;
    String name;
    List<String> myFriends;

    public void goToNext(View view){
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView)findViewById(R.id.myListView);

        myFriends = Arrays.asList("mike", "lori", "andrew", "yossi", "jason", "vicki", "nick", "aviel");

        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myFriends );

        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              name = myFriends.get(i);
            }
        });

    }
}