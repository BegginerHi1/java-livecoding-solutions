package ru.nazarovsa.livecodingtraining.binarytree;

public class BinaryTreeTasks {

    /**
     * Задача 39.
     * ИСПОЛЬЗОВАНО НА СОЗВОНЕ
     * Задача: Path Sum (Сумма пути)
     * <p>
     * Дано бинарное дерево и целое число targetSum. Определить, существует ли путь
     * от корня до листа, такой что сумма всех значений узлов на этом пути равна targetSum.
     * <p>
     * Лист - это узел, у которого нет дочерних узлов.
     * <p>
     * Примеры:
     * <p>
     * Пример 1:
     * Дерево:      5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * / \      \
     * 7   2      1
     * <p>
     * Ввод: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * Вывод: true
     * Объяснение: Путь 5->4->11->2 дает сумму 22
     * <p>
     * Пример 2:
     * Дерево:    1
     * / \
     * 2   3
     * <p>
     * Ввод: root = [1,2,3], targetSum = 5
     * Вывод: false
     * Объяснение: Есть два пути от корня до листьев:
     * - 1->2 (сумма = 3)
     * - 1->3 (сумма = 4)
     * Ни один из них не равен 5
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (targetSum - root.val == 0 & root.left == null & root.right == null) {
            return true;
        }
        boolean flag = false;
        if (root.left != null) {
            flag = hasPathSum(root.left, targetSum - root.val);
        }
        if (flag) {
            return true;
        }
        if (root.right != null) {
            flag = hasPathSum(root.right, targetSum - root.val);
        }

        return flag;
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this(val, null, null);
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
