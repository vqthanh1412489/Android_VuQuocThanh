package com.hcmus.tranngocyennhi0105.gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Giống Listview
    public static GridView grvBooks;
    ArrayList<CFacebook> arrayBooks;
    FacebookAdapter facebookAdapter;

    public static ImageView imageView;

    public  static RelativeLayout relativeLayoutMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grvBooks = (GridView) findViewById(R.id.gridViewBooks);
        imageView = (ImageView) findViewById(R.id.imageView);
        relativeLayoutMain = (RelativeLayout) findViewById(R.id.main);

        arrayBooks = new ArrayList<CFacebook>();

        AddBooks();

        facebookAdapter = new FacebookAdapter(
                MainActivity.this,
                R.layout.line_facebook,
                arrayBooks
        );

        grvBooks.setAdapter(facebookAdapter);

        grvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // positine đếm từ trái qua phải, từ trên xuống dưới : bắt đầu từ 0.
                Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });

        grvBooks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayBooks.remove(position);
                Toast.makeText(MainActivity.this, "Đã xóa" + arrayBooks.get(position), Toast.LENGTH_SHORT).show();
                facebookAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void AddBooks() {
        arrayBooks.add(new CFacebook("Châu",R.drawable.chau));
        arrayBooks.add(new CFacebook("Nữ",R.drawable.nu));
        arrayBooks.add(new CFacebook("Quỳnh",R.drawable.quynh));
        arrayBooks.add(new CFacebook("Thắng",R.drawable.thang));
        arrayBooks.add(new CFacebook("Trúc",R.drawable.truc));
        arrayBooks.add(new CFacebook("Tuấn",R.drawable.tuan));
        arrayBooks.add(new CFacebook("Vinh",R.drawable.vinh));

    }
}
