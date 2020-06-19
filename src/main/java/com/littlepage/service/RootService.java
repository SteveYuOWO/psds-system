package com.littlepage.service;

import com.littlepage.entity.Root;

public interface RootService {
    Root selectRootByRootAdminName(String loginName);
}
