# SpringBoot+Redis 实现Session共享

1. 依赖
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.session</groupId>
  <artifactId>spring-session-data-redis</artifactId>
</dependency>
```
2. 开启@EnableRedisHttpSession

```
/**
 * 事件监听不是必要的
 * 当事件触发时，带有监听器的实例，都会收到消息
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
    /**
     * Redis内session过期事件监听
     */
    @EventListener
    public void onExpired(SessionExpiredEvent expiredEvent) {
        String sessionId = expiredEvent.getSessionId();
        System.out.println(sessionId+" session expired");
    }
    /**
     * Redis内session删除事件监听
     */
    @EventListener
    public void onDeleted(SessionDeletedEvent deletedEvent) {
        String sessionId = deletedEvent.getSessionId();
        System.out.println(sessionId+" session deleted");
    }
    /**
     * Redis内session保存事件监听
     */
    @EventListener
    public void onCreated(SessionCreatedEvent createdEvent) {
        String sessionId = createdEvent.getSessionId();
        System.out.println(sessionId+" session created");
    }
}
```
