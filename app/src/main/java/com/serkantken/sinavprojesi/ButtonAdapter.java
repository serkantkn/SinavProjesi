package com.serkantken.sinavprojesi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ViewHolder>
{
    List<ButtonModel> secenekler;
    Context context;
    ClickListener clickListener;

    public ButtonAdapter(List<ButtonModel> secenekler, Context context, ClickListener clickListener)
    {
        this.secenekler = secenekler;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.button_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        ButtonModel model = secenekler.get(position);
        holder.button.setText(model.getButtonText());
        if (model.isPressed())
        {
            holder.button.setBackground(AppCompatResources.getDrawable(context, R.drawable.selected_button_background));
            holder.button.setTextColor(context.getResources().getColor(R.color.white));
        }
        else
        {
            holder.button.setBackground(AppCompatResources.getDrawable(context, R.drawable.unselected_button_background));
            holder.button.setTextColor(context.getResources().getColor(R.color.purple_500));
        }

        holder.button.setOnClickListener(view -> clickListener.onClick(position));
    }

    @Override
    public int getItemCount()
    {
        return secenekler.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.buttonSecenek);
        }
    }
}
