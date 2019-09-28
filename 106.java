
  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution {
    int post_idx;
    int [] inorder;
    int [] postorder;
    HashMapInteger,Integer inord_map= new HashMapInteger, Integer();
    
    public TreeNode helper(int l_inord, int r_inord){
        if (l_inordr_inord){return null;}
        System.out.println(post_idx);
        int root_val=postorder[post_idx];
        TreeNode root= new TreeNode(root_val);
        post_idx--;
        int index= inord_map.get(root_val);
        root.right=helper(index+1,r_inord);
        root.left=helper(l_inord, index-1);
        return root;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder=inorder;
        this.postorder=postorder;
        this.post_idx=postorder.length-1;
        for (int i=0; iinorder.length;i++){
            inord_map.put(inorder[i],i);
        }
        return helper(0,inorder.length-1);
    }
}