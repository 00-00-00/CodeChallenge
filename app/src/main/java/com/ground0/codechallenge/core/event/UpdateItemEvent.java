package com.ground0.codechallenge.core.event;

import com.ground0.model.Item;

/**
 * Created by zer0 on 6/6/16.
 */
public class UpdateItemEvent implements Event<Item> {

  Item mData;

  public UpdateItemEvent(Item mData) {
    this.mData = mData;
  }

  @Override public Item data() {
    return mData;
  }

  @Override public int eventType() {
    return UPDATE_ITEM;
  }
}
