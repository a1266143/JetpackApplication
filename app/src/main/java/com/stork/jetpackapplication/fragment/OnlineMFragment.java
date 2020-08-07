package com.stork.jetpackapplication.fragment;

import android.view.View;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.stork.jetpackapplication.R;
import com.stork.jetpackapplication.databinding.FragmentOnlinemBinding;
import com.stork.jetpackapplication.fragment.viewmodel.OnlinemViewModel;

import butterknife.BindView;

/**
 * created by xiaojun at 2020/8/7
 */
public class OnlineMFragment extends BaseFragment {

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_onlinem;
    }

    @Override
    protected void init(View view) {
        OnlinemViewModel onlineModel = new ViewModelProvider(this).get(OnlinemViewModel.class);
        FragmentOnlinemBinding binding = DataBindingUtil.bind(view);
        binding.setLifecycleOwner(this);
        binding.setModelOnlineM(onlineModel);
    }

}
