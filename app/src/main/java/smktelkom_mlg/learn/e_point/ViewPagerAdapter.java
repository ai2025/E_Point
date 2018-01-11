package smktelkom_mlg.learn.e_point;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MS on 12/01/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentlist = new ArrayList<>();
    private final List<String> FragmentListTitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return FragmentListTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentListTitle.get(position);
    }

    public void AddFragment(Fragment fragment, String title) {
        fragmentlist.add(fragment);
        FragmentListTitle.add(title);
    }
}
