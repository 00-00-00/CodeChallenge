package com.ground0.model;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;

/**
 * Created by zer0 on 3/6/16.
 */
public class Item {

  @Item.Status int status;
  Long itemId;
  String title;
  String description;
  LocalDateTime timeStamp;

  @Retention(RetentionPolicy.SOURCE) @IntDef({ PENDING, ACCEPTED, COMPLETED })
  public @interface Status {
  }

  public static final int PENDING = 0;
  public static final int ACCEPTED = 1;
  public static final int COMPLETED = 2;

  public @Status int getStatus() {
    return status;
  }

  public void setStatus(@Status int status) {
    this.status = status;
  }

  public String getStatusString() {
    switch (status) {
      case PENDING:
        return "Pending";
      case ACCEPTED:
        return "Accepted";
      case COMPLETED:
        return "Completed";
      default:
        return "Status error";
    }
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(LocalDateTime timeStamp) {
    this.timeStamp = timeStamp;
  }

  public Long getItemId() {
    return itemId;
  }

  public Item(Long id, int status, String title, String description, LocalDateTime timeStamp) {
    this.itemId = id;
    this.status = status;
    this.title = title;
    this.description = description;
    this.timeStamp = timeStamp;
  }
}
