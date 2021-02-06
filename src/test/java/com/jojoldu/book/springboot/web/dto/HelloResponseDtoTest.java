package com.jojoldu.book.springboot.web.dto;


import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name); // assertj라는 테스트 검증 라이브러리, 메소드 인자로 받음ㅁ, 메소드 체이님
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
