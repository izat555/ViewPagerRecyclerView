package com.example.exhibitmoduleapp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.exhibitmoduleapp.R;
import com.example.model.Exhibit;

import java.util.List;

public class ExhibitsAdapter extends RecyclerView.Adapter<ExhibitsAdapter.ExhibitHolder> {
    private Context mContext;
    private List<Exhibit> mExhibitList;

    class ExhibitHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ViewPager viewPager;

        public ExhibitHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            viewPager = itemView.findViewById(R.id.view_pager);
        }
    }

    public ExhibitsAdapter(Context context, List<Exhibit> exhibitList) {
        mContext = context;
        mExhibitList = exhibitList;
    }

    @NonNull
    @Override
    public ExhibitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ExhibitHolder exhibitHolder = new ExhibitHolder(view);
        return exhibitHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExhibitHolder holder, int position) {
        holder.tvTitle.setText(mExhibitList.get(position).getTitle());
        holder.viewPager.setAdapter(new CustomPagerAdapter(mContext, mExhibitList.get(position).getImages()));
    }

    @Override
    public int getItemCount() {
        return mExhibitList.size();
    }
}
