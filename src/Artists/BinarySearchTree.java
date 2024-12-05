package Artists;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 Class        BinarySearchTree.java
 Project      Binary Search Trees
 Description  A definition for BinarySearchTree class with multitude of methods for 
              operations on trees     
 Platform     jdk 1.8.0_241; NetBeans IDE 11.3; Windows 10
 Course       CS 142, Edmonds College
 Hours        1 hours and 45 minutes
 Date         2/25/2021
 * @author	<i>Niko Culevski</i>
 * @version 	%1% %2%
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class BinarySearchTree
{
    private BinarySearchTreeNode root;
    StringBuilder printBuffer = new StringBuilder("");
    StringBuilder saveBuffer = new StringBuilder("");
    StringBuilder buffer = new StringBuilder("");
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
 Constructor     BinarySearchTreeNode()-- deafault constructor
 Description     Construct a null Tree of Artists.
     * @author         <i>Niko Culevski</i>
     * Date            2/25/2021
     * History Log     2/25/2021
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTree()
    {
        root = null;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
 Method           InsertNode()
 Description      Insert a new node in the binary search tree. If the root 
                  node is null, create the root node here. Otherwise, call
                  the insert method from the from the class BinarySearchTreeNode
     * @author          <i>Niko Culevski</i>
     * Date             2/25/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void insertNode(Artist artist)
    {
        if (root == null)
            root = new BinarySearchTreeNode(artist);
        else
            root.insert(artist);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
 Method           remove()
 Description      A method to remove a node with given name only. Calls
                  overloaded remove method with artist name and the root
                  of the BinarySearchTree
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
     * @param           node BinarySearchTreeNode
     * @return          node BinarySearchTreeNode--the new root
 Date             3/6/2021
 History Log      2/25/2021
</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode remove(Artist artist, BinarySearchTreeNode node)
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
     * @return      root BinarySearchTreeNode
 Date         4/3/2020
 History Log  7/18/2018
</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public BinarySearchTreeNode getRoot()
    {
        return root;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
 Method           removeAll()
 Description      A method to remove all nodes of the BinarySearchTree
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
     * @param           node BinarySearchTreeNode--recursive node to search for minimum
     * @return          node BinarySearchTreeNode--node containing the smallest item
 Date             3/6/2021
 History Log      2/25/2021
</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode findMin(BinarySearchTreeNode node)
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
     * @param           node BinarySearchTreeNode--recursive node to search for minimum
     * @return          node BinarySearchTreeNode--node containing the largest item.
 Date             3/6/2021
 History Log      2/25/2021
</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode findMax(BinarySearchTreeNode node)
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
     * @param           node BinarySearchTreeNode
     * @return          artist Artist--the element field or null.
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private Artist elementAt(BinarySearchTreeNode node)
    {
	return (node == null ? null : node.data);
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           nodeWith()
     * Description      A method to return the artist (data) given the node. 
     * @author          <i>Niko Culevski</i>   
     * @param           data Artist
     * @param           node BinarySearchTreeNode
     * @return          node BinarySearchTreeNode--the node with specified artist or null
 Date             3/6/2021
 History Log      2/25/2021
</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode nodeWith(Artist data, BinarySearchTreeNode node)
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
     * @param           node BinarySearchTreeNode
     * @return          node BinarySearchTreeNode--the node with specified artist's name or null
 Date             3/6/2021
 History Log      2/25/2021
</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode nodeWith(String artistName, BinarySearchTreeNode node)
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
     * Method           contains()
     * Description      A boolean method to determine if an artirst is in the
     *                  BST
     * @author          <i>Niko Culevski</i>   
     * @param           artist Artist
     * @return          true if Artist is in tree; false otherwise
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean contains(Artist artist)
    {
        if(nodeWith(artist, root) == null)
            return false;
        else 
        {
            BinarySearchTreeNode foundArtist = nodeWith(artist, root);
            return (foundArtist.data).equals(artist);
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
        BinarySearchTreeNode nextNode = nodeWith(artist, root);
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
        BinarySearchTreeNode nextNode = nodeWith(artist, root);
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
    private void preorderHelper( BinarySearchTreeNode node )
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
    private void inorderHelper( BinarySearchTreeNode node )
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
    private void postorderHelper( BinarySearchTreeNode node )
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
     * Description      Outputs the tree contents in preorder.
     * @parem           node TreeNode--the node that roots the tree
     * @return          tree String
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String printTree(BinarySearchTreeNode node)
    {	
	if(node != null)
        {
	    printTree(node.left);
//	    buf.append(node.data.getName() + "," + node.data.getBirthYear() + 
//                buf.append(node.data.getCity() + "," + node.data.getCountry() +
//                + '\n'));
            printBuffer.append(node.data.toString() + '\n');        
	    printTree(node.right);
	}
	return printBuffer.toString();
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           buildBuffer()
     * Description      Build a StringBuilder that contains all data in preorder
     *                  traversal.
     * @parem           node TreeNode--the node that roots the tree
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void buildBuffer(BinarySearchTreeNode node)
    {
        if(node != null)
        {
            buffer.append(node.data.toString() + '\n');  
	    buildBuffer(node.left);                 
	    buildBuffer(node.right);
	}
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getBuffer()
     * Description      Return buffer.
     * @return          buffer  String
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public String getBuffer()
    {
        return  buffer.toString();      //printBuffer.toString();
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setBuffer()
     * Description      Return buffer.
     * @param           buffer StringBuilder
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setBuffer(StringBuilder buffer)
    {
        this.buffer = buffer;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           saveTree()
     * Description      Outputs the tree contents to a specified file in preorder.
     * @parem           file String file name
     * @parem           node TreeNode--the node that roots the tree
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void saveTree(BinarySearchTreeNode node, String file)
    {        
        try
        {
            //buffer = new StringBuilder();
            FileWriter filePointer = new FileWriter(file,false);
            PrintWriter writeFile = new PrintWriter(filePointer,false);
            if(node != null)
            {
                String buf = printTree(node);
                //delete last '\n'
                writeFile.write(buf.substring(0, buf.length() - 1));
            }
            writeFile.close();
        }
        catch(IOException exp)
        {
           exp.printStackTrace();
        }
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
     * @param           node BinarySearchTreeNode
     * @return          number of nodes in the tree
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int sizeHelper (BinarySearchTreeNode node)
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
     * @param           node BinarySearchTreeNode
     * @return          number of leaves in the tree
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int countLeavesHelper(BinarySearchTreeNode node)
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
     * @param           node BinarySearchTreeNode
     * @return          height of a node int
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int heighthHelper(BinarySearchTreeNode node)
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
     * @return          parent node of artist BinarySearchTreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findParent(Artist artist) 
    {
        return findParent(artist, root, null);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findParent()
     * Description      Recursive method to find the parent of an artist.
     * @param           artist Artist
     * @param           node BinarySearchTreeNode
     * @param           parent BinarySearchTreeNode
     * @return          parent of a node or null--BinarySearchTreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findParent(Artist artist, BinarySearchTreeNode node, BinarySearchTreeNode parent) 
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
     * @return          successor of an artist or null--BinarySearchTreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findSuccessor(Artist data) 
    {
        return findSuccessor(nodeWith(data,root));
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findSuccessor()
     * Description      An overloaded recursive method to find the successor 
     *                  of an artist given a node
     * @param           node BinarySearchTreeNode
     * @return          successor of an artist or null--BinarySearchTreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findSuccessor(BinarySearchTreeNode node)
    {
	if (node == null)
		return null;
	
	if (node.right != null)
		return findMin(node.right);
	
	BinarySearchTreeNode y = findParent(node.data);
	BinarySearchTreeNode x = node;
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
     * @return          successor of an artist or null--BinarySearchTreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findPredecessor(Artist data) 
    {
        return findPredecessor(nodeWith(data,root));
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           findPredecessor()
     * Description      An overloaded recursive method to find the predecessor 
     *                  of an artist given a node
     * @param           node BinarySearchTreeNode
     * @return          predecessor of an artist or null--BinarySearchTreeNode
     * @author          <i>Niko Culevski</i>
     * Date             3/6/2021
     * History Log      2/25/2021
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findPredecessor(BinarySearchTreeNode node)
    {
	if (node == null)
            return null;
	
	if (node.left!= null)
            return findMax(node.left);
			
	BinarySearchTreeNode parent = findParent(node.data);

	BinarySearchTreeNode y = parent;
	BinarySearchTreeNode x = node;
	while (y != null && x == y.left)
	{
            x = y;
            y = findParent(y.data);
	}	
	return y;
    }    
}