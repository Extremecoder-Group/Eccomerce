package com.extremecoder.fileservice.enums;

public enum ActiveStatus {
    ACTIVE(1),
    DELETED(0);

    private int value;

    ActiveStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
