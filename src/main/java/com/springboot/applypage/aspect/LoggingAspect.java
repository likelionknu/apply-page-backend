package com.springboot.applypage.aspect;

import com.springboot.applypage.data.entity.BaseApplication_Q;
import com.springboot.applypage.data.entity.ChangeHistory;
import com.springboot.applypage.data.repository.ChangeHistoryRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Autowired
    private ChangeHistoryRepository changeHistoryRepository;

    @AfterReturning(value = "execution(* com.springboot.applypage.service.BaseApplication_QService.updateBaseApplication_Q(..)) && args(baseApplication_Q)", returning = "result")
    public void logAfterUpdate(BaseApplication_Q baseApplication_Q, BaseApplication_Q result) {
        changeHistoryRepository.save(new ChangeHistory(result.getQ_id()));
    }
}
//스프링 부트에서 updateBaseApplication_Q 메소드가 실행될 때마다 update(수정) 기록을 테이블에 저장

