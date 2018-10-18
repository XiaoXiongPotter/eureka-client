package com.example.demo.web;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class MyHealthIndicator implements HealthIndicator {


	 
    private boolean up = true;
 
    @Override
    public Health health() {
    	  if (up) {  
              return new Health.Builder().withDetail("status", "up").up().build();  //自定义监控内容
          } else {  
              return new Health.Builder().withDetail("error", "client is down").down().build(); 
              } 
    }
 
    public boolean isUp() {
        return up;
    }
 
    public void setUp(boolean up) {
        this.up = up;
    }

}
