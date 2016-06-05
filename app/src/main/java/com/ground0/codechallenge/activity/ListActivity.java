package com.ground0.codechallenge.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ground0.codechallenge.R;
import com.ground0.codechallenge.core.BaseActivity;
import com.ground0.codechallenge.viewmodel.ListActivityViewModel;

/**
 * Created by zer0 on 3/6/16.
 */
public class ListActivity extends BaseActivity {

  @BindView(R.id.a_list_recycler) RecyclerView recyclerView;
  ListActivityViewModel viewModel = new ListActivityViewModel();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);
    ButterKnife.bind(this);
    initRecycler();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.menu_list, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.m_list_sort:
        if (item.isChecked()) {
          showToast("Sorting in Ascending");
          viewModel.sortDataAscending();
        } else {
          showToast("Sorting in Descending");
          viewModel.sortDataDescending();
        }
        item.setChecked(!item.isChecked());
        return true;
      default:
        return false;
    }
  }

  @Override protected void registerActivityWithViewModel() {
    viewModel.registerActivity(this);
  }

  private void initRecycler() {
    recyclerView.setLayoutManager(
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    recyclerView.setAdapter(viewModel.getAdapter());
  }
}
