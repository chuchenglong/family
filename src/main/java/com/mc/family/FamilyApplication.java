package com.mc.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description 主程序
 * @author ChenglongChu
 * @create 2017/12/13 17:49
**/
@SpringBootApplication
@ComponentScan(basePackages = "com.mc.family")
public class FamilyApplication {
	/**
	 * @description 主函数
	 * @param args 主函数参数
	 * @author ChenglongChu
	 * @create 2017/12/14 16:02
	**/
	public static void main(String[] args) {
		SpringApplication.run(FamilyApplication.class, args);
	}
}
