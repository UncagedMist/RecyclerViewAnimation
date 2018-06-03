package kk.techbytecare.recyclerviewanimation.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kk.techbytecare.recyclerviewanimation.R;

public class SimpleViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public SimpleViewHolder(View itemView) {
        super(itemView);

        textView= itemView.findViewById(R.id.textView);
    }
}
