package me.relex.circleindicator.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gizthon.light.circleindicator.CircleIndicator;

import me.relex.circleindicator.sample.DemoPagerAdapter;
import me.relex.circleindicator.sample.R;

public class DynamicAdapterFragment extends Fragment implements View.OnClickListener {

    private DemoPagerAdapter mAdapter;

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dynamic_adapter_demo, container, false);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        view.findViewById(R.id.add).setOnClickListener(this);
        view.findViewById(R.id.remove).setOnClickListener(this);

        mAdapter = new DemoPagerAdapter(1);

        ViewPager viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        viewpager.setAdapter(mAdapter);
        indicator.setViewPager(viewpager);
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                mAdapter.addItem();
                break;
            case R.id.remove:
                mAdapter.removeItem();
                break;
        }
    }
}
