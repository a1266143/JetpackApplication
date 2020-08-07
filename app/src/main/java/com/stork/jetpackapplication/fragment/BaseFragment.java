package com.stork.jetpackapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

/**
 * Fragment的基础封装
 * created by xiaojun at 2020/8/7
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(),container,false);
        ButterKnife.bind(this,view);
        init(view);
        return view;
    }

    protected abstract int getLayoutID();

    protected abstract void init(View view);

}
