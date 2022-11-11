package com.mobile.sungbo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.sungbo.models.ItemModel;
import com.mobile.sungbo.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> implements Filterable {
    private List<ItemModel> mDataList;
    private List<ItemModel> mDataListAll;


    public ItemAdapter(List<ItemModel> items) {
        mDataList = items;
        mDataListAll = new ArrayList<>(items);
    }

    private onItemListener mListener;
    public void setOnClickListener(onItemListener listener) {
        mListener = listener;
    }

    public void dataSetChanged(List<ItemModel> exampleList) {
        mDataList = exampleList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,
                parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position) {
        ItemModel currentItem = mDataList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView1.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
        holder.textview3.setText(currentItem.getText3());
        if (mListener != null){
            final int pos = position;
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ItemModel> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDataListAll);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ItemModel item : mDataListAll) {
                    //TODO filter 대상 setting
                    if (item.getText2().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    if (item.getText1().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    if (item.getText3().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }

                }
            }
            List<ItemModel> filteredList2 = new ArrayList<>();

            for(int i =0; i<filteredList.size();i++){
                if(!filteredList2.contains(filteredList.get(i))){
                    filteredList2.add(filteredList.get(i));
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList2;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mDataList.clear();
            mDataList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textview3;
        TextView textView4;
        TextView textView5;
        TextView textView6;


        ItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView1 = itemView.findViewById(R.id.factory_name);
            textView2 = itemView.findViewById(R.id.insurance);
            textview3 = itemView.findViewById(R.id.kind_of_car);
        }
    }

    public interface onItemListener {
        void onItemClicked(int position);
        //void onItemClicked(ItemModel model); 모델값을 넘길수 있음
        //다른버튼도 정의할 수 있음 onShareButtonClicked(int position);
    }
}
