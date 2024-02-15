package com.example.theplanets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private static MyCustomAdapter myCustomAdapter;
    ArrayList<Planet> planetArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //the View
        listView = findViewById(R.id.listView);

        //The data source
        planetArrayList = new ArrayList<>();
        planetArrayList.add(new Planet("Mercury","0 Moons",R.drawable.mercury));
        planetArrayList.add(new Planet("Venus","0 Moons",R.drawable.venus));
        planetArrayList.add(new Planet("Earth","1 Moons",R.drawable.earth));
        planetArrayList.add(new Planet("Mars","2 Moons",R.drawable.mars));
        planetArrayList.add(new Planet("Jupiter","79 Moons",R.drawable.jupiter));
        planetArrayList.add(new Planet("Saturn","83 Moons",R.drawable.saturn));
        planetArrayList.add(new Planet("Uranus","27 Moons",R.drawable.uranus));

        //Adapter
        myCustomAdapter = new MyCustomAdapter(planetArrayList,getApplicationContext());

        listView.setAdapter(myCustomAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Planet Name: "+myCustomAdapter.getItem(i).getPlanetName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}