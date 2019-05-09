package zhangpengfei;

import java.text.DecimalFormat;

/**
 * Created by ZPF on 2019/5/8. 棋盘覆盖
 */
//分治算法：待解决复杂的问题能够简化为几个若干个小规模相同的问题，然后逐步划分，达到易于解决的程度。
// 把棋盘分为4等份，对于每个小份，如果包含特殊位置，取该点，如果不是，取原棋盘的中心四个点其中一个。
//思路参照https://wenku.baidu.com/view/e331f06c336c1eb91a375d75.html
public class chessBoard {
    int t=0;//棋盘号，3个相同的棋盘号构成一个L形状
    int board[][]=new int[8][8];
    void chessBoard(int tr,int tc,int dr,int dc,int size){
        if(size==1) return;
        t++;
        int s=size/2;
        if(dr<tr+s&&dc<tc+s){//左上角
            chessBoard(tr,tc,dr,dc,s);
        }
        else {
            board[tr+s-1][tc+s-1]=t;
            chessBoard(tr,tc,tr+s-1,tc+s-1,s);
        }
        if(dr<tr+s&&dc>=tc+s){//右上角
            chessBoard(tr,tc+s,dr,dc,s);
        }
        else {
            board[tr+s-1][tc+s]=t;
            chessBoard(tr,tc+s,tr+s-1,tc+s,s);
        }
        if(dr>=tr+s&&dc<tc+s){//左下角
            chessBoard(tr+s,tc,dr,dc,s);
        }
        else {
            board[tr+s][tc+s-1] = t;
            chessBoard(tr+s,tc,tr+s,tc+s-1,s);
        }
        if(dr>=tr+s&&dc>=tc+s){
            chessBoard(tr+s,tc+s,dr,dc,s);
        }
        else {
            board[tr+s][tc+s]=t;
            chessBoard(tr+s,tc+s,tr+s,tc+s,s);
        }
    }
    public static void main(String[] args)
    {
        chessBoard c = new chessBoard();
        c.chessBoard(0,0,1,1,8);
        for(int i = 0; i <8; i++)
        {
            for(int j = 0; j <8; j++){
                DecimalFormat df = new DecimalFormat("00");

                String str2 = df.format(c.board[i][j]);

                System.out.print(str2+"  ");

            }

            System.out.println();
        }
    }
}
/*
时间复杂度：
T(k)为覆盖2^k×2^k棋盘的时间
k==0 ===>O(1)          :覆盖它需要O（1）
k>0  ===>4T(k-1)+O(1)  :找到特殊子棋盘和形成三个子棋盘O(1）
                        +四次特殊子棋盘的递归调用4T(k-1)
 迭代法可求出T（k)=O(4^k)
 */
