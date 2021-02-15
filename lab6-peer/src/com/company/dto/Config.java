package com.company.dto;

import com.company.Function;

final public class Config {
    public static final String ip = "127.0.0.1";
    public static final Integer port = 33091;
    public static final Function fn = (x) -> x*2-3;

    private Config(){}
}
