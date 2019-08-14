
public class BSTNode
{
    public String data;
    public int count; 				// counter for word occurrences
    public BSTNode leftchild;
    public BSTNode rightchild;

    // Constructor to make sure count starts off at 1.
    public BSTNode (){
        this.count = 1;
    }

    /** This method implements the compareTo method to sort in alphabetic order inside the BST and than
     * counts occurrences for the words and duplicates. This also checks the nodes in the traversal to see if
     * their null or not.
     * @param word : takes a single String word for later purposes in the listing
     */
    public void add(String word)
    {
        if (data.compareTo(word) < 0)
        {
            if(rightchild==null){
                rightchild = new BSTNode();
                rightchild.data = word;

            }

            if(rightchild!=null){
                rightchild.add(word);

            }
        }
        else if (data.compareTo(word) == 0)
        {
            //counts the number of occurrences a word has.
            count++;

        }
        else if (data.compareTo(word) > 0)
        {
            if(leftchild==null){
                leftchild = new BSTNode();
                leftchild.data = word;

            }
            if(leftchild!=null){
                leftchild.add(word);

            }
        }
    }
}

