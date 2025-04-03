package com.nnd.lesson_11.service;


import com.nnd.lesson_11.entity.NND_Account;
import com.nnd.lesson_11.repository.NND_AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NND_AccountService {

    @Autowired
    private NND_AccountRepository nndAccountRepository;

    // Lấy danh sách tất cả NND_Account
    public List<NND_Account> getAllAccounts() {
        return nndAccountRepository.findAll();
    }

    // Lấy NND_Account theo ID
    public NND_Account getAccountById(Long id) {
        Optional<NND_Account> account = nndAccountRepository.findById(id);
        return account.orElse(null);
    }

    // Thêm mới NND_Account
    public NND_Account addAccount(NND_Account account) {
        return nndAccountRepository.save(account);
    }

    // Cập nhật NND_Account
    public NND_Account updateAccount(Long id, NND_Account accountDetails) {
        NND_Account account = getAccountById(id);
        if (account != null) {
            account.setUser(accountDetails.getUser());
            account.setPass(accountDetails.getPass());
            account.setName(accountDetails.getName());
            account.setEmail(accountDetails.getEmail());
            account.setPhone(accountDetails.getPhone());
            account.setAddress(accountDetails.getAddress());
            account.setStatus(accountDetails.getStatus());
            return nndAccountRepository.save(account);
        }
        return null;
    }

    // Xóa NND_Account
    public void deleteAccount(Long id) {
        nndAccountRepository.deleteById(id);
    }
}