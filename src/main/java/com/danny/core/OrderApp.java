package com.danny.core;

import com.danny.core.member.Grade;
import com.danny.core.member.Member;
import com.danny.core.member.MemberService;
import com.danny.core.member.MemberServiceImpl;
import com.danny.core.order.Order;
import com.danny.core.order.OrderService;
import com.danny.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
