package dev.mobile.ass_2_listview.listview_custom_base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import dev.mobile.ass_2_listview.R;
import dev.mobile.ass_2_listview.enity.Mobile;

/**
 * @author CuongNV
 */
public class CustomListAdapter extends BaseAdapter {

    private List<Mobile> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext, List<Mobile> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        if (listData.isEmpty() || listData == null) {
            return 0;
        }
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Mobile mobile = (Mobile) getItem(position);
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_listview_user, null);
            holder = new ViewHolder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tvContent);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.tvTitle.setText(mobile.getTitle());
        holder.tvContent.setText(mobile.getContent());

        return convertView;
    }

    static class ViewHolder {
        TextView tvTitle;
        TextView tvContent;
    }

}
