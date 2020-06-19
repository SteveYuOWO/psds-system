package com.littlepage.util;

import com.littlepage.entity.SystemLog;
import com.littlepage.service.SystemLogService;
import com.littlepage.service.impl.SystemLogServiceImpl;

public class SystemLogUtil {
    static SystemLogService systemLogService = new SystemLogServiceImpl();

    public static void systemLogProcess(String remoteAddr, String loginName, String type, String time, String comment) {
        systemLogService.addLog(new SystemLog(remoteAddr, loginName, type, time, comment));
    }
}
