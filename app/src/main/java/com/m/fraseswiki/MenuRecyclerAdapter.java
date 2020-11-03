package com.m.fraseswiki;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m.fraseswiki.model.menu.MenuRowsItem;
import com.m.fraseswiki.model.items.ItemRowsItem;
import com.m.fraseswiki.model.menu.MenuRowsItem;

import java.util.List;

public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter.MyViewHolder> {

    private final Context context;
    public  List<MenuRowsItem> itemList;
    MenuRecyclerAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_menu, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MenuRowsItem item = itemList.get(position);
        String text = "";
        if (item.getTema() == null){
            text= item.getAutor();
        } else {
            text= item.getTema();
            holder.tv.setText(text);
        }

        holder.tv.setText(text);
    }

    @Override
    public int getItemCount() {
        return itemList!=null? itemList.size():0;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        LinearLayout lin;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            lin=itemView.findViewById(R.id.lin);
            lin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new  Intent(context,DetailActivity.class);
                    intent.putExtra("menuid",itemList.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }


    public void putList(List<MenuRowsItem> newList){
        itemList=newList;
        notifyDataSetChanged();
    }

}
