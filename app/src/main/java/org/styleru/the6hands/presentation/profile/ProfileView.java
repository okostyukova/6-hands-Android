package org.styleru.the6hands.presentation.profile;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import org.styleru.the6hands.domain.entities.Apartment;
import org.styleru.the6hands.domain.entities.User;

import java.util.List;

public interface ProfileView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void setUser(User user);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showMessage(String message);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showApartments(List<Apartment> apartments);
}
