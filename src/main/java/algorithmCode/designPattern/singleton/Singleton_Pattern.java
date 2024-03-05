package algorithmCode.designPattern.singleton;

/**
 * 描述：单例的多种实现
 *
 * @author BrokenColor
 * @date 2019年3月14日
 */
public class Singleton_Pattern {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 懒汉式，线程不安全
        SingletonDemo singleton = SingletonDemo.getInstance();
        singleton.print();
        //懒汉式，线程安全
        SingletonDemo2 singletonDemo2 = SingletonDemo2.getInstance();
        singletonDemo2.print();
        //饿汉模式
        SingletonDemo3 singletonDemo3 = SingletonDemo3.getInstance();
        singletonDemo3.print();
        //双检锁/双重校验锁
        SingletonDemo4 demo4 = SingletonDemo4.getInstance();
        demo4.print();
        //内部类
        SingletonDemo5 demo5 = SingletonDemo5.getInstance();
        demo5.print();
        //枚举
        SingletonEnum enum1 = SingletonEnum.INSTANCE;
        enum1.print();
    }

}

/**
 * 懒汉式，线程不安全
 *
 * @author BrokenColor
 * @date 2019年3月14日
 */
class SingletonDemo {
    private static SingletonDemo instance;

    private SingletonDemo() {
    }

    public static SingletonDemo getInstance() {
        if (null == instance) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    public void print() {
        System.out.println("hello Singleton Pattern");
    }
}

/**
 * 描述：懒汉式，线程安全
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 *
 * @author BrokenColor
 * @date 2019年3月14日
 */
class SingletonDemo2 {
    private static SingletonDemo2 instance;

    private SingletonDemo2() {
    }

    //加锁 synchronized 才能保证单例，但加锁会影响效率。
    public static synchronized SingletonDemo2 getInstance() {
        if (null == instance) {
            instance = new SingletonDemo2();
        }
        return instance;
    }

    public void print() {
        System.out.println("hello Singleton2 Pattern");
    }
}

/**
 * 饿汉模式
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 *
 * @author BrokenColor
 * @date 2019年3月14日
 */
class SingletonDemo3 {
    private static SingletonDemo3 instance = new SingletonDemo3();

    private SingletonDemo3() {
    }

    public static SingletonDemo3 getInstance() {
        return instance;
    }

    public void print() {
        System.out.println("hello Singleton3 Pattern");
    }
}

/**
 * 双检锁/双重校验锁
 */
class SingletonDemo4 {
    private static volatile SingletonDemo4 instance;

    private SingletonDemo4() {
    }

    public static SingletonDemo4 getInstance() {
        if (null == instance) {
            synchronized (SingletonDemo4.class) {
                if (null == instance) {
                    instance = new SingletonDemo4();
                }
            }
        }
        return instance;
    }

    public void print() {
        System.out.println("hello Singleton4 Pattern");
    }
}

//内部类
class SingletonDemo5 {
    private static class SingletonHolder {
        private static final SingletonDemo5 instance = new SingletonDemo5();
    }

    private SingletonDemo5() {
    }

    public static SingletonDemo5 getInstance() {
        return SingletonHolder.instance;
    }

    public void print() {
        System.out.println("hello Singleton5 Pattern");
    }
}

//枚举
enum SingletonEnum {
    INSTANCE;

    public void print() {
        System.out.println("hello enum Pattern");
    }
}