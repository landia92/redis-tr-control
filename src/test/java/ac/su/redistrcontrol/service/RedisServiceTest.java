package ac.su.redistrcontrol.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisServiceTest {

    @Autowired
    StringRedisTemplate redisTemplateDb1;

    @Test
    public void set(){
        redisTemplateDb1.opsForValue().set("hidd","hahahaha");
    }

}