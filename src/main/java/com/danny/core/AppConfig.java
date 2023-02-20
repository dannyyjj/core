package com.danny.core;

import com.danny.core.discount.FixDiscountPolicy;
import com.danny.core.member.MemberService;
import com.danny.core.member.MemberServiceImpl;
import com.danny.core.member.MemoryMemberRepository;
import com.danny.core.order.OrderService;
import com.danny.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), FixDiscountPolicy());
    }

    private FixDiscountPolicy FixDiscountPolicy() {
        return new FixDiscountPolicy();
    }
}
