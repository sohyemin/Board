package study.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**") // 모든 요청에 대한 CORS 허용
                .allowedOrigins("http://localhost:3001") //허용할 출처 : 리액트 url 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") //OPTIONS 추가 : preflight 사용
                .allowedHeaders("*")    //모든 헤더 허용
                .allowCredentials(true);    //쿠키를 주고 받게 설정

    }
}
