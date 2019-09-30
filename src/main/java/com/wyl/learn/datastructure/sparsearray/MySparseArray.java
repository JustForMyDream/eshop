package com.wyl.learn.datastructure.sparsearray;

public class MySparseArray {

	public static void main(String[] args) {
		// 创建一个原始的二维数组 11 * 11
		// 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[4][5] = 2;
		System.out.println("原始的二维数组~~");
		for(int []row : chessArr1){
			for(int data : row){
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}

		int sum = 0;
		for (int i = 0;i < 11;i ++){
			for(int j = 0;j < 11;j ++){
				if(chessArr1[i][j] != 0){
					sum += 1;
				}
			}
		}

		//床架稀疏数组
		int [][]sparseArray = new int[sum+1][3];
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
		int k = 1;
		for (int i = 0;i < 11;i ++){
			for(int j = 0;j < 11;j ++){
				if(chessArr1[i][j] != 0){
					sparseArray[k][0] = i;
					sparseArray[k][1] = j;
					sparseArray[k][2] = chessArr1[i][j];
					k ++;
				}
			}
		}

		System.out.println("稀疏数组~~");
		for(int []row : sparseArray){
			for (int data : row){
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}

		//将稀疏数组转为二维数组
		int x = 0;
		int y = 0;
		int num = 0;
		for (int i = 0;i < sparseArray[0].length;i ++){
			x = sparseArray[0][0];
			y = sparseArray[0][1];
			num = sparseArray[0][2];
		}

		int [][]array = new int[x][y];

		for (int i = 1;i < num + 1;i ++){
			array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		System.out.println("二维数组~~");

		for(int []row : array){
			for(int data : row){
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}





	}

}
