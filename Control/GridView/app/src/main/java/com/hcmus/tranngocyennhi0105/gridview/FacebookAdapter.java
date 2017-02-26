package com.hcmus.tranngocyennhi0105.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tran Ngoc Yen Nhi on 28/10/2016.
 */

public class FacebookAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<CFacebook> facebooks;

    public FacebookAdapter(Context context, int layout, List<CFacebook> facebooks) {
        this.context = context;
        this.layout = layout;
        this.facebooks = facebooks;
    }

    @Override
    public int getCount() {
        return facebooks.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(layout, null);

        TextView txtName = (TextView) v.findViewById(R.id.textViewName);
        final ImageView imgPicture = (ImageView) v.findViewById(R.id.imageViewPicture);

        final CFacebook facebook = facebooks.get(position);

        txtName.setText(facebook.getName());
        imgPicture.setImageResource(facebook.getPicture());

        final Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_alpha);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.relativeLayoutMain.setBackgroundResource(facebook.getPicture());
                MainActivity.grvBooks.startAnimation(animation);
            }
        });
        return v;

    }
}
