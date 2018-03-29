package com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewAdapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javier.MaterialDesignApp.R;
import com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewClasses.Shopping;

import java.util.ArrayList;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder>{

    private ArrayList<Shopping> shoppings;
    Context context;

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show();
        }
    };


    // Adapter's Constructor
    public ShoppingAdapter(Context context, ArrayList<Shopping> shoppings) {
        this.shoppings = shoppings;
        this.context = context;
    }

    // Create new views. This is invoked by the layout manager.
    @Override
    public ShoppingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view by inflating the row item xml.
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        // Set strings to the views
        final TextView textViewTitle = (TextView) holder.view.findViewById(R.id.textViewItemTitle);
        final TextView textViewContent = (TextView) holder.view.findViewById(R.id.textViewItemContent);
        final ImageView imageViewImage = (ImageView) holder.view.findViewById(R.id.imageViewImage);
        textViewTitle.setText(shoppings.get(position).getName());
        textViewContent.setText(shoppings.get(position).getDescription());
        imageViewImage.setImageBitmap(BitmapFactory.decodeResource(context.getResources(),
                R.drawable.ic_map));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return shoppings.size();
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;

        public ViewHolder(View v) {
            super(v);
            view = v;
        }
    }
}
