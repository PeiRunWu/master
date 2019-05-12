package com.example.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
 private List<Fruit> fruitList =new ArrayList<>();
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
         FruitAdapter adapter =new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
          ListView listView =(ListView)findViewById(R.id.list_view);
          listView.setAdapter(adapter);
           listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   Fruit fruit = fruitList.get(position);
                   Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
               }
           });
    }
    private void initFruits(){
             Fruit appale =new Fruit("Apple",R.drawable.apple_pic);
             fruitList.add(appale);
             Fruit Banana =new Fruit("Banana",R.drawable.banana_pic);
             fruitList.add(Banana);
             Fruit Orange =new Fruit("Orange",R.drawable.orange_pic);
             fruitList.add(Orange);
             Fruit Cherry =new Fruit("Cherry",R.drawable.cherry_pic);
             fruitList.add(Cherry);
             Fruit Pear =new Fruit("Pear",R.drawable.pear_pic);
             fruitList.add(Pear);
             Fruit Grape =new Fruit("Grape",R.drawable.grape_pic);
             fruitList.add(Grape);
             Fruit Mango =new Fruit("Mango",R.drawable.mango_pic);
             fruitList.add(Mango);
    }
}
