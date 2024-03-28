package com.jyh.sort;


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class test {
    public static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        String lock = "lock";
        Thread t1 = new Thread(() -> {
            synchronized (lock){
                for(int j = 0; j < 100; j++){
                    i = i + 1;
                    System.out.println(Thread.currentThread().getName() + ":" + String.valueOf(i));
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        });
        Thread t2 = new Thread(() -> {
            synchronized (lock){
                for(int j = 0; j < 100; j++){
                    i = i + 1;
                    System.out.println(Thread.currentThread().getName() + ":" + String.valueOf(i));
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
    public static int merge_sort(int nums[],int t[], int l ,int r){
        //序列只有一个数
        if (l == r) return 0;
        //递归左边和右边
        int mid = l + r >> 1;
        int res = merge_sort(nums, t, l , mid) + merge_sort(nums, t, mid + 1, r);
        //归并的过程
        int i = l , j = mid + 1, k = 0;
        while (i <= mid && j <= r){
            if (nums[i] <= nums[j]) t[k++] = nums[i++];
            else{
                t[k++] = nums[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid) t[k++] = nums[i++];
        while (j <= r) t[k++] = nums[j++];
        //还原数组
        for (i = 0 , j = l ; j <= r ; i ++ , j ++) nums[j] = t[i];
        return res;
    }
}