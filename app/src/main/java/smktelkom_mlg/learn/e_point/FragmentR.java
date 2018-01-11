package smktelkom_mlg.learn.e_point;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MS on 11/01/2018.
 */

public class FragmentR extends Fragment {

    View view;

    public FragmentR() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.r_fragment, container, false);
        return view;
    }
}
