package data_structure.binary_tree

/**
 * Author : Ray
 * Created At : 2019-02-17 5:31 PM
 * Email : ryu18356@gmail.com
 * Description :
 */
fun main(args: Array<String>) {
    val tree = Tree()
    tree.insert(20, 1.2)
    tree.insert(70, 2.5)
    tree.insert(30, 3.0)
    tree.insert(15, 42.0)
    tree.insert(28, 51.0)
    tree.insert(80, 52.0)
    tree.insert(90, 53.0)
    tree.insert(72, 54.0)
    println("先序遍历 : ")
    tree.preOrder()
    println()
    println("中序遍历 : ")
    tree.inOrder()
    println()
    println("后序遍历 : ")
    tree.postOrder()
    println()
    println("minimum number in binary search tree is : " + tree.minimum())
    println("max number in binary search tree is : " + tree.max())
    tree.delete(70)
    println("删除 70 后先序遍历 : ")
    tree.preOrder()
    tree.delete(20)
    println("删除 20 后先序遍历 : ")
    tree.preOrder()
    tree.delete(28)
    println("删除 28 后先序遍历 : ")
    tree.preOrder()
}