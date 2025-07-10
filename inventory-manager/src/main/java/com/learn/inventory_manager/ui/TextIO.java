package com.learn.inventory_manager.ui;

import java.math.BigDecimal;

public interface TextIO {
    void println(Object value);
    void print(Object value);
    void printf(String format, Object... values);
    String readString(String prompt);
    boolean readBoolean(String prompt);
    int readInt(String prompt);
    Integer readInt(String prompt, boolean allowSkip);
    int readInt(String prompt, int min, int max);
    BigDecimal getBigDecimal(String prompt);
    boolean getConfirmation(String prompt);
    BigDecimal getBigDecimal(String prompt, boolean allowSkip);
}