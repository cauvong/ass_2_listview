package dev.mobile.ass_2_listview.listview_custom_array;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dev.mobile.ass_2_listview.R;
import dev.mobile.ass_2_listview.enity.Mobile;

/**
 * @author CuongNV
 */
public class ListArrayActivity extends AppCompatActivity {
    private CustomArrayAdapter mCustomArrayAdapter;
    private List<Mobile> mMobiles;
    private EditText mEdTitle;
    private EditText mEdContent;
    private ListView mLvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        mLvMain= (ListView) findViewById(R.id.lvArray);
        mEdContent = (EditText) findViewById(R.id.edtContent);
        mEdTitle = (EditText) findViewById(R.id.edtTitle);

        mMobiles = new ArrayList<>();

        mMobiles.add(new Mobile("SamSung", "Android"));
        mMobiles.add(new Mobile("LG", "Adroid"));
        mMobiles.add(new Mobile("Nokia", "Android"));
        mMobiles.add(new Mobile("Oppo", "Android"));
        mMobiles.add(new Mobile("IPhone", "iOS"));
        mMobiles.add(new Mobile("Motorola", "Android"));
        mMobiles.add(new Mobile("Sony", "Android"));

        // android.R.layout.simple_list_item_1: Là một hằng số Layout định nghĩa sẵn của Android
        // ý nghĩa của nó là ListView với ListItem đơn giản (Duy nhất một TextView).

        mCustomArrayAdapter = new CustomArrayAdapter(this, mMobiles);
        mLvMain.setAdapter(mCustomArrayAdapter);

        //click item listview
        mLvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Mobile mobile = (Mobile) parent.getItemAtPosition(position);
                Toast.makeText(ListArrayActivity.this, mobile.getTitle() + "--" + mobile.getContent(), Toast.LENGTH_LONG).show();
            }
        });

        mLvMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showAlertDialog(position);
                return false;
            }
        });
        mLvMain.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Toast.makeText(ListArrayActivity.this, "Scroll", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
        //click add
        ((Button) findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEdTitle.getText().toString().equals("")||mEdContent.getText().toString().equals("")){
                    Toast.makeText(ListArrayActivity.this, "Please input valid data!!", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    mMobiles.add(new Mobile(mEdTitle.getText().toString().trim(), mEdContent.getText().toString().trim()));
                    mCustomArrayAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    private void showAlertDialog(final int position) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(ListArrayActivity.this);
        builder1.setTitle("Confirm Delete");
        builder1.setMessage("Do you want delete item!!");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mMobiles.remove(position);
                        mCustomArrayAdapter.notifyDataSetChanged();
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
