package org.dalol.customrecyclerview.ViewHolders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.dalol.customrecyclerview.Model.CarouselItem;
import org.dalol.customrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class ScrollableViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerView mRecyclerView;
    private final ItemsAdapter mItemsAdapter;

    public ScrollableViewHolder(View itemView) {
        super(itemView);
        mRecyclerView = itemView.findViewById(R.id.horizontalList);
        mRecyclerView.setAdapter(mItemsAdapter = new ItemsAdapter(itemView.getContext()));
    }

    public void setItems(List<CarouselItem> scrollables) {
        mItemsAdapter.setItems(scrollables);
    }

    class ItemsAdapter extends RecyclerView.Adapter<ScrollableItemViewHolder> {

        private final List<CarouselItem> mScrollables = new ArrayList<>();
        private final LayoutInflater mLayoutInflater;
        private final Context mContext;

        ItemsAdapter(Context context) {
            mContext = context;
            mLayoutInflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public ScrollableItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ScrollableItemViewHolder(mLayoutInflater.inflate(R.layout.item_horizontal_list_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ScrollableItemViewHolder holder, int position) {
            CarouselItem item = mScrollables.get(position);
            holder.setTitle(item.mLabel);
            Glide.with(mContext.getApplicationContext()).load(item.mImageUrl).into(holder.mImg);
        }

        @Override
        public int getItemCount() {
            return mScrollables.size();
        }

        void setItems(List<CarouselItem> scrollable) {
            mScrollables.clear();
            mScrollables.addAll(scrollable);
            notifyDataSetChanged();
        }
    }

    class ScrollableItemViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImg;
        private final TextView mTxt;

        ScrollableItemViewHolder(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.imageView2);
            mTxt = itemView.findViewById(R.id.scrollableItem);
        }

        void setTitle(String title) {
            mTxt.setText(title);
        }
    }
}
