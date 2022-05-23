
import java.util.ArrayList;
import java.util.List;


//object must implement 'Comparable' interface.
//object must have 'toString()' method implemented in order to be printed.



public class BinaryTree
{
    private Node rootNode;

    public BinaryTree()
    {
        rootNode = null;
    }

    public BinaryTree(Object[] objectsParameter)
    {
        if(objectsParameter.length > 0)
        {
            for(int i = 0; i < objectsParameter.length; i++)
            {
                addObject(objectsParameter[i]);
            }
        }
        else
        {
            rootNode = null;
        }
    }

    public void addObject(Object objectParameter)
    {
        if(rootNode == null)
        {
            rootNode = new Node(objectParameter, null);
        }
        else
        {
            @SuppressWarnings("unchecked")
            Comparable<Object> comparableObject = (Comparable<Object>)objectParameter;
            Node previousNode = rootNode;
            Node node = rootNode;
            boolean done = false;
            while(node != null)
            {
                if(comparableObject.compareTo(node.getObject()) < 0)
                {
                    previousNode = node;
                    node = node.getLeftChildNode();
                }
                else if(comparableObject.compareTo(node.getObject()) > 0)
                {
                    previousNode = node;
                    node = node.getRightChildNode();
                }
                else
                {
                    node.addCounter();
                    done = true;
                    break;
                }
            }
            if(done == false)
            {
                if(comparableObject.compareTo(previousNode.getObject()) < 0)
                {
                    previousNode.setLeftChildNode(new Node(objectParameter, previousNode));
                }
                else if(comparableObject.compareTo(previousNode.getObject()) > 0)
                {
                    previousNode.setRightChildNode(new Node(objectParameter, previousNode));
                }
            }
        }
    }

    public void print() //this method only prints order of binary tree elements in horizontal line
    {
        if(rootNode != null)
        {
            List<Node> nodes = new ArrayList<Node>();
            nodes.add(rootNode);
            System.out.println("");
            printElement(rootNode);
            System.out.println("");
            while(nodes.size() > 0)
            {
                List<Node> tempNodes = new ArrayList<Node>();
                for(int i = 0; i < nodes.size(); i++)
                {
                    if(nodes.get(i).getLeftChildNode() != null)
                    {
                        tempNodes.add(nodes.get(i).getLeftChildNode());
                        printElement(nodes.get(i).getLeftChildNode());
                    }
                    if(nodes.get(i).getRightChildNode() != null)
                    {
                        tempNodes.add(nodes.get(i).getRightChildNode());
                        printElement(nodes.get(i).getRightChildNode());
                    }
                }
                nodes = tempNodes;
                System.out.println("");
            }
        }
    }

    private void printElement(Node nodeParameter)
    {
        if(nodeParameter.getCounter() > 1)
        {
            System.out.print("|" + nodeParameter.getObject() + "(" +  + nodeParameter.getCounter() + ")|");
        }
        else
        {
            System.out.print("|" + nodeParameter.getObject() + "|"); 
        }
    }

    public Object getMinObject()
    {
        if(rootNode != null)
        {
            Node node = rootNode;
            while(node.getLeftChildNode() != null)
            {
                node = node.getLeftChildNode();
            }
            return node.getObject(); 
        }
        else
        {
            return null;
        }
    }

    public Object getMaxObject()
    {
        if(rootNode != null)
        {
            Node node = rootNode;
            while(node.getRightChildNode() != null)
            {
                node = node.getRightChildNode();
            }
            return node.getObject(); 
        }
        else
        {
            return null;
        }
    }

    private Node getNodeByObject(Object objectParameter)
    {
        @SuppressWarnings("unchecked")
        Comparable<Object> comparableObject = (Comparable<Object>)objectParameter;
        Node node = rootNode;
        while(node != null)
        {
            if(comparableObject.compareTo(node.getObject()) < 0)
            {
                node = node.getLeftChildNode();
            }
            else if(comparableObject.compareTo(node.getObject()) > 0)
            {
                node = node.getRightChildNode();
            }
            else
            {
                return node;
            }
        } 
        return null;
    }

    public Object getPreviousObject(Object objectParameter)
    {
        Node node = getNodeByObject(objectParameter);
        if(node == null)
        {
            return null;
        }
        else
        {
            if(node.getLeftChildNode() != null)
            {
                node = node.getLeftChildNode();
                while(node.getRightChildNode() != null)
                {
                    node = node.getRightChildNode();
                }
                return node.getObject();
            }
            else
            {
                if(node.getParentNode() == null)
                {
                    return null;
                }
                else
                {
                    while(node.getParentNode().getRightChildNode() != node)
                    {
                        if(node.getParentNode() != null)
                        {
                            node = node.getParentNode();
                            if(node.getParentNode() == null)
                            {
                                return null;
                            }
                        }
                        else
                        {
                            return null;
                        }
                    }
                    return node.getParentNode().getObject();
                }
            }
        }
    }

    public Object getNextObject(Object objectParameter)
    {
        Node node = getNodeByObject(objectParameter);
        if(node == null)
        {
            return null;
        }
        else
        {
            if(node.getRightChildNode() != null)
            {
                node = node.getRightChildNode();
                while(node.getLeftChildNode() != null)
                {
                    node = node.getLeftChildNode();
                }
                return node.getObject();
            }
            else
            {
                if(node.getParentNode() == null)
                {
                    return null;
                }
                else
                {
                    while(node.getParentNode().getLeftChildNode() != node)
                    {
                        if(node.getParentNode() != null)
                        {
                            node = node.getParentNode();
                            if(node.getParentNode() == null)
                            {
                                return null;
                            }
                        }
                        else
                        {
                            return null;
                        }
                    }
                    return node.getParentNode().getObject();
                }
            }
        }
    }
}


class Node
{
    private Node leftChildNode;
    private Node rightChildNode;
    private Object object;
    private int counter;
    private Node parentNode;

    public Node(Object objectParameter, Node parentNodeParameter)
    {
        object = objectParameter;
        leftChildNode = rightChildNode = null;
        counter = 1;
        parentNode = parentNodeParameter;
    }

    public void setLeftChildNode(Node childNodeParameter)
    {
        leftChildNode = childNodeParameter;
    }

    public void setRightChildNode(Node childNodeParameter)
    {
        rightChildNode = childNodeParameter;
    }

    public Node getLeftChildNode()
    {
        return leftChildNode;
    }

    public Node getRightChildNode()
    {
        return rightChildNode;
    }

    public Object getObject()
    {
        return object;
    }

    public void addCounter()
    {
        counter += 1;
    }

    public int getCounter()
    {
        return counter;
    }

    public Node getParentNode()
    {
        return parentNode;
    }
}
