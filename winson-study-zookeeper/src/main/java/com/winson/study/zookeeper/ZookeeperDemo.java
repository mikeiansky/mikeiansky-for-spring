package com.winson.study.zookeeper;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import sun.util.resources.cldr.en.TimeZoneNames_en;

import java.io.IOException;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

/**
 * @author winson
 * @date 2021/7/29
 **/
public class ZookeeperDemo {

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
//        testZookeeper();
        String lock1 = "winson_temp0000000015";
        String lock2 = "winson_temp0000000016";
        System.out.println(lock1);
        System.out.println(lock2);
        System.out.println(lock1.compareTo(lock2));
    }

    public static void testDate(){
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
//        System.out.println(date.getTimezoneOffset());
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+00"));

        Calendar calendar = Calendar.getInstance();
//        System.out.println(TimeZone.getTimeZone("Etc/GMT+0").getRawOffset());
//        calendar.setTimeZone(TimeZone.getTimeZone("Etc/GMT+0"));
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());

//        Stream.of(TimeZone.getAvailableIDs()).forEach(System.out::println);

//        System.out.println(calendar);
//        System.out.println(calendar.getTime());
//        System.out.println(calendar.getTimeZone().getID());
//        System.out.println(calendar.getTimeZone().getRawOffset());
//        System.out.println(calendar.getTimeZone().getDisplayName());
//        System.out.println(calendar.getTimeZone());
    }

    public static void testZookeeper() throws InterruptedException, IOException, KeeperException {
        final Semaphore semaphore = new Semaphore(1);
        semaphore.acquire();

        ZooKeeper zooKeeper = new ZooKeeper("192.168.159.131:2181", 4000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("zookeeper process : " + watchedEvent.getState());
//                countDownLatch.countDown();
                semaphore.release();
            }
        });
        System.out.println("main end 1");
        semaphore.acquire();

//        ACL acl = new ACL();
//        acl.setId(new Id("myid","1"));
//        List<ACL> aclList = new ArrayList<>();
//        aclList.add(acl);
//        zooKeeper.create("/kangmei","药业".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        zooKeeper.delete("/ciwei-dev0000000003", 0);

//        zooKeeper.create("/kangmei/dev","man".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

//        byte[] result = zooKeeper.getData("/kangmei", null, new Stat());
//        System.out.println("result : " + new String(result));
        Stat stat = new Stat();

        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                try {
                    System.out.println("watcher , process event : " + new String(zooKeeper.getData(event.getPath(), null, null)));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
            }
        };

        byte[] ciwei = zooKeeper.getData("/ciwei", null, stat);
        if(ciwei != null){
            System.out.println("ciwei is : " + new String(ciwei));
        }
        System.out.println("ciwei cversion : " + stat.getCversion());
        System.out.println("ciwei dversion : " + stat.getVersion());

        Stat exists = zooKeeper.exists("/ciwei", false);
        System.out.println("/ciwei node exists : " + exists);

        zooKeeper.setData("/ciwei", "hello21".getBytes(), exists.getVersion());

//        semaphore.acquire();

        zooKeeper.create("/winson_temp", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        zooKeeper.create("/winson_temp", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

        Thread.sleep(10000);

        zooKeeper.close();

        System.out.println("main end 2");
//        System.out.println("main zooKeeper state : " + zooKeeper.getState());
    }

}
