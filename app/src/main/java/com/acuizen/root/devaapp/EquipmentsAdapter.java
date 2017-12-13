package com.acuizen.root.devaapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 24/11/17.
 */


public class EquipmentsAdapter extends RecyclerView.Adapter<EquipmentsAdapter.ViewHolder> {

    private List<Equipments> equipList;
    private Activity activity;

    public EquipmentsAdapter(Activity activity,List<Equipments> equipList){
        this.equipList = equipList;
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, tag_no;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.equip_title);
            tag_no = view.findViewById(R.id.tag_no);
        }

    }

    public interface ClickListener {

        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{
        private GestureDetector gestureDetector;
        private EquipmentsAdapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final EquipmentsAdapter.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    Log.d("Tap","True");
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

   /* public EquipmentsAdapter(List<Equipments> equipList) {
        this.equipList = equipList;
    }*/

    @Override
    public EquipmentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_equipments_row, parent, false);

        return new EquipmentsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EquipmentsAdapter.ViewHolder holder,final int position) {

        Equipments equip = equipList.get(position);
        holder.title.setText(equip.getEquip_name());
        holder.tag_no.setText(equip.getTag_no());

    }


    @Override
    public int getItemCount() {
        return equipList.size();
    }


    /*private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity,ProjectDetailActivity.class);
                v.getContext().startActivity(i);

            }
        };
    }*/


   /* private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }*/
}