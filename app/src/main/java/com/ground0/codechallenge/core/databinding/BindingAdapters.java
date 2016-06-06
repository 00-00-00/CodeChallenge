package com.ground0.codechallenge.core.databinding;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * Created by zer0 on 6/6/16.
 */
public class BindingAdapters {

  @BindingConversion
  public static boolean convertBindableToBoolean(BindableBoolean bindableBoolean) {
    return bindableBoolean.get();
  }

  @BindingAdapter({"app:bind"})
  public static void bindSwitch(Switch view, final BindableBoolean value) {
    view.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
      value.set(isChecked);
    });
    if (value != null) {
      view.setChecked(value.get());
    }
  }
}
