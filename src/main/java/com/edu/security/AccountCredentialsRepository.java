package com.edu.security;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountCredentialsRepository  extends PagingAndSortingRepository<AccountCredentials, Long> {

    AccountCredentials findByUsername(String userName);
}
