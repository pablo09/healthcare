package com.pzeszko.healthcare.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
    @Getter
    public enum Category {
        GENERAL("GENERAL"),
        PAINKILLERS("PAINKILLERS"),
        SUPPLEMENT("SUPPLEMENT"),
        COLD("COLD");

        private final String name;
    }