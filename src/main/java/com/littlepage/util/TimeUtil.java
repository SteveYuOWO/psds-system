package com.littlepage.util;

import java.time.LocalDateTime;

public class TimeUtil {
    public static String now() {
        String now = LocalDateTime.now().toLocalDate() + " " + LocalDateTime.now().toLocalTime().toString();
        return now.split("\\.")[0];
    }
}
