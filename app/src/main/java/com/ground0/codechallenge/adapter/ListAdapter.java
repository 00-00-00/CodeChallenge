package com.ground0.codechallenge.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.ground0.codechallenge.R;
import com.ground0.codechallenge.databinding.ItemItemBinding;
import com.ground0.codechallenge.viewmodel.ListActivityViewModel;
import com.ground0.codechallenge.viewmodel.ListViewModelFactory;
import com.ground0.model.Item;
import java.util.List;

/**
 * Created by zer0 on 4/6/16.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

  List<Item> mData;
  LayoutInflater mLayoutInflater;
  ListViewModelFactory viewModelFactory;

  public ListAdapter(ListActivityViewModel viewModel, List<Item> mData) {
    this.mData = mData;
    viewModelFactory = new ListViewModelFactory(viewModel);
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (mLayoutInflater == null) {
      mLayoutInflater = LayoutInflater.from(parent.getContext());
    }
    View itemView = mLayoutInflater.inflate(R.layout.item_item, parent, false);
    return new ViewHolder(itemView);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    ItemItemBinding itemItemBinding = DataBindingUtil.bind(holder.itemView);
    ListViewModelFactory.ListItemViewModel itemViewModel =
        viewModelFactory.createViewModel(mData.get(position));
    holder.setViewModel(itemViewModel);
    itemItemBinding.setViewModel(itemViewModel);
  }

  @Override public int getItemCount() {
    return mData.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    ListViewModelFactory.ListItemViewModel viewModel;

    public ListViewModelFactory.ListItemViewModel getViewModel() {
      return viewModel;
    }

    public void setViewModel(ListViewModelFactory.ListItemViewModel viewModel) {
      this.viewModel = viewModel;
    }

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
