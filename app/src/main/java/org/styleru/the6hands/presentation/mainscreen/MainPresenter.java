package org.styleru.the6hands.presentation.mainscreen;

import android.os.Parcelable;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.styleru.the6hands.R;
import org.styleru.the6hands.Screens;
import org.styleru.the6hands.domain.entities.User;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Router router;

    @Inject
    MainPresenter(Router router) {
        this.router = router;
    }

    void onStart(Parcelable user){
        router.replaceScreen(new Screens.ProfileScreen(user));
        getViewState().setChecked(R.id.nav_profile);
    }


    //Place navigation here
    public boolean onNavClicked(int id){
        switch (id) {
            case R.id.nav_list:
                getViewState().showMessage("Здесь пока ничего нет");
                return true;
            case R.id.nav_map:
                getViewState().showMessage("Здесь пока ничего нет");
                return true;
            case R.id.nav_dialogs:
                getViewState().showMessage("Здесь пока ничего нет");
                return true;
            case R.id.nav_profile:
                getViewState().showMessage("Здесь пока ничего нет");
                return true;
        }
        return false;
    }
}
