package com.hema.www.viewpagerlistviewtest;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * Created by Administrator on 2016/4/23.
 */
public class NaviPagerAdapter extends PagerAdapter {
    private List<View> mList;
    private ImageView naviImg;

    private int[] imgs = new int[]{R.drawable.guanggao,
            R.drawable.guanggao_2, R.drawable.guanggao_3};

    Context mContext;

    public NaviPagerAdapter(List<View> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    String[] urls = {"http://7xjnwc.com2.z0.glb.qiniucdn.com/5289875640423403007",
            "http://7xjnwc.com2.z0.glb.qiniucdn.com/5696140107200636260",
            "http://7xjnwc.com2.z0.glb.qiniucdn.com/4704171806770627892"};

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mList.get(position);

        naviImg = (ImageView) view.findViewById(R.id.navi_img);
//        naviImg.setImageResource(imgs[position]);
        loadImage(naviImg, position);


        container.addView(view);

        return view;
    }

    private void loadImage(ImageView naviImg, int position) {
        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));

        imageLoader.displayImage(urls[position], naviImg);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position));
    }
}
