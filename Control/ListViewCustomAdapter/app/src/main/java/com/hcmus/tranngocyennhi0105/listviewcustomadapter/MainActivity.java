package com.hcmus.tranngocyennhi0105.listviewcustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvFood;
    ArrayList<CFood> foods = null;
    FoodAdapter foodAdapter;
    // Lưu ý có "s" ở sau thì hiểu là Mảng
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControl();
        AddEvent();
    }

    private void AddEvent() {
        // Nhớ khởi tạo mảng nhé!
        foods = new ArrayList<CFood>();
        AddArrayFood();

        foodAdapter = new FoodAdapter(
                MainActivity.this,
                R.layout.line_food,
                foods
        );

        lvFood.setAdapter(foodAdapter);
    }

    private void AddControl() {
        lvFood = (ListView) findViewById(R.id.listViewFood);
    }

    public void AddArrayFood(){
        foods.add(new CFood("Bánh bao",100,"Bánh bao", R.drawable.banhbao));
        foods.add(new CFood("Bánh chưng",20000,"Bánh chưng", R.drawable.banhchung));
        foods.add(new CFood("Bánh rán",15000,"Bánh rán", R.drawable.banhran));
        foods.add(new CFood("Bánh trung thu",100000,"Bánh trung thu", R.drawable.banhtrungthu));
        foods.add(new CFood("Bánh xèo",10000,"Bánh xèo", R.drawable.banhxeo));
        foods.add(new CFood("Bánh sinh nhật",50000,"Bánh sinh nhật", R.drawable.sinhnhat));
    }

}
