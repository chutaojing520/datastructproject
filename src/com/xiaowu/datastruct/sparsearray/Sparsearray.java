package com.xiaowu.datastruct.sparsearray;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author chutaojing
 * @version 1.0
 * @description 使用稀疏数组实现一个五子棋存盘、回复的功能
 * @date 2021-01-19
 * @see
 * @since 1.0
 */
public class Sparsearray {
    public static void main(String[] args) {
        //初始化一个五子棋局
        int[][] chessboard = initChessboard();
        //打印目前棋局情况
        printChessboard(chessboard);
        //把当前五子棋局以稀疏数据形式存储
        int[][] storeChessboard = storeChessboardBySparsearray(chessboard);
        //打印以稀疏数据形式存储的五子棋局
        printChessboard(storeChessboard);
        //根据稀疏数据形式存储的五子棋局还原成实际的棋局
        int[][] restoreChessboard = restoreChessboard(storeChessboard);
        //打印根据稀疏数据形式存储的五子棋局还原成实际的棋局
        printChessboard(restoreChessboard);
    }
    
    /**
     * @param storeChessboard 以稀疏数据形式存储的五子棋局
     * @return int[][]  还原成实际的棋局
     * @Description 根据稀疏数据形式存储的五子棋局还原成实际的棋局
     * @Author chutaojing
     * @Exception
     * @Date 2021/01/21
     */
    private static int[][] restoreChessboard(int[][] storeChessboard) {
        int[][] chessboard = new int[storeChessboard[0][0]][storeChessboard[0][1]];
        for (int i = 1; i <= storeChessboard[0][2]; i++) {
            chessboard[storeChessboard[i][0]][storeChessboard[i][1]] = storeChessboard[i][2];
        }
        return chessboard;
    }
    
    /**
     * @param chessboard 当前棋局
     * @return int[][] 稀疏数组方式存储的棋局
     * @Description 把棋局以稀疏数组方式存储
     * @Author chutaojing
     * @Exception
     * @Date 2021/01/19
     */
    private static int[][] storeChessboardBySparsearray(int[][] chessboard) {
        Map<String, Integer> tempMap = new HashMap<String, Integer>();
        //检索整个棋局中有多少个红棋和黑棋
        int chessmanSum = 0;
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                if (chessboard[i][j] != 0) {
                    chessmanSum++;
                    tempMap.put(i + "," + j, chessboard[i][j]);
                }
            }
        }
        //初始化存储当前棋局的稀疏数组
        int[][] storeChessboard = new int[chessmanSum + 1][3];
        /*
         *稀疏数组storeChessboard的storeChessboard[0][0]=chessboard棋局的总行数
         *storeChessboard[0][1]=chessboard棋局的总列数
         *storeChessboard[0][1]=chessboard棋局的红棋和黑棋的总个数
         */
        storeChessboard[0][0] = chessboard.length;
        storeChessboard[0][1] = chessboard[0].length;
        storeChessboard[0][2] = chessmanSum;
        Set<String> keys = tempMap.keySet();
        int currentRow = 1;
        for (String key : keys) {
            String[] keyArray = key.split(",");
            storeChessboard[currentRow][0] = Integer.parseInt(keyArray[0]);
            storeChessboard[currentRow][1] = Integer.parseInt(keyArray[1]);
            storeChessboard[currentRow][2] = tempMap.get(key);
            currentRow++;
        }
        return storeChessboard;
    }
    
    /**
     * @param
     * @return int[][]
     * @Description 初始化棋局
     * @Author chutaojing
     * @Exception
     * @Date 2021/01/19
     */
    private static int[][] initChessboard() {
        //五子棋盘使用11*11的棋局。规定1代表黑棋,2代表红棋,0代表空子
        int[][] chessboard = new int[11][11];
        //假设目前棋局的情况如下
        chessboard[0][6] = 1;
        chessboard[0][8] = 2;
        chessboard[1][8] = 2;
        chessboard[2][10] = 1;
        chessboard[3][4] = 1;
        chessboard[3][5] = 2;
        return chessboard;
    }
    
    /**
     * @param chessboard
     * @return void
     * @Description 打印二维数组情况
     * @Author chutaojing
     * @Exception
     * @Date 2021/01/19
     */
    private static void printChessboard(int[][] chessboard) {
        System.out.println("=========================================");
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                System.out.print(chessboard[i][j]);
                System.out.print("\t");
            }
            System.out.println("");
        }
        System.out.println("=========================================");
    }
}
