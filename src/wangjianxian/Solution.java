package wangjianxian;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wjx
 * Date: 2019-05-07
 * Time: 16:18
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

/**
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 先中序遍历二叉搜索树，这样二叉搜索树就按照val值的大小从小到大排好序了，存放在数组中
 * 然后要转换为双向链表，由于数组中的存放的树的节点已经按照键值从小到大排好序了，那么就对于每个节点的左子树指向数组的上一个节点，右子树指向数组的下一个节点，这样就完成了变成双向链表。
 比如将二元查找树
        10
     /       \
    6       14
 /   \      /   \
 4     8  12  16
 转换成双向链表
 4=6=8=10=12=14=16。
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)) {
            return pRootOfTree;
        }
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        BuildArrayList(pRootOfTree, nodeList);
        for (int i = 0; i < nodeList.size(); i++) {
            if (i == 0) {
                //数组的第一个节点处理，只有右子树指向下一个节点
                nodeList.get(0).right = nodeList.get(1);
            } else if (i == nodeList.size() - 1) {
                nodeList.get(i).left = nodeList.get(i - 1);
            } else {
                nodeList.get(i).left = nodeList.get(i - 1);
                nodeList.get(i).right = nodeList.get(i + 1);
            }
        }
        return nodeList.get(0);
    }


    public void BuildArrayList(TreeNode root, ArrayList<TreeNode> nodeList) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            BuildArrayList(root.left, nodeList);
        }
        if (root != null) {
            nodeList.add(root);
        }
        if (root.right != null) {
            BuildArrayList(root.right, nodeList);
        }
    }
}
