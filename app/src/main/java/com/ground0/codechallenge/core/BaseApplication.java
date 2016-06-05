package com.ground0.codechallenge.core;

import android.app.Application;
import com.ground0.codechallenge.core.event.Event;
import rx.subjects.BehaviorSubject;

/**
 * Created by zer0 on 4/6/16.
 */
public class BaseApplication extends Application {

  protected BehaviorSubject<Event> appBehaviourBus = BehaviorSubject.create();

  public BehaviorSubject<Event> getAppBehaviourBus() {
    return appBehaviourBus;
  }

}
