//public class RightSideViewOFbinaryTree {
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res=new ArrayList<Integer>();
//        //pasing the root, the list and  the level
//        sol(root,res,0);
//        return res;
//    }
//    static void sol(TreeNode root,List<Integer> res,int level){
//        if(root==null) return;
//        //if the level matches the size of the list
//        if(level==res.size()){
//            res.add(root.val);
//        }
//        sol(root.right,res,level+1);
//        sol(root.left,res,level+1);
//    }
//}
