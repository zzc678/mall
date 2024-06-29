package com.ckzy.entrance;

import com.ckzy.dao.mapper.DepartmentMapper;
import com.ckzy.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EntranceApplication.class)
public class DepartmentTest {

    @Autowired
    private DepartmentMapper mapper;

    @Autowired
    private DepartmentService service;

    @Test
    void t1() {

    }
}
