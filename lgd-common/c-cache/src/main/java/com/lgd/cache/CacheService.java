package com.lgd.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/5 12:05
 */
@Service
public class CacheService {

    private static final String PREFIX_LGD = "lgd:";
    private static final Duration TTL = Duration.ofMinutes(30L);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(PREFIX_LGD + key);
    }

    public void put(String key, Object value) {
        redisTemplate.opsForValue().set(PREFIX_LGD + key, value, TTL);
    }

    public void put(String key, Object value, int minutes) {
        redisTemplate.opsForValue().set(PREFIX_LGD + key, value, Duration.ofMinutes(minutes));
    }

    public long incr(String key) {
        return redisTemplate.opsForValue().increment(PREFIX_LGD + key, 1);
    }

    public long incr(String key, long factor) {
        if (factor < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(PREFIX_LGD + key, factor);
    }

    public Boolean exists(String key) {
        return redisTemplate.hasKey(PREFIX_LGD + key);
    }

    public Boolean expire(String key) {
        return redisTemplate.expire(PREFIX_LGD + key, Duration.ZERO);
    }
}
