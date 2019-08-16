package com.example.nikhiljindal.yoga2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptorCategory extends BaseAdapter {

    Integer[] imageIds={
            R.drawable.y1,
            R.drawable.y2,
            R.drawable.y3,
            R.drawable.y4,
            R.drawable.y5,
            R.drawable.y6,
            R.drawable.y7,
            R.drawable.y8,
            R.drawable.y9,
            R.drawable.y10,
            R.drawable.y11,
            R.drawable.y12,
            R.drawable.y13,
            R.drawable.y14,
            R.drawable.y15,
            R.drawable.y16,
            R.drawable.y17,
            R.drawable.y18,
            R.drawable.y19,
            R.drawable.y20,
    };
    private List<class_category> mCategoryList;
    private LayoutInflater mInflater;

    String path;

    public AdaptorCategory(List<class_category>list,LayoutInflater inflater){
        mCategoryList = list;
        mInflater = inflater;
    }


    @Override
    public int getCount() {
        return mCategoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCategoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewCategory adaptor_category;
        if (convertView==null){
            convertView = mInflater.inflate(R.layout.adaptor_category,null);
            adaptor_category=new ViewCategory();
            adaptor_category.image=(ImageView)convertView.findViewById(R.id.ImageViewCategory);
            adaptor_category.txtcatname=(TextView)convertView.findViewById(R.id.txtcatname);
            convertView.setTag(adaptor_category);
            adaptor_category.image.setImageResource(imageIds[position]);
        }
        else {
            adaptor_category=(ViewCategory)convertView.getTag();
        }

        class_category curCategory = mCategoryList.get(position);
        //String img =   curCategory.getImage();
        //int resID=convertView.getResources().getIdentifier("@drawable/"+img,"drawable",parent.getContext().getPackageName());
        //adaptor_category.image.setImageResource(imageIds[0]);
        adaptor_category.txtcatname.setText(curCategory.getAsana_name());

        return convertView;
    }

    public class ViewCategory{
        ImageView image;
        //SmartImageView categoryImage;
        TextView txtcatname;

        //TextView placeName;
    }

}

