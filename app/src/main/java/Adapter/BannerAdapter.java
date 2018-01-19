package Adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by jack.yang on 15/11/13.
 */
public class BannerAdapter extends PagerAdapter {

    private ArrayList<View> viewList = new ArrayList<View>();

    public BannerAdapter(ArrayList<View> viewList){
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    public int getPosition(int position){
        if(viewList.get(position).getTag() == null)
            return position;
        else
            return (Integer)viewList.get(position).getTag();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = viewList.get(position);

        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewPager) container).addView(view);

        return viewList.get(position);
    }
}
