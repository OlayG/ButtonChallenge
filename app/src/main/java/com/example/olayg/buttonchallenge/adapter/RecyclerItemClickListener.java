package com.example.olayg.buttonchallenge.adapter;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import hugo.weaving.DebugLog;

/**
 * Created by olayg on 2/28/2018.
 */

public class RecyclerItemClickListener extends RecyclerView.SimpleOnItemTouchListener {

    public interface OnRecyclerClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private final OnRecyclerClickListener listener;
    private final GestureDetectorCompat gestureDetectorCompat;

    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, final OnRecyclerClickListener listener) {
        this.listener = listener;
        this.gestureDetectorCompat = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {
            @DebugLog
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && listener != null) {
                    listener.onItemClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
                return true;
            }

            @DebugLog
            @Override
            public void onLongPress(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && listener != null) {
                    listener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        if (gestureDetectorCompat != null) {
            boolean result = gestureDetectorCompat.onTouchEvent(e);
            return result;
        } else {
            return false;
        }
    }
}
