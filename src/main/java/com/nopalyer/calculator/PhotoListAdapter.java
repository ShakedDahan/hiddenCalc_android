package com.nopalyer.calculator;




import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class PhotoListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Photo> PhotosList;

    public PhotoListAdapter(Context context, int layout, ArrayList<Photo> PhotosList) {
        this.context = context;
        this.layout = layout;
        this.PhotosList = PhotosList;
    }

    @Override
    public int getCount() {
        return PhotosList.size();
    }

    @Override
    public Object getItem(int position) {
        return PhotosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;

        TextView txtName, txtPrice;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.imageView = (ImageView) row.findViewById(R.id.imgPhoto);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Photo photo = PhotosList.get(position);

        holder.txtName.setText(photo.getName());

        byte[] PhotoImage = photo.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(PhotoImage, 0, PhotoImage.length);
        holder.imageView.setImageBitmap(bitmap);


        return row;
    }
}
