package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.UpdateInResultDto;

public interface UserService {
    UpdateInResultDto updateUserRole(String token, String newRole, String userEmail) throws RuntimeException;;
}
