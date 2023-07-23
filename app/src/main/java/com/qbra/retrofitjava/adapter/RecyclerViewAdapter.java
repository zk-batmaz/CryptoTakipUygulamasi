package com.qbra.retrofitjava.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qbra.retrofitjava.R;
import com.qbra.retrofitjava.model.CryptoModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {

    private ArrayList<CryptoModel> cryptoList;
    public RecyclerViewAdapter(ArrayList<CryptoModel> cryptoList) {
        this.cryptoList = cryptoList;
    }

    private String[] colors = {"#a3c1ad", "#776c76", "#d5a6bd", "#f4f4cc", "#c0e2c6", "#9e5e5b", "#f8bf85", "#f0f0f0"};

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(cryptoList.get(position), colors, position);
    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {

        TextView nameText;
        TextView priceText;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(CryptoModel cryptoModel, String[] colors, Integer position){
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]));
            nameText = itemView.findViewById(R.id.nameText);
            priceText = itemView.findViewById(R.id.priceText);

            nameText.setText(cryptoModel.currency);
            priceText.setText(cryptoModel.price);
        }
    }
}
