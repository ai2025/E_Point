package smktelkom_mlg.learn.e_point;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by MS on 10/01/2018.
 */

public class About extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    /*Dialog myDialog;
    CardView aiC, viaC, sadilC, rofiC;
    TextView tvX;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tabLayout = (TabLayout) findViewById(R.id.tablay_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpager_about);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        // Add Frag
        adapter.AddFragment(new FragmentA(), "1");
        adapter.AddFragment(new FragmentL(), "2");
        adapter.AddFragment(new FragmentR(), "3");
        adapter.AddFragment(new FragmentS(), "4");
        // adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    /*public void ShowPopUp(View v){
        tvX = (TextView) myDialog.findViewById(R.id.tvX);
        aiC = (CardView) findViewById(R.id.nameA);
        viaC = (CardView) findViewById(R.id.nameL);
        sadilC = (CardView) findViewById(R.id.nameS);
        rofiC = (CardView) findViewById(R.id.nameR);

        aiC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.custompopup);
            }
        });

        viaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.custompopup2);
            }
        });

        sadilC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.custompopup3);
            }
        });

        rofiC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.custompopup4);
            }
        });

        tvX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }*/
}
