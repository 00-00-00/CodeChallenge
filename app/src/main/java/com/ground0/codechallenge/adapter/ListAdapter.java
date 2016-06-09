package com.ground0.codechallenge.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import butterknife.ButterKnife;
import com.ground0.codechallenge.R;
import com.ground0.codechallenge.databinding.ItemItemBinding;
import com.ground0.codechallenge.core.viewmodel.ListActivityViewModel;
import com.ground0.codechallenge.core.viewmodel.ListViewModelFactory;
import com.ground0.model.Item;
import java.util.List;

/**
 * Created by zer0 on 4/6/16.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

  List<Item> mData;
  LayoutInflater mLayoutInflater;
  ListViewModelFactory viewModelFactory;
  View emptyView;

  int lastPosition = -1;

  public ListAdapter(ListActivityViewModel viewModel, List<Item> mData) {
    this.mData = mData;
    if (emptyView != null) emptyView.setVisibility(mData.isEmpty() ? View.VISIBLE : View.GONE);
    viewModelFactory = new ListViewModelFactory(viewModel);
  }

  public void setData(List<Item> mData) {
    this.mData = mData;
    if (emptyView != null) emptyView.setVisibility(mData.isEmpty() ? View.VISIBLE : View.GONE);
  }

  public void setEmptyView(View emptyView) {
    this.emptyView = emptyView;
  }

  @Override public int getItemViewType(int position) {
    return super.getItemViewType(position);
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
    setAnimation(holder.itemView, position);
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

  private void setAnimation(View viewToAnimate, int position)
  {
    if (position > lastPosition)
    {
      Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), android.R.anim.slide_in_left);
      viewToAnimate.startAnimation(animation);
      lastPosition = position;
    }
  }

  @Override
  public void onViewDetachedFromWindow(final ViewHolder holder)
  {
    holder.itemView.clearAnimation();
  }
}
