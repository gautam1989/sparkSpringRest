package com.spark.rest.sparkrest;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
  
  SparkcontextConfig sparkContextconfig;

    @Autowired
    public TestController(SparkcontextConfig sparkContextconfig) {
     this.sparkContextconfig = sparkContextconfig;
    }

    @GetMapping("/")
    public ResponseEntity<String> getData(){
      List<Integer> collection = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
      sparkContextconfig.sparkcontext.parallelize(collection);

        return new ResponseEntity<>("Hello World!", HttpStatus.OK); 
    }

}