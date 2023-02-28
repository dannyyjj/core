package com.danny.core.beanfind;

import com.danny.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Junit5 부터는 public 필요 없음
class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // iter + Tab = 리스트 형태가 있으면 자동으로 for문 완성해줌
        for (String beanDefinitionName : beanDefinitionNames) {
            Object been = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " / object = " + been);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
           BeanDefinition beanDefinition =  ac.getBeanDefinition(beanDefinitionName);

            // Role ROLE_APPLICATION - 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE - 스프링 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("Name = " + beanDefinitionName);
                System.out.println("object = " + bean);
            }
        }
    }
}
