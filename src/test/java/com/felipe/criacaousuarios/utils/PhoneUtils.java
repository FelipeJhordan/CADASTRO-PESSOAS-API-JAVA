package com.felipe.criacaousuarios.utils;


import com.felipe.criacaousuarios.dto.request.PhoneDTO;
import com.felipe.criacaousuarios.entity.Phone;
import com.felipe.criacaousuarios.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "(31)55555-4444";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}