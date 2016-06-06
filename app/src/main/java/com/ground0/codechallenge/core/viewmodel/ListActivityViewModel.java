package com.ground0.codechallenge.core.viewmodel;

import android.content.Intent;
import com.ground0.codechallenge.activity.DetailActivity;
import com.ground0.codechallenge.activity.ListActivity;
import com.ground0.codechallenge.adapter.ListAdapter;
import com.ground0.codechallenge.core.BaseActivityViewModel;
import com.ground0.codechallenge.core.event.LaunchItemDetailEvent;
import com.ground0.codechallenge.core.event.UpdateItemEvent;
import com.ground0.model.Item;
import com.ground0.repository.DataStore.DataStore;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zer0 on 5/6/16.
 */
public class ListActivityViewModel extends BaseActivityViewModel<ListActivity> {

  List<Item> mData;
  ListAdapter mListAdapter;
  DataStore dataStore = new DataStore();

  final Comparator<Item> ASCENDING_TIME_COMPARATOR = (lhs, rhs) -> {
    if (lhs.getTimeStamp().isBefore(rhs.getTimeStamp())) {
      return -1;
    } else if (lhs.getTimeStamp().isAfter(rhs.getTimeStamp())) {
      return 1;
    } else {
      return 0;
    }
  };
  final Comparator<Item> DESCENDING_TIME_COMPARATOR = (lhs, rhs) -> {
    if (lhs.getTimeStamp().isBefore(rhs.getTimeStamp())) {
      return 1;
    } else if (lhs.getTimeStamp().isAfter(rhs.getTimeStamp())) {
      return -1;
    } else {
      return 0;
    }
  };

  @Override public void afterRegister() {
    super.afterRegister();
    loadData();

    getCompositeSubscription().add(getActivity().getBaseApplication()
        .getAppBehaviourBus()
        .filter(event -> event instanceof UpdateItemEvent)
        .subscribe(event1 -> {
          Item updatedItem = ((UpdateItemEvent)event1).data();
          for (Item item : mData) {
            if (updatedItem.getItemId().equals(item.getItemId())) {
              item = updatedItem;
              mListAdapter.notifyDataSetChanged();
              break;
            }
          }
        }));
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

  public void sortDataAscending() {
    Collections.sort(mData, ASCENDING_TIME_COMPARATOR);
    mListAdapter.notifyDataSetChanged();
  }

  public void sortDataDescending() {
    Collections.sort(mData, DESCENDING_TIME_COMPARATOR);
    mListAdapter.notifyDataSetChanged();
  }
}
