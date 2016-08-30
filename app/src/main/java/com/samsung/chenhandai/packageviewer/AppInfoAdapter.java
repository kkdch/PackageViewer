package com.samsung.chenhandai.packageviewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by chenhan.dai on 8/29/16.
 */
public class AppInfoAdapter extends ArrayAdapter<AppInfo> {
    List<AppInfo> list;
    Context context;

    public AppInfoAdapter(Context context, int textViewResourceId, List<AppInfo> list) {
        super(context, textViewResourceId, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.grid_item_pkglist, viewGroup, false);
        }
        TextView textView = (TextView) v.findViewById(R.id.grid_item_text);
        ImageView imageView = (ImageView) v.findViewById(R.id.grid_item_image);
        AppInfo appInfo = list.get(i);
//        textView.setCompoundDrawablesWithIntrinsicBounds(null, appInfo.getIcon(), null, null);
        textView.setText(appInfo.getName());
        imageView.setImageDrawable(appInfo.getIcon());
        return v;
    }

}
