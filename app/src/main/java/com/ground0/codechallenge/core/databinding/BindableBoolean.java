package com.ground0.codechallenge.core.databinding;

import android.databinding.BaseObservable;

/**
 * Created by zer0 on 6/6/16.
 */
public class BindableBoolean extends BaseObservable {

  boolean data;

  public boolean get() {
    return data;
  }

  public void set(boolean data) {
    this.data = data;
  }
}
