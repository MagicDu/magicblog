package cn.magicdu.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("cn.magicdu.blog.dao")
@EnableScheduling
public class MagicblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicblogApplication.class, args);
	}
}
