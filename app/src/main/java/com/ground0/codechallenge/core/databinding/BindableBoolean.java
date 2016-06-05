package com.ground0.codechallenge.core.databinding;

import android.databinding.BaseObservable;

/**
 * Created by zer0 on 6/6/16.
 */
public class BindableBoolean extends BaseObservable {

  Boolean data;

  public Boolean get() {
    return data;
  }

  public void set(Boolean data) {
    this.data = data;
  }
}
