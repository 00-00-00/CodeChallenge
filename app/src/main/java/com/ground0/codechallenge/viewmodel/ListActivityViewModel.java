package com.ground0.codechallenge.viewmodel;

import android.content.Intent;
import com.ground0.codechallenge.activity.DetailActivity;
import com.ground0.codechallenge.activity.ListActivity;
import com.ground0.codechallenge.adapter.ListAdapter;
import com.ground0.codechallenge.core.BaseActivityViewModel;
import com.ground0.codechallenge.core.event.LaunchItemDetailEvent;
import com.ground0.model.Item;
import com.ground0.repository.DataStore.DataStore;
import java.util.List;

/**
 * Created by zer0 on 5/6/16.
 */
public class ListActivityViewModel extends BaseActivityViewModel<ListActivity> {

  List<Item> mData;
  ListAdapter mListAdapter;

  DataStore dataStore = new DataStore();

  @Override public void afterRegister() {
    super.afterRegister();
    loadData();
  }

  public void loadData() {
    mData = dataStore.getDataList();
    mListAdapter = new ListAdapter(this, mData);
  }

  public ListAdapter getAdapter() {
    if (mListAdapter == null) {
      mListAdapter = new ListAdapter(this, mData);
    }
    return mListAdapter;
  }

  public void openDetails(Item item) {
    getActivity().getBaseApplication().getAppBehaviourBus().onNext(new LaunchItemDetailEvent(item));
    getActivity().startActivity(new Intent(getActivity(), DetailActivity.class));
  }
}
