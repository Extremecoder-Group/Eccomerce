package com.extremecoder.productservice.utils;

public final class UrlConstraint {

    private UrlConstraint() {
    }

    private static final String API = "/api";
    private static final String VERSION = "/v1";

    public static class ProductManagement {
        public static final String ROOT = API + VERSION + "/products";
        public static final String DELETE = "/{productId}";
        public static final String GET = "/{productId}";
        public static final String PUT = "/{productId}";
    }
}
