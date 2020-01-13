package com.cmc.order.rest;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/ping")
public class Ping {


  @Autowired
  private Environment env;
  private static final Logger logger = LoggerFactory.getLogger(Ping.class);

  @RequestMapping()
  public String ping() {

    return "Hello world - Version 2";
  }

  @RequestMapping("/db")
  public String dbInfo() {
    String sql="select * from test";
    try {
      Connection con = DriverManager.getConnection(env.getProperty("spring.datasource.url"),
          env.getProperty("spring.datasource.username"),
          env.getProperty("spring.datasource.password"));
      ResultSet resultSet = con.prepareStatement(sql)
          .executeQuery();
      resultSet.next();
      return resultSet.getString("t");

    }catch (Exception e){
      e.printStackTrace();
    }
    return "Hello world - Version 1";
  }


}
