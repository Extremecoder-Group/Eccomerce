package com.extremecoder.productservice.utils;

public final class UrlConstraint {

    private UrlConstraint() {
    }

    private static final String VERSION = "/v1";
    private static final String API = "/api";

    public static class ProductManagement {
        public static final String ROOT = VERSION + API + "/product";
        public static final String DELETE = "/{productId}";
        public static final String GET = "/{productId}";
        public static final String PUT = "/{productId}";
    }
}
