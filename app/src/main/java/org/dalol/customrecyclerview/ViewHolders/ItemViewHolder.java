package org.dalol.customrecyclerview.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ItemViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "Clicked on simple list item.", Toast.LENGTH_SHORT).show();
    }
}
