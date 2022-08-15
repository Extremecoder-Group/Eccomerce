package com.extremecoder.productservice.constraint;

public final class UrlConstraint {

    private UrlConstraint() {
    }

    private static final String VERSION1 = "/v1";

    public static class ProductManagement {
        public static final String ROOT = "/api" + VERSION1 + "/products";
        public static final String DELETE = "/{productId}";
        public static final String GET = "/{productId}";
        public static final String PUT = "/{productId}";
    }
}
