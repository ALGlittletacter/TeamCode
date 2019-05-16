package zhangpengfei;

/**
 * Created by ZPF on 2019/5/15.
 */
/*
有若干物品，每个物品有自己的价值和重量。背包容量固定。
怎样将背包装的最大价值？
 */
class Good{//物品类
    public String number;//物品编号
    public int value;//物品价值
    public double weight;//物品重量
    public double wi;//物品权重
    public Good(String number,int value,double weight){
        this.number=number;
        this.value=value;
        this.weight=weight;
        this.wi=value/weight;

    }
}
public class BackPack {
    public static void sort(Good[] g){//按照物品的权重排序
        Good good;
        for(int i=0;i<g.length-1;i++){//选择排序
            int x=i;
            for(int j=i+1;j<g.length;j++){
                if(g[j].wi>g[x].wi){
                    x=j;
                }
            }
            good=g[i];
            g[i]=g[x];
            g[x]=good;
        }
    }
    public static void corealg(Good[] g,double capacity){

        for(int i=0;i<g.length;i++){
            if(capacity>g[i].weight){
                System.out.println("放入了"+g[i].number+"编号的物品");
                capacity-=g[i].weight;
            }
            else {
                break;
            }
        }
    }
}
