package com.danny.core.order;

import com.danny.core.discount.DiscountPolicy;
import com.danny.core.discount.FixDiscountPolicy;
import com.danny.core.member.Member;
import com.danny.core.member.MemberRepository;
import com.danny.core.member.MemoryMemberRepository;

public class OderServiceImpl implements OrderService {

    private MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
