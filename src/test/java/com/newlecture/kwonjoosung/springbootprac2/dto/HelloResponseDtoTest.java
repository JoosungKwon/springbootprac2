package com.newlecture.kwonjoosung.springbootprac2.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void return_hello() {

        //given
        String name = "주성";
        int amount = 100;
        //when
        HelloResponseDto hello = new HelloResponseDto(name,amount);
        //then
        assertThat(hello.getName()).isEqualTo(name);
        assertThat(hello.getAmout()).isEqualTo(amount);
    }
}
