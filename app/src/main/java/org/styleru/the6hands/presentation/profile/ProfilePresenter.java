package org.styleru.the6hands.presentation.profile;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.styleru.the6hands.domain.entities.Apartment;
import org.styleru.the6hands.domain.interactors.UserInfoInteractor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ProfilePresenter extends MvpPresenter<ProfileView> {

    private final UserInfoInteractor userInfoInteractor;
    private final List<Apartment> apartments = new ArrayList<>();

    @Inject
    ProfilePresenter(UserInfoInteractor userInfoInteractor) {
        this.userInfoInteractor = userInfoInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Disposable disposable = userInfoInteractor.getUserFromVk()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> getViewState().setUser(user),
                        e -> {}
                );

        apartments.add(new Apartment(1,  "Some address", "Some station"));
        apartments.add(new Apartment(1,  "Some address", "Some station"));
        apartments.add(new Apartment(1,  "Some address", "Some station"));
        apartments.add(new Apartment(1,  "Some address", "Some station"));

        getViewState().showApartments(apartments);
    }
}
