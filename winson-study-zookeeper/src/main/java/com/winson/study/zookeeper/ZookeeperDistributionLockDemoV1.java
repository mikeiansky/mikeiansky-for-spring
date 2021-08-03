package com.winson.study.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author winson
 * @date 2021/8/2
 **/
public class ZookeeperDistributionLockDemoV1 {

    public static void lock(ZooKeeper zooKeeper) {
//        System.out.println("ready lock");
        CountDownLatch latch = new CountDownLatch(1);
        Stat existStat = null;
        try {
            existStat = zooKeeper.exists("/winson", new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getType() == Event.EventType.NodeCreated) {
                        // 别人创建的
                        try {
                            zooKeeper.exists(event.getPath(), this);
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (event.getType() == Event.EventType.NodeDeleted) {
                        // 别人删除的
                        // 抢占
                        try {
                            zooKeeper.create("/winson", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                            System.out.println("create success 2");
                            latch.countDown();
                        } catch (KeeperException e) {
                            e.printStackTrace();

                            // 抢占失败，进行注册
                            try {
                                zooKeeper.exists(event.getPath(), this);
                            } catch (KeeperException keeperException) {
                                keeperException.printStackTrace();
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            if (existStat == null) {
                zooKeeper.create("/winson", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                System.out.println("create success 1");
                latch.countDown();
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void release(ZooKeeper zooKeeper){
        try {
            zooKeeper.delete("/winson", -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        ZooKeeper zooKeeper = new ZooKeeper("192.168.159.131:2181", 1000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.getPath() + " : " + event.getType());
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        System.out.println("zookeeper is ready!");
        int size = 10;
        Thread[] threads = new Thread[size];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock(zooKeeper);
                    System.out.println("Thread : " + finalI +" , get lock and run");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    release(zooKeeper);
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("main end...");
    }

}
