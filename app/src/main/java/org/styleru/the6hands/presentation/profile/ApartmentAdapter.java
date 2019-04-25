package org.styleru.the6hands.presentation.profile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.styleru.the6hands.R;
import org.styleru.the6hands.domain.entities.Apartment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ApartmentAdapter extends RecyclerView.Adapter<ApartmentAdapter.ViewHolder>{

    private Context context;
    private List<Apartment> apartments;
    private onItemClickListener listener;

    @Inject
    ApartmentAdapter(Context context) {
        this.context = context;
        this.apartments = new ArrayList<>();
        this.listener = new onItemClickListener() {
            @Override
            public void onItemClick(Apartment apartment) {

            }
        };
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_profile, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.apartment = apartments.get(i);

        Glide.with(viewHolder.itemView.getContext())
                .load(R.drawable.flat)
                .into(viewHolder.flatPhoto);
    }

    @Override
    public int getItemCount() {
        return apartments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private Apartment apartment;
        private ImageView flatPhoto;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.apartments_item)
        void onClickApartment() {
            if (listener != null) {
                listener.onItemClick(apartments.get(getAdapterPosition()));
            }
        }
    }

    public void setApartments(List<Apartment> data) {
        this.apartments.addAll(data);
    }
}
