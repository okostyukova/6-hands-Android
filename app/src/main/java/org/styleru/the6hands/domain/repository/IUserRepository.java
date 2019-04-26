package org.styleru.the6hands.domain.repository;


import org.styleru.the6hands.domain.entities.Apartment;
import org.styleru.the6hands.domain.entities.User;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface IUserRepository {

    Single<User> getUserFromVk();
    Observable<Apartment> getApartments(int userId);
}
