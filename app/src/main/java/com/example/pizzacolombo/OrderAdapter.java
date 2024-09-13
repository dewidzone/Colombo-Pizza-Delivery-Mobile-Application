package com.example.pizzacolombo;


import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    List<Model> modelList;
    Context context;

    public OrderAdapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {



        String nameofitem = modelList.get(position).getmItemName();
        String descriptionofitem = modelList.get(position).getmItemDetail();
        int images = modelList.get(position).getmItemPhoto();

        holder.mItemName.setText(nameofitem);
        holder.mItemDescription.setText(descriptionofitem);
        holder.imageView.setImageResource(images);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {



        TextView mItemName, mItemDescription;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            mItemName = itemView.findViewById(R.id.ItemName);
            mItemDescription = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.ItemImage);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {



            int position = getAdapterPosition();

            if (position == 0) {
                Intent intent = new Intent(context, InfoActivity.class);
                context.startActivity(intent);
            }

            if (position == 1) {
                Intent intent2 = new Intent(context, SausagePizzaActivity.class);
                context.startActivity(intent2);
            }
        }
    }
}

