package com.littlepage.service.impl;

import com.littlepage.dao.CommonDao;
import com.littlepage.entity.SystemLog;
import com.littlepage.service.SystemLogService;

import java.util.List;

public class SystemLogServiceImpl implements SystemLogService {
    CommonDao<SystemLog> systemLogDao = new CommonDao<>();

    @Override
    public boolean addLog(SystemLog systemLog) {
        return systemLogDao.insert(systemLog);
    }

    @Override
    public List<SystemLog> showLogs(int start, int count) {
        return systemLogDao.selectBatchDesc(SystemLog.class, start, count, "time");
    }

    @Override
    public int makePageList(int pageSize) {
        int size = systemLogDao.count("t_systemLog");
        return size / pageSize;
    }
}

