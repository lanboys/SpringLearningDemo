package com.bing.lan.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by oopcoder at 2022/6/21 13:25 .
 */

@Service
public class BeanA {

  @Autowired
  public BeanB beanB;
}
