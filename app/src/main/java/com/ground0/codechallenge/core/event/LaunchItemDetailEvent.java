package com.ground0.codechallenge.core.event;

import com.ground0.model.Item;

/**
 * Created by zer0 on 5/6/16.
 */
public class LaunchItemDetailEvent implements Event<Item> {

  Item item;

  public LaunchItemDetailEvent(Item item) {
    this.item = item;
  }

  @Override public Item data() {
    return item;
  }

  @Override public int eventType() {
    return ITEM_DETAIL;
  }
}
