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

    /**
     * 删除节点，有3种情况
     * 1.没有子节点，即叶子节点
     * 2.只有一边子树的节点
     * 3.有两个子树的节点
     *
     */
    fun delete(key: Int): Boolean {
        var current = root
        var parent = root
        var isLeftChild = false
        while (current?.iData != key) {
            parent = current!!
            if (key < current.iData) {
                isLeftChild = true
                current = current.leftChild
            } else {
                isLeftChild = false
                current = current.rightChild
            }
            if (current == null) {
                return false
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            //叶子节点
            if (current == root) {
                //当前节点为根节点的话直接清空整棵树
                root = null
            } else {
                if (isLeftChild) {
                    parent!!.leftChild = null
                } else {
                    parent!!.rightChild = null
                }
            }
        } else if (current.leftChild == null) {
            //删除只有右子树的节点
            if (current == root) {
                root = current.rightChild
            } else {
                if (isLeftChild) {
                    parent!!.leftChild = current.rightChild
                } else {
                    parent!!.rightChild = current.rightChild
                }
            }
        } else if (current.rightChild == null) {
            //删除只有左子树的节点
            if (current == root) {
                root = current
            } else {
                if (isLeftChild) {
                    parent!!.leftChild = current.leftChild
                } else {
                    parent!!.rightChild = current.leftChild
                }
            }
        } else {
            //删除有两个子树的节点
            println("删除节点 ${current.iData}")
            val findSuccessor = findSuccessor(current)
            println("继任节点 " + findSuccessor?.iData)
            if (isLeftChild) {
                parent!!.leftChild = null
            } else {
                parent!!.rightChild = null
            }
            if (current == root) {
               root = findSuccessor
            }
        }
        return true
    }

    /**
     * 找到该节点的继任节点，策略为查找该节点右子树的最小点
     */
    private fun findSuccessor(node: Node?): Node? {
        //执行该方法的前提是必定有两个子节点
        var current = node
        var parent = current
        var last: Node? = null
        while (current != null) {
            last = current
            parent = current
            current = current.leftChild
        }
        return parent
    }

    /**
     * 先序遍历
     */
    fun preOrder(root: Node? = this.root) {
        if (root != null) {
            print("${root.iData} ")
            preOrder(root.leftChild)
            preOrder(root.rightChild)
        }
    }

    /**
     * 中序遍历
     */
    fun inOrder(root: Node? = this.root) {
        if (root != null) {
            inOrder(root.leftChild)
            print("${root.iData} ")
            inOrder(root.rightChild)
        }
    }

    /**
     * 后序序遍历
     */
    fun postOrder(root: Node? = this.root) {
        if (root != null) {
            postOrder(root.leftChild)
            postOrder(root.rightChild)
            print("${root.iData} ")
        }
    }

    /**
     * 得到二叉搜索树中的最小值，即最左叶子节点的值
     */
    fun minimum(root: Node? = this.root): Node? {
        var current = root
        var last: Node? = null
        while (current != null) {
            last = current
            current = current.leftChild
        }
        return last
    }

    fun max(): Node? {
        var current = root
        var last: Node? = null
        while (current != null) {
            last = current
            current = current.rightChild
        }
        return last
    }

}
   