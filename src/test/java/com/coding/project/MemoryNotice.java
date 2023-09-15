package com.coding.project;

import com.coding.project.domain.entitiy.notices.Notices;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MemoryNotice {

    private static Map<Long, Notices> noticesMap = new HashMap<>();

    @AfterEach
    public void afterEach(){
        clearMap();
    }

    @Test
    public void NoticeMapperTest(){
        String member = "ddk";
        Assertions.assertEquals("ddk", member);
    }

    @Test
    public void timeTest(){
        System.out.println(LocalDate.now());

    }



    public void clearMap(){
        noticesMap.clear();
    }


}
