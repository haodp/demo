package com.chen.ff;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

/**
 * 
 * @author haichen 
 * 快速失败
 *
 */
public class FailFast {

    @Test
    public void run() {
        List<Integer> list = new ArrayList<Integer>();
//        List<Integer> list = new CopyOnWriteArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (Integer data : list) {
            System.out.println("data is: " + data);
            list.add(10);// ConcurrentModificationException
        }
        
    }

}
