package Artists;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        Tree.java
 * Project      Binary Search Trees
 * Description  A definition for Tree class with multitude of methods for 
 *              operations on trees     
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; Windows 10
 * Course       CS 142, Edmonds College
 * Hours        1 hours and 45 minutes
 * Date         2/25/2021
 * @author	<i>Niko Culevski</i>
 * @version 	%1% %2%
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Tree
{
    private TreeNode root;
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor     TreeNode()-- deafault constructor
     * Description     Construct a null Tree of Artists.
     * @author         <i>Niko Culevski</i>
     * Date            2/25/2021
     * History Log     2/25/2021
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Tree()
    {
        root = null;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           InsertNode()
     * Description      Insert a new node in the binary search tree. If the root 
     *                  node is null, create the root node here. Otherwise, call
     *                  the insert method from the from the class TreeNode
     * @author          <i>Niko Culevski</i>
     * Date             2/25/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void insertNode(Artist artist)
    {
        if (root == null)
            root = new TreeNode(artist);
        else
            root.insert(artist);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           remove()
     * Description      A method to remove a node with given name only. Calls
     *                  overloaded remove method with artist name and the root
     *                  of the Tree
     * @author          <i>Niko Culevski</i>
     * @param           artist Artist to be removed
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void remove(Artist artist)
    {
	root = remove(artist, root);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           remove()
     * Description      An overloaded recursive method to remove a node with 
     *                  given artist and node. 
     * @author          <i>Niko Culevski</i>
     * @param           artist Artist to be removed
     * @param           node TreeNode
     * @return          node TreeNode--the new root
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private TreeNode remove(Artist artist, TreeNode node)
    {
	if( node == null )
	    return node;                        // Item not found; do nothing
	if(artist.compareTo(node.data) < 0)
	    node.left = remove(artist, node.left);
	else if(artist.compareTo(node.data) > 0)
	    node.right = remove(artist, node.right);
	else if(node.left != null && node.right != null) // Two children
        {
	    node.data = findMin(node.right).data;
	    node.right = remove(node.data, node.right);
	}
	else    //Case 1 & case 2: remove leaf node & single child
	    node = (node.left != null) ? node.left : node.right;
	return node;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getRoot()
     * Description  Getter method to return the root of the tree
     * @author      <i>Niko Culevski</i>
     * @return      root TreeNode
     * Date         4/3/2020
     * History Log  7/18/2018
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public TreeNode getRoot()
    {
        return root;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           removeAll()
     * Description      A method to remove all nodes of the Tree
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void removeAll()
    {
        root = null;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findMin()
     * Description      A method to find and return the artist with the minimum
     *                  value as specified by the Artist compareTo method. 
     *                  Calls an overloaded method to start the search from the 
     *                  root node that is passed to it.
     * @author          <i>Niko Culevski</i>
     * @return          artist Artist--with minimum name
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Artist findMin()
    {
        return findMin(root).data;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findMin()
     * Description      A recursive overloaded method to find the node with the 
     *                  artist containing the minimum value as specified by 
     *                  the Artist compareTo method. 
     * @author          <i>Niko Culevski</i>
     * @param           node TreeNode--recursive node to search for minimum
     * @return          node TreeNode--node containing the smallest item
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private TreeNode findMin(TreeNode node)
    {
	if(node == null)
	    return null;
	else if(node.left == null)
	    return node;
	return findMin(node.left);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findMax()
     * Description      A method to find and return the artist with the maximum
     *                  value as specified by the Artist compareTo method. 
     *                  Calls an overloaded method to start the search from the 
     *                  root node that is passed to it.
     * @author          <i>Niko Culevski</i>
     * @return          artist Artist--with minimum name
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Artist findMax()
    {
        return findMax(root).data;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findMax()
     * Description      A recursive overloaded method to find the node with the 
     *                  artist containing the maximum value as specified by 
     *                  the Artist compareTo method. 
     * @author          <i>Niko Culevski</i>
     * @param           node TreeNode--recursive node to search for minimum
     * @return          node TreeNode--node containing the largest item.
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private TreeNode findMax(TreeNode node)
    {
	if( node != null )
        {
	    while( node.right != null )
		node = node.right;
        }	
	return node;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           elementAt()
     * Description      A method to return the artist (data) given the node. 
     * @author          <i>Niko Culevski</i>
     * @param           node TreeNode
     * @return          artist Artist--the element field or null.
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private Artist elementAt(TreeNode node)
    {
	return (node == null ? null : node.data);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           nodeWith()
     * Description      A method to return the artist (data) given the node. 
     * @author          <i>Niko Culevski</i>   
     * @param           data Artist
     * @param           node TreeNode
     * @return          node TreeNode--the node with specified artist or null
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private TreeNode nodeWith( Artist data, TreeNode node)
    {
        if (node == null)
            return null;
        else
        {
            if(data.compareTo(node.data) == 0)
                return node;
            else
                if (data.compareTo(node.data) < 0)
                    return nodeWith(data, node.left);
                else
                    return nodeWith(data, node.right);                            
        }            
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           nodeWith()
     * Description      An overloaded method to return the node given the 
     *                  artist name as a String
     * @author          <i>Niko Culevski</i>   
     * @param           artistName String
     * @param           node TreeNode
     * @return          node TreeNode--the node with specified artist's name or null
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public TreeNode nodeWith(String artistName, TreeNode node)
    {
        if (node == null)
            return null;
        else
        {
            if(artistName.compareTo(node.data.getName()) == 0)
                return node;
            else
                if (artistName.compareTo(node.data.getName()) < 0)
                    return nodeWith(artistName, node.left);
                else
                    return nodeWith(artistName, node.right);                            
        }            
    }
        
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           next()
     * Description      An unfinished method to return the next artist according
     *                  to the sorting of the BST given an artist. 
     * @author          <i>Niko Culevski</i>
     * @param           artist Artist
     * @return          artist Artist--the next artist.
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Artist next(Artist artist)
    {
        TreeNode nextNode = nodeWith(artist, root);
        if( nextNode.left != null && nextNode.right != null ) // Two children
            return findMin(nextNode.right).data;
        else
            return null;   //not so--needs work!! UNFINISHED
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           previous()
     * Description      An unfinished method to return the next artist according
     *                  to the sorting of the BST given an artist. 
     * @author          <i>Niko Culevski</i>
     * @param           artist Artist
     * @return          artist Artist--the next artist.
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Artist previous(Artist artist)
    {
        TreeNode nextNode = nodeWith(artist, root);
        if( nextNode.left != null && nextNode.right != null ) // Two children
            return findMax(nextNode.left).data;
        else
            return null; //not so--needs work!! UNFINISHED
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           preorderTraversal()
     * Description      Display data of nodes in preorder: Node, Left, Right, Calls
     *                  recursive preorderHelper method to do the real display.
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void preorderTraversal()
    {
        preorderHelper( root );
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           preorderHelper()
     * Description      Display data of nodes id preorder: Node, Left, Right
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void preorderHelper( TreeNode node )
    {
        if ( node == null )
            return;
        System.out.print( node.data + " " );
        preorderHelper( node.left );
        preorderHelper( node.right );
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           inorderTraversal()
     * Description      Display data of nodes in preorder: Left, Node, Right. Calls
     *                  recursive inorderHelper method to do the real display
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void inorderTraversal()
    {
        inorderHelper( root );
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           inorderHelper()
     * Description      Display data of nodes in preoredr: left, Node, Right.
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void inorderHelper( TreeNode node )
    {
        if ( node == null )
            return;
        inorderHelper( node.left );
        System.out.print( node.data + " " );
        inorderHelper( node.right );
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           postorderTraversal()
     * Description      Display data of nodes in preorder: Left, Right, Node. Calls
     *                  recursive postorderHelper method to do the real display
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void postorderTraversal()
    {
        postorderHelper( root );
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           postorderHelper()
     * Description      Display data of nodes in preorder: left, Right, Node.
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void postorderHelper( TreeNode node )
    {
        if ( node == null )
            return;
        postorderHelper( node.left );
        postorderHelper( node.right );
        System.out.print( node.data + " " );
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           toString()
     * Description      Outputs the tree contents in sorted order as a string.
     *                  It calls the printTree to print the tree inorder.
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString( )
    {
	if( isEmpty() )
	    return( "" );
	else
	    return(printTree( root ));
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           printTree()
     * Description      Outputs the tree contents in sorted order via inorder.
     * @parem           node TreeNode--the node that roots the tree
     * @return          tree String
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private String printTree(TreeNode node)
    {
	StringBuilder buf = new StringBuilder("");
	if(node != null)
        {
	    buf.append(printTree( node.left));
	    buf.append(node.data + " ");
	    buf.append(printTree( node.right));
	}
	return buf.toString();
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           isEmpty()
     * Description      Test if the tree is logically empty.
     * @return          true if empty, false otherwise
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean isEmpty()
    {
	return root == null;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           size()
     * Description      Find number of nodes in a tree. Calls sizeHelper with 
     *                  the root of the tree passed to it
     * @return          number of nodes in a tree
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int size()
    {	
        return sizeHelper(root);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           sizeHelper()
     * Description      Recursive method to find number of nodes in a tree.
     * @param           node TreeNode
     * @return          number of nodes in the tree
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int sizeHelper (TreeNode node)
    {
	if (node == null)
	    return 0;
	else
	    return 1 + sizeHelper(node.left) + sizeHelper(node.right);
    }  

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           countLeaves()
     * Description      Find number of leaves in a tree. Calls countLeavesHelper  
     *                  with the root of the tree passed to it
     * @return          number of leaves in a tree to which node points
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int countLeaves() 
    {
        return countLeavesHelper(root);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           countLeavesHelper()
     * Description      Recursive method to find number of leaves in a tree.
     * @param           node TreeNode
     * @return          number of leaves in the tree
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int countLeavesHelper(TreeNode node)
    {
        if (node == null)
           return 0;
        else if (node.left == null && node.right == null)
            return 1;  // Node is a leaf.
        else
            return countLeavesHelper(node.left) + countLeavesHelper(node.right);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           height()
     * Description      Find height of a tree. Calls heighthHelper with the root 
     *                  of the tree passed to it.The height of a node is the 
     *                  number of edges on the longest path from the  node to a 
     *                  leaf. A leaf node will have a height of 0
     * @return          height of a node int
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int height() 
    {
        return heighthHelper(root);        
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           heighthHelper()
     * Description      Recursive method to find the height of a node.
     * @param           node TreeNode
     * @return          height of a node int
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int heighthHelper(TreeNode node)
    {
        if(node == null)
            return 0;
        else
        {
            return 1 + Math.max(heighthHelper(node.left),
                    heighthHelper(node.right));
        }
//        int left = heighthHelper(node.left);
//        int right = heighthHelper(node.right);
//
//        int x = (left > right) ? left + 1 : right + 1;
//        return x;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findParent()
     * Description      Find height of a tree. Calls overloaded findParent with
     *                  artist, root and parent (null)
     * @param           artist Artist
     * @return          parent node of artist TreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public TreeNode findParent(Artist artist) 
    {
        return findParent(artist, root, null);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findParent()
     * Description      Recursive method to find the parent of an artist.
     * @param           artist Artist
     * @param           node TreeNode
     * @param           parent TreeNode
     * @return          parent of a node or null--TreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public TreeNode findParent(Artist artist, TreeNode node, TreeNode parent) 
    {
        if (node == null) 
        {
            return null;
        } 
        else if (node.data != artist) 
        {
            parent = findParent(artist, node.left, node);
            if (parent == null) 
            {
                parent = findParent(artist, node.right, node);
            }
        }
        return parent;
    }
        
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findSuccessor()
     * Description      Recursive method to find the successor of an artist 
     *                  given the data=Artist
     * @param           data Artist
     * @return          successor of an artist or null--TreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public TreeNode findSuccessor(Artist data) 
    {
        return findSuccessor(nodeWith(data,root));
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findSuccessor()
     * Description      An overloaded recursive method to find the successor 
     *                  of an artist given a node
     * @param           node TreeNode
     * @return          successor of an artist or null--TreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public TreeNode findSuccessor(TreeNode node)
    {
	if (node == null)
		return null;
	
	if (node.right != null)
		return findMin(node.right);
	
	TreeNode y = findParent(node.data);
	TreeNode x = node;
	while (y != null && x == y.right)
	{
		x = y;
		y = findParent(y.data);
	}
	// Intuition: as we traverse left up the tree we traverse smaller values
	// The first node on the right is the next larger value
	return y;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findPredecessor()
     * Description      Recursive method to find the predecessor of an artist 
     *                  given the data=Artist
     * @param           data Artist
     * @return          successor of an artist or null--TreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public TreeNode findPredecessor(Artist data) 
    {
        return findPredecessor(nodeWith(data,root));
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findPredecessor()
     * Description      An overloaded recursive method to find the predecessor 
     *                  of an artist given a node
     * @param           node TreeNode
     * @return          predecessor of an artist or null--TreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public TreeNode findPredecessor(TreeNode node)
    {
	if (node == null)
            return null;
	
	if (node.left!= null)
            return findMax(node.left);
			
	TreeNode parent = findParent(node.data);

	TreeNode y = parent;
	TreeNode x = node;
	while (y != null && x == y.left)
	{
            x = y;
            y = findParent(y.data);
	}	
	return y;
    }    
}