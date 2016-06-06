package com.ground0.repository.DataStore;

import com.ground0.model.Item;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * Created by zer0 on 4/6/16.
 */
public class DataStore {

  final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
  static String loremIpsum =
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur convallis laoreet mauris, sit amet mattis leo molestie at. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vestibulum in odio leo. Suspendisse accumsan ex ipsum, a finibus quam tempor vel. Aliquam et risus non velit semper volutpat. Cras dui massa, consequat non vulputate sed, vehicula id tellus. Aenean laoreet consequat erat sollicitudin aliquet. Maecenas commodo, nulla eget pretium sodales, sapien lectus semper leo, ut consectetur augue leo quis justo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque condimentum malesuada tortor a aliquam. Nam iaculis nisl et urna imperdiet cursus. Nunc tincidunt ipsum sit amet semper mattis. In maximus tortor sed tellus dictum imperdiet. Ut volutpat est risus, id elementum enim condimentum vel. Curabitur ultrices sollicitudin lorem vitae pharetra. ";

  static List<Item> mDataList = new ArrayList<Item>() {{
    add(new Item(100L, Item.PENDING, StringUtils.substring(loremIpsum, 10, 40),
        StringUtils.substring(loremIpsum, 20),
        LocalDateTime.parse("05 Jun 2016 19:31", DATE_TIME_FORMATTER)));
    add(new Item(200L, Item.PENDING, StringUtils.substring(loremIpsum, 20, 60),
        StringUtils.substring(loremIpsum, 20),
        LocalDateTime.parse("06 Jun 2016 19:31", DATE_TIME_FORMATTER)));
    add(new Item(300L, Item.PENDING, StringUtils.substring(loremIpsum, 60, 30),
        StringUtils.substring(loremIpsum, 20),
        LocalDateTime.parse("05 Jun 2016 23:31", DATE_TIME_FORMATTER)));
    add(new Item(400L, Item.PENDING, StringUtils.substring(loremIpsum, 50, 70),
        StringUtils.substring(loremIpsum, 20),
        LocalDateTime.parse("09 Jun 2016 19:31", DATE_TIME_FORMATTER)));
    add(new Item(500L, Item.PENDING, StringUtils.substring(loremIpsum, 40, 80),
        StringUtils.substring(loremIpsum, 20),
        LocalDateTime.parse("03 Jun 2016 19:31", DATE_TIME_FORMATTER)));
  }};

  public List<Item> getDataList() {
    return mDataList;
  }

  public Item getDataList(Long id) {
    return null;
  }

  public void updateItem(Item updatedItem) {
    for (Item item: mDataList) {
      if (item.getItemId().equals(updatedItem.getItemId())) {
        item = updatedItem;
        break;
      }
    }
  }
}
