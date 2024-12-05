package Artists;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        TreeNode.java
 * Project      Binary Search Trees
 * Description  A self-refential class representing a binary tree node of Artists.      
 * Platform     jdk 1.8.0_251; NetBeans IDE 11.3; MacBook Air
 * Course       CS 142, Edmonds College
 * Hours        1 hours and 45 minutes
 * Date         3/6/2021
 * History Log  2/25/2021
 * @author	<i>Niko Culevski</i>
 * @version 	%1% %2%

 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class TreeNode
{
    // package access members
    TreeNode left;  // left node
    Artist data;    // data item
    TreeNode right; // right node
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor     TreeNOde()-- constructor
     * Description     Initialize data to d and make this a leaf node.
     * @param          artist Artist
     * @author         <i>Niko Culevski</i>
     * Date            3/6/2021
     * History Log     2/25/2021
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public TreeNode(Artist artist)
    {
        data = artist;
        left = right = null; // this node has no children
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       Insert()
     * Description  Recursive method to insert an Artist into a Tree that
     *              contains nodes
     * @param       artist Artist
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public synchronized void insert(Artist artist)
    {
        if (artist.compareTo(data) < 0)
        {
            if (left == null)
                left = new TreeNode(artist);
            else
                left.insert(artist);
        }
        else
            if (artist.compareTo(data) >= 0)
            {
                if (right == null)
                    right = new TreeNode(artist);
                else
                    right.insert(artist);
            }
    }
}