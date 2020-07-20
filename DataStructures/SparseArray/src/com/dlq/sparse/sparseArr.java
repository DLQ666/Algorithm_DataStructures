package com.dlq.sparse;

/**
 * @program: Algorithm_DataStructures
 * @description: 稀疏数组
 * @author: Hasee
 * @create: 2020-07-20 13:07
 */
public class sparseArr {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0：表示没有棋子，1：表示黑子，2：表示蓝子
        int chessArr[][] = new int[11][11];
        chessArr[0][2] = 1;
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        System.out.println("原始二维数组");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组 转 稀疏数组
        //1、先遍历二维数组，得到非0数据个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0){
                    sum++;
                }
            }
        }

        //2、创建对应稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //再次遍历二维数组，将非零的值存放到sparseArr稀疏数组中
        int count = 0;//count 用于记录是第几个非零数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();

        //将稀疏数组---》恢复成 原始的二维数组
        //1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2、再读取稀疏数组的后几行数据（从第二行），并赋值给原始的二维数组
        for (int i = 1; i <sparseArr.length ; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        //遍历恢复后的二维数组
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
