package com.danny.core;

import com.danny.core.discount.DiscountPolicy;
import com.danny.core.discount.FixDiscountPolicy;
import com.danny.core.discount.RateDiscountPolicy;
import com.danny.core.member.MemberRepository;
import com.danny.core.member.MemberService;
import com.danny.core.member.MemberServiceImpl;
import com.danny.core.member.MemoryMemberRepository;
import com.danny.core.order.OrderService;
import com.danny.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 객체를 생성하고 관리하면서 의존관계를 연결해 주는 IoC, DI 컨테이너
@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository

    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean(name = "possibleChangeName")
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                DiscountPolicy());
    }
    @Bean
    public DiscountPolicy DiscountPolicy() {

//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
