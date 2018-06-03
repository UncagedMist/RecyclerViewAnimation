package kk.techbytecare.recyclerviewanimation.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kk.techbytecare.recyclerviewanimation.R;
import kk.techbytecare.recyclerviewanimation.ViewHolder.SimpleViewHolder;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    List<Integer> dataSource;

    public SimpleAdapter() {
        dataSource = new ArrayList<>();

        for (int i = 0; i <= 10 ; i++) {
            dataSource.add(i);
        }
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout,parent,false);

        return new SimpleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        holder.textView.setText(String.valueOf(dataSource.get(position)));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
