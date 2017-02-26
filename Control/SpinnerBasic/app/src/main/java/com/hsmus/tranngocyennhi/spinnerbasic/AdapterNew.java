package com.hsmus.tranngocyennhi.spinnerbasic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tran Ngoc Yen Nhi on 02/11/2016.
 */

public class AdapterNew extends BaseAdapter {

    private Context context;
    private int layout;
    private List<CNew> newList;

    public AdapterNew(Context context, int layout, List<CNew> newList) {
        this.context = context;
        this.layout = layout;
        this.newList = newList;
    }

    @Override
    public int getCount() {
        return newList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtnew;
        ImageView imgPicture;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        // Nhớ cái này nhé!
        ViewHolder holder = new ViewHolder();
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(layout, null);

            holder.txtnew = (TextView) v.findViewById(R.id.textViewnew);
            holder.imgPicture = (ImageView) v.findViewById(R.id.imageViewPicture);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        CNew cNew = newList.get(position);
        holder.txtnew.setText(cNew.getNew());
        holder.imgPicture.setImageResource(cNew.getPicture());

        return v;
    }
}
