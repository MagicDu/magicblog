package cn.magicdu.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.magicdu.blog.dao")
public class MagicblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicblogApplication.class, args);
	}
}
