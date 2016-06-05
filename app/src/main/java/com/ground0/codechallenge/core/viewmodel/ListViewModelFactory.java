package com.ground0.codechallenge.core.viewmodel;

import android.view.View;
import com.ground0.codechallenge.R;
import com.ground0.model.Item;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * Created by zer0 on 4/6/16.
 */
public class ListViewModelFactory {

  ListActivityViewModel listActivityViewModel;

  public ListViewModelFactory(ListActivityViewModel listItemViewModel) {
    this.listActivityViewModel = listItemViewModel;
  }

  public ListItemViewModel createViewModel(Item item) {
    return new ListItemViewModel(item);
  }

  public class ListItemViewModel {

    Item item;

    public ListItemViewModel(Item item) {
      this.item = item;
    }

    public Item getItem() {
      return item;
    }

    public String getTimeString() {
      DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("EEE, dd MMM yy h:mm a");
      return item.getTimeStamp().format(DATE_TIME_FORMATTER);
    }

    public int getStatusColor() {
      switch (item.getStatus()) {
        case Item.ACCEPTED :
          return R.color.status_accepted;
        case Item.COMPLETED:
          return R.color.status_completed;
        case Item.PENDING:
          return R.color.status_pending;
      }
    }

    public void openDetails(View view) {
      listActivityViewModel.openDetails(item);
    }
  }
}
