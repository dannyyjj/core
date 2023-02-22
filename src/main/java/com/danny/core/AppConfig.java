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

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                DiscountPolicy());
    }

    private DiscountPolicy DiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
