package dautien.hcmus.thanh.listviewbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTenMonHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTenMonHoc = (ListView) findViewById(R.id.listViewTenMonHoc);

        final ArrayList <String> mangMonHoc = new ArrayList<>();
        mangMonHoc.add("PHP");
        mangMonHoc.add("Wordpress");
        mangMonHoc.add("Engineering");
        mangMonHoc.add("Goto Back");

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                mangMonHoc
        );

        lvTenMonHoc.setAdapter(adapter);

        lvTenMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        MainActivity.this,
                        mangMonHoc.get(position),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
