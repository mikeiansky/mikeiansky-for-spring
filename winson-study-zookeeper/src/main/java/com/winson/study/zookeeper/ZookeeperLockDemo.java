package com.winson.study.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author winson
 * @date 2021/7/29
 **/
public class ZookeeperLockDemo {

    public static class TestThread implements Runnable {

        private Integer threadFlag;
        private InterProcessLock lock;

        public TestThread(Integer threadFlag, InterProcessMutex mutex) {
            this.threadFlag = threadFlag;
            this.lock = mutex;
        }

        @Override
        public void run() {

            try {
                lock.acquire();

                System.out.println("第" + threadFlag + "线程获取到了锁");

                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    lock.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {

        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 2, 5000);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("192.168.159.131:2181")
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .retryPolicy(retry)
                .build();

        client.start();

//        byte[] datas = client.getData().forPath("/ciwei");
//        System.out.println("ciwei value : " + new String(datas));

        String lockPath = "/lock";
        InterProcessMutex lock = new InterProcessMutex(client, lockPath);

        for (int i = 0; i < 50; i++) {
            new Thread(new TestThread(i, lock)).start();
        }

        Thread.sleep(5000);

        System.out.println("main end ");

    }

}
