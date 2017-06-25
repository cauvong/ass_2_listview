package dev.mobile.ass_2_listview.listview_coban;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import dev.mobile.ass_2_listview.R;

/**
 * @author CuongNV
 */
public class ListCoBanActivity extends AppCompatActivity {
    private ListView mLvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coban);
        // ListView
        mLvList = (ListView) findViewById(R.id.lvList);

        // Data source (List )
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add(String.format("%s%d", "Phan tu thu:", i));
        }
        //Adapter
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringList);
        //Set Adapter
        mLvList.setAdapter(arrayAdapter);
    }
}
