package com.danny.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);
        StatefulService statefulService01 = ac.getBean(StatefulService.class);
        StatefulService statefulService02 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        int userA = statefulService01.order("userA", 10000);
        //ThreadB : B사용자 10000원 주문
        int userB = statefulService02.order("userB", 20000);


        // ThreadA : 사용자A 주문 금액 조회
//        int price = statefulService01.getPrice();
        System.out.println("price = " + userA);

//        assertThat(statefulService01.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }

}