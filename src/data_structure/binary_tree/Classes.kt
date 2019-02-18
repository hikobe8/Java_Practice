package data_structure.binary_tree


/**
 * Author : Ray
 * Created At : 2019-02-17 5:25 PM
 * Email : ryu18356@gmail.com
 * Description : 二叉树的节点
 */
data class Node(var iData: Int, var fData: Double, var leftChild: Node?, var rightChild: Node?) {

    constructor() : this(0, 0.0, null, null)

    fun displayNode() {

    }
}

class Tree {
    var root: Node? = null

    fun find(key: Int): Node? {
        var current: Node? = root
        while (current?.iData != key) {
            if (key < current?.iData!!) {
                current = current.leftChild
            } else {
                current = current.rightChild
            }
            if (current == null) {
                return null
            }
        }
        return current

    }

    fun insert(id: Int, dd: Double) {
        val newNode = Node()
        newNode.iData = id
        newNode.fData = dd
        if (root == null) {
            //创建根结点
            root = newNode
        } else {
            //开始查找
            var current = root
            var parent: Node? = null
            while (true) {
                parent = current
                if (id < current!!.iData) {
                    current = current.leftChild //移动到左子节点
                    if (current == null) {
                        parent!!.leftChild = newNode
                        return
                    }
                } else {
                    current = current.rightChild
                    if (current == null) {
                        parent!!.rightChild = newNode
                        return
                    }
                }
            }
        }

    }

    fun delete(id: Int) {

    }

    /**
     * 中序遍历
     */
    fun inOrder(root:Node?) {
        if (root != null) {
            inOrder(root.leftChild)
            print("${root.fData} ")
            inOrder(root.rightChild)
        }
    }

    /**
     * 得到二叉搜索树中的最小值，即最左叶子节点的值
     */
    fun minimum(): Node? {
        var current = root
        var last: Node? = null
        while (current != null) {
            last = current
            current = current.leftChild
        }
        return last
    }

    fun max():Node? {
        var current = root
        var last: Node? = null
        while (current != null) {
            last = current
            current = current.rightChild
        }
        return last
    }

}
   