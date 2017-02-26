package com.hcmus.tranngocyennhi0105.listviewcustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Tran Ngoc Yen Nhi on 24/10/2016.
 */

public class FoodAdapter extends BaseAdapter {

    // kiểm soát màn hình
    private Context context;
    // Kiểm soát các View bên layout gốc
    private int layout;
    // mảng danh sách chứa Food, Giống như là mảng String bình thường để làm dữ liệu gốc
    // Có thể dùng ArrayList
    private List<CFood> foodList;

    public FoodAdapter(Context context, int layout, List<CFood> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        // Trả về số dòng của listview sẽ hiển thị ra màn hình
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
        // tra về item
        // return foodList.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Tối ưu bộ nhớ, chỉ khai báo 1 lần
    private class ViewHolder{
        TextView txtName, txtMoney, txtMota;
        ImageView imgPicture;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view = convertView;
        // Khỏi tạo ViewHolder
        ViewHolder holder = new ViewHolder();

        if (view == null){ // Chưa khỏi tạo thì mới khỏi tạo,
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // gán layout vào view/
            view = inflater.inflate(layout, null);
            holder.txtName = (TextView) view.findViewById(R.id.textViewName);
            holder.txtMota = (TextView) view.findViewById(R.id.textViewMota);
            holder.txtMoney = (TextView) view.findViewById(R.id.textViewMoney);
            holder.imgPicture = (ImageView) view.findViewById(R.id.imageViewPicture);
            view.setTag(holder); // tạo cờ hiệu đánh dấu
        } else{ // Nếu khỏi tạo rồi thì không cần khỏi tạo nữa
            holder = (ViewHolder) view.getTag(); // lấy đánh dấu là đã khởi tạo rồi
        }

        // Ra ngoài này the chắc chăn là lúc nào cũng đc khỏi tạo rồi thông qua setTag() và getTag()
        CFood food = foodList.get(position);
        // Có thẻ dùng
        //CFood food = (CFood) getItem(position);
        //Gán giá trị
        holder.txtName.setText(food.getName());
        holder.txtMota.setText(food.getMota());
        // ĐỊnh dạng số
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        holder.txtMoney.setText("Giá: "+ decimalFormat.format(food.getMoney()) + "Vnđ");
        holder.imgPicture.setImageResource(food.getPicture());
//        // Trả về View trên màn hình
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        // gán layout vào view
//        view = inflater.inflate(layout, null);
//        // Có thể dùng 2 kiểu, cái nào cũng được nhé! Giống nhau hết
//        //convertView = inflater.inflate(layout, parent, false);
//
//        // Ánh xạ từ layout bên kia nên cần dùng convertView
//        TextView txtName = (TextView) view.findViewById(R.id.textViewName);
//        TextView txtMota = (TextView) view.findViewById(R.id.textViewMota);
//        TextView txtMoney = (TextView) view.findViewById(R.id.textViewMoney);
//        ImageView imgPicture = (ImageView) view.findViewById(R.id.imageViewPicture);
//
//        //Tạo 1 đối tượng food tại vị trí position để truyền dữ liệu vào
//        // đối tượng này lấy từ mảng foodList
//        CFood food = foodList.get(position);
//        // Có thẻ dùng
//        //CFood food = (CFood) getItem(position);
//        //Gán giá trị
//        txtName.setText(food.getName());
//        txtMota.setText(food.getMota());
//        // ĐỊnh dạng số
//        DecimalFormat decimalFormat = new DecimalFormat("###,###");
//        txtMoney.setText("Giá: "+ decimalFormat.format(food.getMoney()) + "Vnđ");
//        imgPicture.setImageResource(food.getPicture());
//
        return view;
    }
}
