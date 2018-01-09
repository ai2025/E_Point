package smktelkom_mlg.learn.e_point;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Salsa on 09/01/2018.
 */

public class SlideAdapter extends PagerAdapter {
    //list if images
    public int[] lst_images = {
            R.drawable.about,
            R.drawable.catat,
            R.drawable.help,
            R.drawable.laporan
    };
    //list of titles
    public String[] lst_title = {
            "SLIDE 1",
            "SLIDE 2",
            "SLIDE 3",
            "SLIDE 4"
    };
    //list of desc
    public String[] lst_desc = {
            "Desc 1",
            "Desc 2",
            "Desc 3",
            "Desc 4"
    };
    //list of background colors
    public int[] lst_back = {
            Color.rgb(55, 55, 55),
            Color.rgb(239, 85, 85),
            Color.rgb(110, 49, 80),
            Color.rgb(1, 188, 212)
    };
    Context context;
    LayoutInflater inflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide, container, false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        TextView txttitle = (TextView) view.findViewById(R.id.txttitle);
        TextView txtdesc = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_back[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        txtdesc.setText(lst_desc[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
