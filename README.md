# java基础
1. HashMap 的长度为什么是2的幂次方</br>
参考[分析地不错的文章](https://blog.csdn.net/zjcjava/article/details/78495416)</br>
结论：通过数据分析，相较于其他长度，长度为2的幂次方时，hash分布更均匀
2. filter与intercept的区别</br>
filter只是对servlet的加强，依赖servlet容器，只对请求生效。以过滤器链的形式对请求进行预处理，在调用chain.doFilter()生成响应后接着进行后续处理。需要实现javax.servlet.Filter接口，必须重写doFilter()方法。</br>
intercept是AOP的一种实现策略，用于某些方法或字段在被访问前后加入某些操作（增强），不依赖servlet容器，针对的范围广。
Filter是基于函数回调的（责任链），而Interceptor则是基于Java反射的（代理）。</br>
3. redis分布式锁的写法[参考](https://www.cnblogs.com/linjiqin/p/8003838.html)</br>
