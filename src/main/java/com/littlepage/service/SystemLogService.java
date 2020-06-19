package com.littlepage.service;

import com.littlepage.entity.SystemLog;

import java.util.List;

public interface SystemLogService {
    boolean addLog(SystemLog systemLog);

    List<SystemLog> showLogs(int start, int count);

    int makePageList(int i);
}
