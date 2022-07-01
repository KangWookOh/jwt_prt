package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.dto.AccountDto;
import com.cranesch.cranewebbackend.entity.Account;
import com.cranesch.cranewebbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long>
{

}
