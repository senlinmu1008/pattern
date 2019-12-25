# proxy代理模式
可以通过代理对象对目标对象的操作前后增强处理，比如日志记录，事务控制等。
## 静态代理
* 目标类已实现1个接口
* 创建1个切面类，封装增强逻辑
* 创建代理类实现和目标类同样的接口，构造方法传入目标对象
* 代理类重写接口方法，目标对象调用目标方法前后调用切面增强处理
* 创建代理对象执行目标方法

```Java
@PostMapping("/static")
public void staticProxy() {
    // 目标对象
    DBService target = new DBServiceImpl();
    // 通过目标对象获取代理对象
    DBServiceImplProxy proxy = new DBServiceImplProxy(target);
    // 通过代理对象执行目标方法
    proxy.add();
}
```

##### 缺点
如果要对多个目标类进行功能扩展，且目标类实现的接口都不一样，需要编写多个代理类来实现。

<br/>

## 动态代理
* 目标类已实现1个接口
* 创建1个切面类，封装增强逻辑
* 创建代理处理类实现InvocationHandler接口，同时构造方法传入目标对象
* 代理处理类重写invoke方法，目标对象调用目标方法前后调用切面增强处理（用Method对象调用目标方法）
* 通过`Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)`方法来创建代理对象并执行目标方法

```Java
@Override
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    logAspect.doBefore();
    // 执行目标方法
    Object result = method.invoke(target, args);
    logAspect.doAfter();
    return result;
}
```

```Java
@PostMapping("/dynamic")
public void dynamicProxy() {
    // 目标对象
    DBService target = new DBServiceImpl();
    // 目标对象的类对象
    Class<? extends DBService> clazz = target.getClass();
    // 通过虚拟机底层机制获取代理对象
    DBService proxy = (DBService) Proxy.newProxyInstance(
            clazz.getClassLoader(),
            clazz.getInterfaces(),
            new ProxyHandler(target));
    proxy.delete();
}
```

##### 优点
无论是静态代理还是动态代理，都需要通过目标对象来执行目标方法，只不过在执行前后增加了处理逻辑。由于使用动态代理时执行目标方法并非传统方式调用而是用Method对象的invoke方法，所以动态代理所维护的目标对象可以是Object任意类型。
也就是说相比静态代理来的更加灵活，对于不同目标类实现不同接口的情况，都可以使用1个代理处理类来处理



