

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        //TEST1
        Object[] objects1 = {5, 2 ,4 ,6 ,7 ,8, 9, 3, 1};
        test(objects1, 4, 0, 2);
        //TEST2
        Object[] objects2 = {20, 17, 32, 25, 60, 14, 11, 16, 70};
        test(objects2, 20, 48, 14);
        //TEST3
        Object[] objects3 = {61, 47, 78, 46, 53, 56, 55, 57, 75, 80, 76, 51, 50, 52};
        test(objects3, 61, 72, 53);
    }

    private static void test(Object[] objectsParameter, Object objectParameter, Object objectToAddParameter, Object objectToRemoveParameter)
    {
        System.out.println("////////////////////////////////////////////////////////////////");
        BinaryTree binaryTree = new BinaryTree(objectsParameter);
        binaryTree.print();
        System.out.println("min: " + binaryTree.getMinObject());
        System.out.println("max: " + binaryTree.getMaxObject());
        System.out.println("previous object of '" + objectParameter + "': " + binaryTree.getPreviousObject(objectParameter));
        System.out.println("next object of '" + objectParameter + "': " + binaryTree.getNextObject(objectParameter));
        System.out.println("inorder: ");
        binaryTree.printInorder();
        System.out.println("");
        System.out.println("preorder: ");
        binaryTree.printPreorder();
        System.out.println("");
        System.out.println("postorder: ");
        binaryTree.printPostorder();
        //adding object
        System.out.println("");
        System.out.println("");
        System.out.println("adding " + objectToAddParameter + ": ");
        binaryTree.addObject(objectToAddParameter);
        binaryTree.print();
        System.out.println("min: " + binaryTree.getMinObject());
        System.out.println("max: " + binaryTree.getMaxObject());
        System.out.println("previous object of '" + objectParameter + "': " + binaryTree.getPreviousObject(objectParameter));
        System.out.println("next object of '" + objectParameter + "': " + binaryTree.getNextObject(objectParameter));
        System.out.println("inorder: ");
        binaryTree.printInorder();
        System.out.println("");
        System.out.println("preorder: ");
        binaryTree.printPreorder();
        System.out.println("");
        System.out.println("postorder: ");
        binaryTree.printPostorder();
        //removing object
        System.out.println("");
        System.out.println("");
        System.out.println("removing " + objectToRemoveParameter + ": ");
        binaryTree.removeObject(objectToRemoveParameter);
        binaryTree.print();
        System.out.println("min: " + binaryTree.getMinObject());
        System.out.println("max: " + binaryTree.getMaxObject());
        System.out.println("previous object of '" + objectParameter + "': " + binaryTree.getPreviousObject(objectParameter));
        System.out.println("next object of '" + objectParameter + "': " + binaryTree.getNextObject(objectParameter));
        System.out.println("inorder: ");
        binaryTree.printInorder();
        System.out.println("");
        System.out.println("preorder: ");
        binaryTree.printPreorder();
        System.out.println("");
        System.out.println("postorder: ");
        binaryTree.printPostorder();
        System.out.println("");
        System.out.println("////////////////////////////////////////////////////////////////");
    }
}
