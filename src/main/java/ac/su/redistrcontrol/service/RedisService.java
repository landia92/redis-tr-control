package ac.su.redistrcontrol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final StringRedisTemplate redisTemplateDb0;

    public void set(){
        redisTemplateDb0.opsForValue().set("hi","hahahaha");
    }
}
