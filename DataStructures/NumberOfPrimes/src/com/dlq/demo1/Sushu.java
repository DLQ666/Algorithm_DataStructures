package com.dlq.demo1;

/**
 *@program: Algorithm_DataStructures
 *@description: 统计素数个数
 *                  --->暴力算法
 *                  ---->埃筛法
 *@author: Hasee
 *@create: 2021-05-28 17:14
 */
public class Sushu {

    public static void main(String[] args) {
        System.out.println(bf(100));
        System.out.println(eratosthenes(100));
    }

    //暴力算法
    public static int bf(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int x) {
        //for (int i = 2; i < x; i++) { //未优化
        for (int i = 2; i * i <= x; i++) { //优化后 相当于 i <= √x
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    //埃筛法(埃氏筛)
    public static int eratosthenes(int n) {
        boolean[] isPrime = new boolean[n];//初始化默认：false 代表素数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                //for (int j = 2 * i; j < n; j += i) {//未优化 //j 就是合数的标记位
                for (int j = i * i; j < n; j += i) {//优化后 //j 就是合数的标记位
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
/**
 *      埃筛法 优化解读
 *     i = 2     i = 3   i = 4   i = 5
 *      2*2       2*3     2*4     2*5
 *      2*3       3*3     3*4     3*5
 *      2*4       4*3     4*4     4*5
 *      2*5       5*3     5*4     5*5
 *      2*6       6*3     6*4     6*5
 *      ...       ...     ...     ...
 *
 *      3*3 之前的计算 在 i=2 的遍历中 计算过
 *      4*4 之前的计算 在 i=2，i=3 的遍历中 计算过
 *      5*5 之前的计算 在 i=2，i=3，i=4 的遍历中 计算过
 *      .........
 *      所以优化结果就是 将for循环更改为 j = i * i
 *
 * 利用合数的概念(非素数)，素数*n必然是合数，因此可以从2开始遍历，将所有的合数做上标记。
 *
 * 将合数标记为true，j=i*i 从 2*i 优化而来，系数2会随着遍历递增( j+=i，相当于递增了系数2)，每一个合数
 * 都会有一个（9=3*3）或两个（6=2*3）比本身要小的因子(0,1除外)，2*i必然会遍历到这一个或两个因子。
 *
 * 当2递增到大于 根号n 时，其实后面的已经无需再判断(或者只需判断后面一段)，而2到 根号n、实际上在 i 递增
 * 的过程中已经计算过了，i 实际上就相当于根号n
 *
 * 例如：n = 25 会计算以下
 *  2 * 4 = 8
 *  3 * 4 = 12
 *  但实际上8和12已经标记过，在n = 17时已经计算了3*4，2*4
 */
