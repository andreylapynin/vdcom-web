package com.vdcom.vdcomtest.service;

import com.vdcom.vdcomtest.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {

    Account create(Account account);

    Optional<Account> findById(long id);

    Account update(Account account);

    void deleteById(long id);

    List<Account> getAll();

}