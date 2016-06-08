package com.ground0.codechallenge.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ground0.codechallenge.R;
import com.ground0.codechallenge.core.BaseActivity;
import com.ground0.codechallenge.core.viewmodel.ListActivityViewModel;
import com.ground0.model.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zer0 on 3/6/16.
 */
public class ListActivity extends BaseActivity {

  @BindView(R.id.a_list_recycler) RecyclerView recyclerView;
  AlertDialog alertDialog;
  ListActivityViewModel viewModel = new ListActivityViewModel();
  CharSequence[] status = { "Pending", "Accepted", "Completed" };
  boolean[] statusFlags = { true, true, true };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);
    ButterKnife.bind(this);
    initRecycler();
    initFilterDialog();
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
      case R.id.m_list_filter:
        alertDialog.show();
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

  private void initFilterDialog() {

    List<Integer> filters = new ArrayList<>();
    alertDialog = new AlertDialog.Builder(this).setMultiChoiceItems(status, statusFlags,
        (dialog1, which1, isChecked) -> {
          statusFlags[which1] = isChecked;
        }).setTitle("Filter").setPositiveButton("Okay", (dialog, which) -> {
      filters.clear();
      for (int i = 0; i < statusFlags.length; i++) {
        boolean checked = statusFlags[i];
        if (checked) {
          switch (i) {
            case 0:
              filters.add(Item.PENDING);
              break;
            case 1:
              filters.add(Item.ACCEPTED);
              break;
            case 2:
              filters.add(Item.COMPLETED);
              break;
          }
        }
      }
      viewModel.filter(filters);
    }).create();
  }
}
