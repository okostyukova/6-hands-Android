package org.styleru.the6hands.presentation.profile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.styleru.the6hands.R;
import org.styleru.the6hands.domain.entities.Apartment;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ApartmentAdapter extends RecyclerView.Adapter<ApartmentAdapter.ViewHolder>{

    private Context context;
    private List<Apartment> apartments = new ArrayList<>();

    @Inject
    ApartmentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_item, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Apartment apartment = apartments.get(i);

        viewHolder.metroStation.setText(apartment.getMetroStation());
//        viewHolder.numberOfRooms.setText(String.valueOf(apartment.getNumberOfRooms()));
//        viewHolder.flatPrice.setText(String.valueOf(apartment.getNumberOfRooms()));
//        viewHolder.numberOfWatches.setText(String.valueOf(apartment.getNumberOfWatches()));
//        viewHolder.numberOfNewWatches.setText(String.valueOf(apartment.getNumberOfNewWatches()));
    }

    @Override
    public int getItemCount() {
        return apartments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.edit_button)
        TextView editApartmentButton;

        @BindView(R.id.flat_photo)
        ImageView apartmentPhoto;

        @BindView(R.id.line_color)
        View lineColor;

        @BindView(R.id.metro_station)
        TextView metroStation;

        @BindView(R.id.number_of_rooms)
        TextView numberOfRooms;

        @BindView(R.id.flat_price)
        TextView flatPrice;

        @BindView(R.id.number_of_watches)
        TextView numberOfWatches;

        @BindView(R.id.new_watches)
        TextView numberOfNewWatches;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.apartments_item)
        void onClickApartment() {

        }
    }

    public void setApartments(List<Apartment> data) {
        this.apartments.addAll(data);
        notifyDataSetChanged();
    }
}
