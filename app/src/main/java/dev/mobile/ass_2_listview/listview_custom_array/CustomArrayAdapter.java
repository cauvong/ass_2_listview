package dev.mobile.ass_2_listview.listview_custom_array;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import dev.mobile.ass_2_listview.R;
import dev.mobile.ass_2_listview.enity.Mobile;

/**
 * @author CuongNV
 */
public class CustomArrayAdapter extends ArrayAdapter<Mobile> {
    private List<Mobile> mMobiles;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public CustomArrayAdapter(Context context, List<Mobile> mobiles) {
        super(context, 0, mobiles);
        mContext = context;
        mMobiles = mobiles;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        if (mMobiles.isEmpty()) {
            return 0;
        }
        return mMobiles.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Mobile mobile = mMobiles.get(position);
        ViewHolder viewHolder;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_listview_user, null, false);
            // Lookup view for data population
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tVContent = (TextView) convertView.findViewById(R.id.tvContent);
            //set tag
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(mobile.getTitle());
        viewHolder.tVContent.setText(mobile.getContent());
        // Return the completed view to render on screen
        return convertView;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView tvTitle;
        TextView tVContent;
    }

}
