package dev.mobile.ass_2_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import dev.mobile.ass_2_listview.listview_coban.ListCoBanActivity;
import dev.mobile.ass_2_listview.listview_custom_array.ListArrayActivity;
import dev.mobile.ass_2_listview.listview_custom_base.ListBasicActivity;

/**
 * @author CuongNV
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnLvBasic;
    private Button mBtnLvBaseAdapter;
    private Button mBtnLvArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // findId for button
        mBtnLvBasic = (Button) findViewById(R.id.btnLvBasic);
        mBtnLvBaseAdapter = (Button) findViewById(R.id.btnLvBaseAdapter);
        mBtnLvArrayAdapter = (Button) findViewById(R.id.btnLvArrayAdapter);

        // event click for button
        mBtnLvBasic.setOnClickListener(this);
        mBtnLvBaseAdapter.setOnClickListener(this);
        mBtnLvArrayAdapter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLvBasic:
                Intent intentListBasic = new Intent(MainActivity.this, ListCoBanActivity.class);
                startActivity(intentListBasic);
                break;
            case R.id.btnLvBaseAdapter:
                Intent intentListBaseAdapter = new Intent(MainActivity.this, ListBasicActivity.class);
                startActivity(intentListBaseAdapter);
                break;
            case R.id.btnLvArrayAdapter:
                Intent intentListArray = new Intent(MainActivity.this, ListArrayActivity.class);
                startActivity(intentListArray);
                break;
            default:
                break;
        }
    }
}
