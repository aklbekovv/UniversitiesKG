package com.flaterlab.uskg.screens.main.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.models.University;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UniversitiesRVAdapter extends
        RecyclerView.Adapter<UniversitiesRVAdapter.UniversityViewHolder> {

    private Context context;
    private List<University> universities = new ArrayList<>();
    private OnUniversityClickListener onUniversityClickListener;

    @NonNull
    @Override
    public UniversityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }

        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_university, parent, false);

        return new UniversityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversityViewHolder holder, int position) {
        University university = universities.get(position);
        holder.tvName.setText(university.getName());
        holder.tvAddress.setText(university.getCampus().get(0).getAddress());

        String iconPath = university.getIconPath();
        if (iconPath != null && !iconPath.isEmpty()) {
            try {
                Drawable icon = Drawable.createFromStream(context.getAssets().open(iconPath), null);
                holder.ivIcon.setImageDrawable(icon);
            } catch (IOException ignored) {
            }
        }
    }

    @Override
    public int getItemCount() {
        return universities.size();
    }

    public void updateUniversities(List<University> universities) {
        this.universities = universities;
        notifyDataSetChanged();
    }

    public void setOnUniversityClickListener(OnUniversityClickListener listener) {
        onUniversityClickListener = listener;
    }

    public interface OnUniversityClickListener {
        void onClick(University university);
    }

    class UniversityViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvName, tvAddress;

        UniversityViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);

            itemView.setOnClickListener(view -> {
                if (onUniversityClickListener != null) {
                    onUniversityClickListener.onClick(universities.get(getAdapterPosition()));
                }
            });
        }
    }
}
