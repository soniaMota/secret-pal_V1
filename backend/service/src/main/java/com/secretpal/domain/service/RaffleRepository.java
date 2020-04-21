package com.secretpal.domain.service;

import com.secretpal.domain.model.Raffle;
import com.secretpal.domain.model.User;

public interface RaffleRepository {

    void createRaffle(Raffle raffle);

    User getUser1();

    User getUser2();
}
