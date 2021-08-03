package com.winson.study.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author winson
 * @date 2021/8/2
 **/
public class ZookeeperDistributionLockDemoV2 {

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

        int size = 10;
        Thread[] threads = new Thread[size];
        for (int i = 0; i < size; i++) {
            int finalI = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    String lock = lock(zooKeeper);
                    System.out.println("thread : " + finalI + " , get lock");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    release(zooKeeper, lock);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("main end");
    }

    public static String lock(ZooKeeper zooKeeper) {
        String lock = null;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            lock = zooKeeper.create("/ciwei/lock_", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            String childPath = lock.substring("/ciwei/".length());
            List<String> children = zooKeeper.getChildren("/ciwei", false);
            children.sort(Comparator.naturalOrder());
//            System.out.println(" run children : " + children);
            String lastPath = null;
            for (String child : children) {
//                System.out.println("child : " + child + " , compareTo lock : " + childPath + " result : " + child.compareTo(childPath));
                if (child.compareTo(childPath) < 0) {
                    lastPath = child;
                } else {
                    break;
                }
            }
//            System.out.println("lock" + lock + " , lastPath : " + lastPath);
            // 有比当前小的
            if (lastPath != null) {
//                System.out.println(" run 1");
                String finalLastPath = "/ciwei/"+lastPath;
                Stat stat = zooKeeper.exists(finalLastPath, new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        if (event.getType() == Event.EventType.NodeDeleted) {
                            // 获得锁
                            countDownLatch.countDown();
                        } else {
                            try {
                                zooKeeper.exists(finalLastPath, this);
                            } catch (KeeperException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                if (stat == null) {
//                    System.out.println(" run 2");
                    countDownLatch.countDown();
                }
            } else {
//                System.out.println(" run 3");
                countDownLatch.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" exception -----------");
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return lock;
    }

    public static void release(ZooKeeper zooKeeper, String lock) {
        try {
            zooKeeper.delete(lock, -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

}
