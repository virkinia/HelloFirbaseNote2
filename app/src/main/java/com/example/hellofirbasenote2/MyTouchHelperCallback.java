package com.example.hellofirbasenote2;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class MyTouchHelperCallback extends ItemTouchHelper.Callback {
    private NoteAdapter mAdapter;

    public MyTouchHelperCallback(NoteAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // Drag up and down, if there are other needs the same
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        // Slide to the right, if there are other needs
        int swipeFlags = ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        // Notify Adapter to update data and views
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        // If false is returned, drag-and-drop is not supported.
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        // Notify Adapter to update data and views
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        // Is it possible to slide left and right and return true by default?
        return true;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        // Can you drag it up and down for a long time and return false by default?
        return true;
    }
}
