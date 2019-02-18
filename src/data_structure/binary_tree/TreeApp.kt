package data_structure.binary_tree

/**
 * Author : Ray
 * Created At : 2019-02-17 5:31 PM
 * Email : ryu18356@gmail.com
 * Description :
 */
fun main(args:Array<String>) {
    val tree = Tree()
    tree.insert(20, 1.2)
    tree.insert(70, 2.5)
    tree.insert(30, 3.0)
    tree.insert(15, 42.0)
    tree.insert(28, 51.0)
    tree.inOrder(tree.root)
    println()
    println("minimum number in binary search tree is : " + tree.minimum())
    println("max number in binary search tree is : " + tree.max())
}