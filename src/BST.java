
public class BST

{
    public BSTNode root;
    public int total;

    public void print() {
        print(root);
    }

    /**
     * Simple print method for the node to make
     * sure formatting is efficient and clean.
     * @param node
     */
    private void print(BSTNode node) {
        if(node != null) {
            print(node.leftchild);
            System.out.print(node.data + "\n ");
            print(node.rightchild);
        }
    }

    /** This method helps the main add method below to make
     * sure we are going into the right nodes, and helps
     * traverse in the correct desired way
     * @param word
     * @param node
     */
    private void add_Helper(String word, BSTNode node) {
        if(word.compareTo(node.data) >= 0){
            if(node.rightchild==null){
                node.add(word);
            }
            else{
                add_Helper(word, node.rightchild);
            }
        }

        else{

            if(node.leftchild==null){
                node.add(word);
            }
            else{
                add_Helper(word, node.leftchild);
            }
        }
    }

    /** This add method adds word in the overall
     * recursive method by finding out a total.
     * @param word
     */
    public void add(String word)
    {
        if(root==null)
        {
            // if statement creates a root node in the BST if the root is null
            root = new BSTNode();
            root.data = word;
            total++;
        }
        else
        {
            add_Helper(word, root);
        }
    }
}
