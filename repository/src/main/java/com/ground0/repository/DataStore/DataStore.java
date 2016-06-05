package com.ground0.repository.DataStore;

import com.ground0.model.Item;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.LocalDateTime;

/**
 * Created by zer0 on 4/6/16.
 */
public class DataStore {

  String loremIpsum =
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur convallis laoreet mauris, sit amet mattis leo molestie at. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vestibulum in odio leo. Suspendisse accumsan ex ipsum, a finibus quam tempor vel. Aliquam et risus non velit semper volutpat. Cras dui massa, consequat non vulputate sed, vehicula id tellus. Aenean laoreet consequat erat sollicitudin aliquet. Maecenas commodo, nulla eget pretium sodales, sapien lectus semper leo, ut consectetur augue leo quis justo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque condimentum malesuada tortor a aliquam. Nam iaculis nisl et urna imperdiet cursus. Nunc tincidunt ipsum sit amet semper mattis. In maximus tortor sed tellus dictum imperdiet. Ut volutpat est risus, id elementum enim condimentum vel. Curabitur ultrices sollicitudin lorem vitae pharetra. ";
  List<Item> mDataList = new ArrayList<Item>() {{
    add(new Item(100L, Item.PENDING, StringUtils.substring(loremIpsum, 10, 20),
        StringUtils.substring(loremIpsum, 20), LocalDateTime.now()));
    add(new Item(200L, Item.PENDING, StringUtils.substring(loremIpsum, 10, 20),
        StringUtils.substring(loremIpsum, 20), LocalDateTime.now()));
    add(new Item(300L, Item.PENDING, StringUtils.substring(loremIpsum, 10, 20),
        StringUtils.substring(loremIpsum, 20), LocalDateTime.now()));
    add(new Item(400L, Item.PENDING, StringUtils.substring(loremIpsum, 10, 20),
        StringUtils.substring(loremIpsum, 20), LocalDateTime.now()));
    add(new Item(500L, Item.PENDING, StringUtils.substring(loremIpsum, 10, 20),
        StringUtils.substring(loremIpsum, 20), LocalDateTime.now()));
  }};

  public List<Item> getDataList() {
    return mDataList;
  }

  public Item getDataList(Long id) {
    return null;
  }
}