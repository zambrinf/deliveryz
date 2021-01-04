package br.com.zn43.entities;

public enum OrderStatus {

    PENDING (0),
    DELIVERED (1);

    private final Integer code;

    OrderStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
