package com.ground0.codechallenge.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.ground0.codechallenge.R;
import com.ground0.codechallenge.core.BaseActivity;
import com.ground0.codechallenge.databinding.ActivityDetailBinding;
import com.ground0.codechallenge.core.viewmodel.DetailActivityViewModel;

/**
 * Created by zer0 on 5/6/16.
 */
public class DetailActivity extends BaseActivity {

  DetailActivityViewModel viewModel = new DetailActivityViewModel();
  ActivityDetailBinding activityDetailBinding;

  @Override protected void registerActivityWithViewModel() {
    viewModel.registerActivity(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
    activityDetailBinding.setViewModel(viewModel);
  }

  public void initUI() {
    //activityDetailBinding.setViewModel(viewModel);
  }
}
