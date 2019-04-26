package org.styleru.the6hands.presentation.profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikhaellopez.circularimageview.CircularImageView;

import org.styleru.the6hands.R;
import org.styleru.the6hands.SixHandsApplication;
import org.styleru.the6hands.domain.entities.Apartment;
import org.styleru.the6hands.domain.entities.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends MvpAppCompatFragment implements ProfileView {

    @BindView(R.id.profile_name)
    TextView name;

    @BindView(R.id.profile_pic)
    ImageView profilePic;

    @BindView(R.id.flat_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.change_profile_data)
    TextView changeProfileData;

    @BindView(R.id.vk_button)
    View vkButton;

    @BindView(R.id.facebook_button)
    View fbButton;

    @BindView(R.id.fab)
    FloatingActionButton addApartmentButton;

    private ApartmentAdapter adapter;

    @Inject
    @InjectPresenter
    ProfilePresenter profilePresenter;

    @ProvidePresenter
    ProfilePresenter provideProfilePresenter(){
        return profilePresenter;
    }

    @Override
    public void onAttach(Context context) {
        SixHandsApplication.getAppComponent().inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);

        init();

        return view;
    }

    @Override
    public void setUser(User user) {
        name.setText(user.getFirstName());
        Glide.with(this).
                load(user.getPhoto200Url())
                .apply(RequestOptions.circleCropTransform())
                .into(profilePic);
    }

    @OnClick(R.id.change_profile_data)
    void onChangeDataClicked(){

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showApartments(List<Apartment> apartments) {
        adapter.setApartments(apartments);
    }

    public void init() {
        adapter =  new ApartmentAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    addApartmentButton.show();
                } else {
                    addApartmentButton.hide();
                }
            }
        });
        Glide.with(this)
                .load(R.drawable.flat)
                .apply(RequestOptions.circleCropTransform())
                .into(profilePic);
    }

    @OnClick(R.id.change_profile_data)
    public void editData() {

    }

    @OnClick(R.id.vk_button)
    public void onVkButtonClicked() {

    }

    @OnClick(R.id.facebook_button)
    public void onFbButtonClicked() {

    }

    @OnClick(R.id.fab)
    public void onFABClicked() {

    }
}
