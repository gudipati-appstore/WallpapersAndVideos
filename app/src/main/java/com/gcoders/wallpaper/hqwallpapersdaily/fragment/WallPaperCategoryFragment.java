package com.example.gkr.myapplication.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gkr.myapplication.R;

import org.apache.commons.lang3.StringUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedFragment extends Fragment {

    public static String TAG = DetailedFragment.class.getName();

    private TextView textview_about_info;
    private Button goback;
    private String deviceParam;
    private OnDetailFragmentEventListener onDetailFragmentEventListener;


    public DetailedFragment() {
        //Empty Constructor for Fragment
    }

    public static DetailedFragment newInstance(String deviceParam) {
        DetailedFragment detailedFragment = new DetailedFragment();

        Bundle bundle = new Bundle();
        bundle.putString("deviceParam", deviceParam);
        detailedFragment.setArguments(bundle);

        return detailedFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null && StringUtils.isNotBlank(savedInstanceState.getString("deviceParam"))) {
            deviceParam = savedInstanceState.getString("deviceParam");
        } else if (null != getArguments()) {
            deviceParam = getArguments().getString("deviceParam");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        bindViews(rootView, savedInstanceState);
        bindEvents();
        return rootView;
    }

    private void bindEvents() {

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDetailFragmentEventListener.onBackButtonClicked(deviceParam);
            }
        });

    }

    private void bindViews(View rootView, Bundle savedInstanceState) {
        textview_about_info = rootView.findViewById(R.id.textview_about_info);
        goback = rootView.findViewById(R.id.goback);

        if (savedInstanceState != null && StringUtils.isNotBlank(savedInstanceState.getString("deviceParam"))) {
            deviceParam = savedInstanceState.getString("deviceParam");
        }

        if (StringUtils.isNotBlank(deviceParam)) {
            if (deviceParam.contains("1")) {
                textview_about_info.setText("hey you have chosen Mobile");
            } else if (deviceParam.contains("2")) {
                textview_about_info.setText("hey you have chosen Laptop");
            } else if (deviceParam.contains("3")) {
                textview_about_info.setText("hey you have chosen Hardcase");
            } else if (deviceParam.contains("4")) {
                textview_about_info.setText("hey you have chosen Monitor");
            } else if (deviceParam.contains("5")) {
                textview_about_info.setText("hey you have chosen Tv");
            } else if (deviceParam.contains("6")) {
                textview_about_info.setText("hey you have chosen FireTV");
            }
        }

        textview_about_info.append("\n\n\n" + getResources().getText(R.string.extra_text));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnDetailFragmentEventListener) {
            onDetailFragmentEventListener = (OnDetailFragmentEventListener) context;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("deviceParam", deviceParam);
        super.onSaveInstanceState(outState);
    }

    public interface OnDetailFragmentEventListener {
        void onBackButtonClicked(String deviceParam);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
}
