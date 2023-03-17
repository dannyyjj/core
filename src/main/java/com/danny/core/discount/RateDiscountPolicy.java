package com.danny.core.discount;

import com.danny.core.member.Grade;
import com.danny.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int dicountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * dicountPercent / 100;
        } else {
            return 0;
        }
    }
}
