package com.extremecoder.productservice.enums;

public enum ActiveStatus {
    DELETED(0),
    ACTIVE(1),
    INACTIVE(2);

    private int value;

    ActiveStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
