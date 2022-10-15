package com.bolivariano.microservice.datacliente.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StandardDateTimeFormat {
    
    public static String makeCurrentTime (LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
