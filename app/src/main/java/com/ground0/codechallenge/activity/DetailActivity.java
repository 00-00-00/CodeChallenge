package com.ground0.codechallenge.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ground0.codechallenge.R;
import com.ground0.codechallenge.core.BaseActivity;
import com.ground0.codechallenge.databinding.ActivityDetailBinding;
import com.ground0.codechallenge.core.viewmodel.DetailActivityViewModel;
import com.ground0.model.Item;

/**
 * Created by zer0 on 5/6/16.
 */
public class DetailActivity extends BaseActivity {

  DetailActivityViewModel viewModel = new DetailActivityViewModel();
  ActivityDetailBinding activityDetailBinding;
  @BindView(R.id.a_detail_switch_updateCompleted) Switch updateCompleted;
  @BindView(R.id.a_detail_switch_updatePending) Switch updatePending;

  @Override protected void registerActivityWithViewModel() {
    viewModel.registerActivity(this);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
    activityDetailBinding.setViewModel(viewModel);
    ButterKnife.bind(this);
    initSwitches();
  }

  private void initSwitches() {

    switch (viewModel.getItem().getStatus()) {
      case Item.ACCEPTED:
        updatePending.setChecked(true);
        updateCompleted.setVisibility(View.VISIBLE);
        break;
      case Item.PENDING:
        updatePending.setChecked(false);
        updateCompleted.setVisibility(View.GONE);
        break;
      case Item.COMPLETED:
        updatePending.setChecked(true);
        updatePending.setEnabled(false);
        updateCompleted.setVisibility(View.VISIBLE);
        updateCompleted.setChecked(true);
        break;
    }

    updatePending.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (isChecked) {
        updateCompleted.setVisibility(View.VISIBLE);
        viewModel.setStatus(Item.ACCEPTED);
      } else {
        updateCompleted.setVisibility(View.GONE);
        viewModel.setStatus(Item.PENDING);
      }
    });

    updateCompleted.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (isChecked) {
        updatePending.setEnabled(false);
        viewModel.setStatus(Item.COMPLETED);
      } else {
        updatePending.setEnabled(true);
        viewModel.setStatus(Item.ACCEPTED);
      }
    });
  }

  @Override protected void onStop() {
    super.onStop();
    viewModel.saveChanges();
  }

  @Override public void onBackPressed() {
    viewModel.saveChanges();
    super.onBackPressed();
  }
}
