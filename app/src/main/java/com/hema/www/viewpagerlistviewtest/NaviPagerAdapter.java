package com.hema.www.viewpagerlistviewtest;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/4/23.
 */
public class NaviPagerAdapter extends PagerAdapter {
    private List<View> mList;
    private ImageView naviImg;

    private int[] imgs = new int[]{R.drawable.guanggao,
            R.drawable.guanggao_2, R.drawable.guanggao_3};

    public NaviPagerAdapter(List<View> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mList.get(position);

        naviImg = (ImageView) view.findViewById(R.id.navi_img);
        naviImg.setImageResource(imgs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position));
    }
}
