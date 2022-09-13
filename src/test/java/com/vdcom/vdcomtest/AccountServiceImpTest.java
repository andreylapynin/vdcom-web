package com.vdcom.vdcomtest;

import com.vdcom.vdcomtest.entity.Account;
import com.vdcom.vdcomtest.repository.AccountRepository;
import com.vdcom.vdcomtest.service.AccountServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountServiceImpTest {
    @InjectMocks
    private AccountServiceImp accountServiceImp;
    @Mock
    private AccountRepository accountRepository;

    private Account createAccountForTest() {
        return Account.builder()
                .name("Ilya")
                .password("123")
                .build();
    }

    @Test
    public void createAccountTest() {
        Account account = createAccountForTest();
        when(accountRepository.save(account)).thenReturn(account);
        assertEquals(account, accountServiceImp.create(account));
    }

    @Test
    public void findByIdTest() {
        Account account = createAccountForTest();
        when(accountRepository.findById(1L)).thenReturn(Optional.ofNullable(account));
        assertEquals(Optional.ofNullable(account), accountServiceImp.findById(1L));
    }

    @Test
    public void updateAccountTest() {
        Account account = createAccountForTest();
        when(accountRepository.save(account)).thenReturn(account);
        assertEquals(account, accountServiceImp.update(account));
    }

    @Test
    public void getAllTest() {
        List<Account> accounts = new ArrayList<>();
        Account account = createAccountForTest();
        accounts.add(account);
        when(accountRepository.findAll()).thenReturn(accounts);
        assertEquals(accounts, accountServiceImp.getAll());
    }

}