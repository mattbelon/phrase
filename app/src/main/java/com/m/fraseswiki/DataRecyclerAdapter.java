package com.m.fraseswiki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m.fraseswiki.model.items.ItemRowsItem;


import java.util.List;

public class DataRecyclerAdapter extends RecyclerView.Adapter<DataRecyclerAdapter.MyViewHolder> {

    private final Context context;
    public  List<ItemRowsItem> itemList;
   DataRecyclerAdapter(Context context){
       this.context = context;
   }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_rv, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItemRowsItem item = itemList.get(position);
        String text = "";
        text= item.getObraId()+"\n"+"tema id "+item.getAutor()+"\n"+item.getFrase()+"\n\n";
        holder.tv.setText(text);
    }

    @Override
    public int getItemCount() {
        return itemList!=null? itemList.size():0;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ItemRowsItem item = itemList.get(getAdapterPosition());
                    Toast.makeText(context, "Clicked on id "+item.getId(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    public void putList(List<ItemRowsItem> newList){
        itemList=newList;
        notifyDataSetChanged();
    }

}
