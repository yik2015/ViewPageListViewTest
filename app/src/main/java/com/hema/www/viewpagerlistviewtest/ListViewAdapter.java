package com.hema.www.viewpagerlistviewtest;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/23.
 */
public class ListViewAdapter extends BaseAdapter implements ViewPager.OnPageChangeListener {
    static final int TYPE_COUNT = 2;
    static final int ITEM_COUNT = 5;

    static final int TYPE_NAVI = 0;
    static final int TYPE_8BTNS = 1;

    private Context mContext;
    private LayoutInflater mInflater;

    public ListViewAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 0;

        else return 1;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getCount() {
        return ITEM_COUNT;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewByType(getItemViewType(position), convertView, parent, position);
    }

    private View getViewByType(int type, View convertView, ViewGroup parent, int position) {
        switch (type) {
            case TYPE_NAVI:
                return getNavi(convertView, parent);
            case TYPE_8BTNS:
                return get8Btns(convertView, position);
        }

        return null;
    }

    private View get8Btns(View convertView, int position) {
        View view = mInflater.inflate(R.layout.layout_other_item, null);
        TextView textView = (TextView) view.findViewById(R.id.other_txt);

        textView.setText("TextView # " + position);

        return view;
    }

    ViewPager viewPager;

    private View getNavi(View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.layout_viewpager, null);
        viewPager = (ViewPager) view.findViewById(R.id.home_navi_viewpager);

        List<View> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            View naviItem = mInflater.inflate(R.layout.viewpager_content, null);
            list.add(naviItem);
        }

        NaviPagerAdapter adapter = new NaviPagerAdapter(list, mContext);

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);


        return view;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
