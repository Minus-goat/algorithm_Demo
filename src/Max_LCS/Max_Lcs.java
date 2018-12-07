
package Max_LCS;

import java.util.Arrays;

public class Max_Lcs {
    public static void main(String[] args){

        int[] st1 = {1,0,3,4,5,6,7,90,75};
        System.out.println(Arrays.toString(st1));
        int[] st2 = {1,3,9,4,3,6,75,90};
        System.out.println(Arrays.toString(st2));

        //二维数组
        int[][] b;
        b = new int[st1.length+1][st2.length+1];

        int len = LCSLength(st1, st2, b);
        System.out.println("最长公共子序列的长度为："+len);
        System.out.println("最长公共子序列为：");
        PrintLCS(b,st1,st1.length,st2.length);
        System.out.println();
    }

    private static void PrintLCS(int[][] b, int[] st1, int i, int j) {
        if(i==0 || j==0)
            return ;
        if(b[i][j]==0)
        {
            PrintLCS(b, st1, i-1, j-1);//从后面开始递归，所以要先递归到子串的前面，然后从前往后开始输出子串
            System.out.println(st1[i-1]);//c[][]的第i行元素对应str1的第i-1个元素
        }
        else if(b[i][j]==1)
            PrintLCS(b, st1, i-1, j);
        else
            PrintLCS(b, st1, i, j-1);

    }

    public static int LCSLength(int[] str1, int[] str2, int[][] b)
    {


        //双指针的方法申请动态二维数组
        int[][] c = new int[str1.length+1][str2.length+1]; //共有length1+1行

        for(int i = 0; i < str1.length+1; i++)
            c[i][0]=0;        //第0列都初始化为0
        for(int j = 0; j <str2.length+1; j++)
            c[0][j]=0;        //第0行都初始化为0

        for(int i = 1; i < str1.length+1; i++)
        {
            for(int j = 1; j < str2.length+1; j++)
            {
                if(str1[i-1]==str2[j-1])//由于c[][]的0行0列没有使用，c[][]的第i行元素对应str1的第i-1个元素
                {
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j]=0;          //输出公共子串时的搜索方向
                }
                else if(c[i-1][j]>c[i][j-1])
                {
                    c[i][j]=c[i-1][j];
                    b[i][j]=1;
                }
                else
                {
                    c[i][j]=c[i][j-1];
                    b[i][j]=-1;
                }
            }
        }
	int len = c[str1.length][str2.length];
	return  len;
    }

}
