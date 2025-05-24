package org.example.ddd.application.service.event.impl;

import org.example.ddd.application.service.event.EventAppService;
import org.example.ddd.domain.service.HiDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventAppImpl implements EventAppService {
    @Autowired
    private HiDomainService hiDomainService;

    @Override
    public String hiEvent(String who) {
        return hiDomainService.sayHi(who);
    }
}
