package com.ssm.dao.cache;

import com.ssm.entity.Seckill;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JedisPool jedisPool;

    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    public RedisDao(String host, int port) {
        jedisPool = new JedisPool(host, port);
    }

    public Seckill getSeckill(long seckillId) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String key = "Seckill:" + seckillId;
            byte[] bytes = jedis.get(key.getBytes());
            if (bytes != null) {
                Seckill seckill = schema.newMessage();
                ProtobufIOUtil.mergeFrom(bytes, seckill, schema);
                return seckill;
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return null;
    }

    public String putSeckill(Seckill seckill) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String key = "Seckill:" + seckill.getSeckillId();
            byte[] bytes = ProtobufIOUtil.toByteArray(seckill, schema,
                    LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
            int timeout = 60 * 60;
            String result = jedis.setex(key.getBytes(), timeout, bytes);
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return null;
    }
}
