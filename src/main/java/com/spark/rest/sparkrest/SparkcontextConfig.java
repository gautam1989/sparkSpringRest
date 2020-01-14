package com.spark.rest.sparkrest;

import javax.annotation.PostConstruct;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.springframework.stereotype.Component;

@Component
public class SparkcontextConfig {
    
    SparkContext sparkcontext;

    @PostConstruct
    public void init(){
        SparkConf sparkConf = new SparkConf()
      // .setJars(Array(SparkContext.jarOfClass(this.getClass).get))
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("spark.scheduler.mode", "FAIR");
      sparkcontext = new SparkContext("local[2]", "TestSparkJettyServer", sparkConf);
    }

}