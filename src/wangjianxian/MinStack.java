package wangjianxian;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wjx
 * Date: 2019-05-06
 * Time: 16:15
 */

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 */
public class MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MinStack(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    public void push(int x){
        stack1.push(x);
        if(stack2.isEmpty()||x<=stack2.peek()){
            stack2.push(x);
        }
    }
    public void pop(){
        if(stack1.peek()==getMin()){
            stack2.pop();
        }
        stack1.pop();
    }
    public int top(){
        return stack1.peek();
    }
    public int getMin(){
        return stack2.peek();
    }
}
