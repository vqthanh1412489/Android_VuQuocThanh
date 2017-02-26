package dautien.hcmus.thanh.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    Button btnAdd;
    EditText edtName;
    Button btnUp;
    Button btnDelete;
    int vitri =0;
    ArrayList <String> mangMonHoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = (ListView) findViewById(R.id.listViewMonHoc);
        edtName = (EditText) findViewById(R.id.editTextNhapTen);
        btnAdd = (Button)findViewById(R.id.buttonAdd);
        btnUp = (Button)findViewById(R.id.buttonUp);


        mangMonHoc = new ArrayList<>();
        mangMonHoc.add("IOS");
        mangMonHoc.add("Android");

        final ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                mangMonHoc
        );
        lvMonHoc.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edtName.getText().toString();
                mangMonHoc.add(s);
                adapter.notifyDataSetChanged();
                edtName.setText("");
            }
        });
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtName.setText(mangMonHoc.get(position));
                vitri = position;
            }
        });

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = edtName.getText().toString();
                mangMonHoc.set(vitri, t);
                adapter.notifyDataSetChanged();
                edtName.setText("");
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Ban vua xoa: " + mangMonHoc.get(position), Toast.LENGTH_SHORT).show();
                mangMonHoc.remove(vitri);
                adapter.notifyDataSetChanged();

                return false;
            }
        });





    }
}
