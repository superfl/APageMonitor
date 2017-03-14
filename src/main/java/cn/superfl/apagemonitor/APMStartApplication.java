/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author superfl
 * @version $Id: APMStartApplication.java, v 0.1 2017-03-13 下午9:46 superfl Exp $$
 */
@EnableAutoConfiguration
@SpringBootApplication
public class APMStartApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(APMStartApplication.class, args);
    }
}