package com.ground0.codechallenge.core.viewmodel;

import com.ground0.codechallenge.activity.DetailActivity;
import com.ground0.codechallenge.core.BaseActivityViewModel;
import com.ground0.codechallenge.core.databinding.BindableBoolean;
import com.ground0.codechallenge.core.event.LaunchItemDetailEvent;
import com.ground0.model.Item;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * Created by zer0 on 5/6/16.
 */
public class DetailActivityViewModel extends BaseActivityViewModel<DetailActivity> {

  Item mItem;
  public BindableBoolean updateBoolean = new BindableBoolean();

  @Override public void afterRegister() {
    super.afterRegister();
    getCompositeSubscription().add(getActivity().getBaseApplication()
        .getAppBehaviourBus()
        .filter(event -> event instanceof LaunchItemDetailEvent)
        .subscribe(event -> {
          LaunchItemDetailEvent launchItemDetailEvent = (LaunchItemDetailEvent) event;
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

  public String getTimeString() {
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("EEE, dd MMM yy h:mm a");
    return mItem.getTimeStamp().format(DATE_TIME_FORMATTER);
  }

  public String getSwitchText() {
    switch (mItem.getStatus()) {
      case Item.PENDING:
        return "Accepted";
      case Item.ACCEPTED:
        return "Completed";
      case Item.COMPLETED:
        return "Completed";
      default:
        return "";
    }
  }
}
