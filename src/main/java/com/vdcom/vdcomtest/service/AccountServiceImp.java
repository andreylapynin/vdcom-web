package com.vdcom.vdcomtest.service;

import com.vdcom.vdcomtest.entity.Account;
import com.vdcom.vdcomtest.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class AccountServiceImp implements AccountService {
    private AccountRepository accountRepository;

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findById(long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteById(long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

}