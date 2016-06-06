package com.ground0.codechallenge.core.event;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zer0 on 4/6/16.
 */
public interface Event<T> {
  T data();
  @Event.EventType int eventType();

  @Retention(RetentionPolicy.SOURCE)
  @IntDef({ITEM_DETAIL, UPDATE_ITEM})
  public @interface EventType {}

  public static final int ITEM_DETAIL = 0;
  public static final int UPDATE_ITEM = 1;
}
