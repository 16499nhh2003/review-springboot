package com.example.demo.service;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.exception.LoginException;

public interface LoginService {

    public String loginAccount(LoginRequest loginDTO) throws LoginException;

    public String logoutAccount(String role, String key) throws LoginException;

}