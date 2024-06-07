package com.example.springredisopenapi.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

class StringUtilsTest {

    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    @ParameterizedTest
    @ValueSource(strings = { "", "  " })
    void isBlank_emptyAndWhitespaceString(final String value) {

        assertThat(StringUtils.isBlank(value)).isTrue();
    }

    @Test
    void isBlank_nonBlankString() {

        final String value = PODAM_FACTORY.manufacturePojo(String.class);
        assertThat(StringUtils.isBlank(value)).isFalse();
    }

    @Test
    void isBlank_nullValue() {

        final String value = null;
        assertThat(StringUtils.isBlank(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "  " })
    void isNotBlank_emptyAndWhitespaceString(final String value) {

        assertThat(StringUtils.isNotBlank(value)).isFalse();
    }

    @Test
    void isNotBlank_nullValue() {

        final String value = null;
        assertThat(StringUtils.isNotBlank(value)).isFalse();
    }

    @Test
    void isNotBlank_nonBlankString() {

        final String value = PODAM_FACTORY.manufacturePojo(String.class);
        assertThat(StringUtils.isNotBlank(value)).isTrue();
    }
    
}
