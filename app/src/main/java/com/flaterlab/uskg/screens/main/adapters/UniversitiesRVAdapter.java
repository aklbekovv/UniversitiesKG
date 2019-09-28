package com.flaterlab.uskg.screens.main.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.models.University;
import com.flaterlab.uskg.screens.info.InfoActivity;
import com.flaterlab.uskg.util.CommonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UniversitiesRVAdapter extends
        RecyclerView.Adapter<UniversitiesRVAdapter.UniversityViewHolder> {

    private Context context;
    private List<University> universities = new ArrayList<>();
    private OnUniversityClickListener onUniversityClickListener;
    private boolean withOrderNumber = false;

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
        holder.tvAddress.setText(university.getAddress());

        if (withOrderNumber) {
            holder.tvOrderNum.setText(
                    String.format(context.getString(R.string.order_number), position + 1));
            holder.tvOrderNum.setVisibility(View.VISIBLE);
            holder.tvAddress.setVisibility(View.GONE);
        }

        String iconPath = university.getIconPath();
        if (iconPath != null && !iconPath.isEmpty()) {
            try {
                holder.ivIcon.setImageDrawable(CommonUtils.getIcon(context, university.getIconPath()));
            } catch (IOException ignored) {
            }
        }
    }

    @Override
    public int getItemCount() {
        return universities.size();
    }

    public void updateUniversities(List<University> universities, boolean showOrder) {
        withOrderNumber = showOrder;
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
        TextView tvOrderNum, tvName, tvAddress;

        UniversityViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvOrderNum = itemView.findViewById(R.id.tv_order_number);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);

            itemView.setOnClickListener(view -> {
                if (onUniversityClickListener != null) {
                    onUniversityClickListener.onClick(universities.get(getAdapterPosition()));
                }
                startInfoActivity(universities.get(getAdapterPosition()));
            });
        }

        private void startInfoActivity(University university) {
            Intent intent = new Intent(context, InfoActivity.class);
            intent.putExtra(InfoActivity.UNIVERSITY_ID, university.getId());
            context.startActivity(intent);
        }
    }
}
