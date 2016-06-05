package com.ground0.codechallenge.viewmodel;

import com.ground0.codechallenge.activity.DetailActivity;
import com.ground0.codechallenge.core.BaseActivityViewModel;
import com.ground0.codechallenge.core.event.LaunchItemDetailEvent;
import com.ground0.model.Item;

/**
 * Created by zer0 on 5/6/16.
 */
public class DetailActivityViewModel extends BaseActivityViewModel<DetailActivity> {

  Item mItem;

  @Override public void afterRegister() {
    super.afterRegister();
    getCompositeSubscription().add(getActivity().getBaseApplication()
        .getAppBehaviourBus()
        .filter(event -> event instanceof LaunchItemDetailEvent)
        .subscribe(event -> {
          LaunchItemDetailEvent launchItemDetailEvent =(LaunchItemDetailEvent) event;
          initUI(launchItemDetailEvent.data());
        }));
  }

  private void initUI(Item data) {
    mItem = data;
    getActivity().initUI();
  }

  public Item getItem() {
    return mItem;
  }
}
