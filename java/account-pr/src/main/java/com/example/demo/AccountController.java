package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Controller()
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountDao dao;

    public AccountController(AccountDao dao) {
        this.dao = dao;
    }

    // get all accounts
    @GetMapping
    public List<Account> accounts() {
        return dao.getAllAccounts();
    }

    // get all account names
    @GetMapping
    public List<String> accountNames() {
        return dao.getAllAccounts().stream()
                .map(Account::getName)
                .map(String::toUpperCase)
                .collect(toList());
    }

    // get all accounts
    @PostMapping
    public Account createAccount(Account account) {
        return dao.createAccount(account);
    }
}
