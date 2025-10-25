package ru.nazarovsa.livecodingtraining.binarytree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeTasksTest {

    @Test
    void hasPathSum_ShouldReturnCorrectResults() {
        // Тест 1: Пример из задачи - дерево [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        // Путь 5->4->11->2 = 22
        BinaryTreeTasks.TreeNode root1 = new BinaryTreeTasks.TreeNode(5,
                new BinaryTreeTasks.TreeNode(4,
                        new BinaryTreeTasks.TreeNode(11,
                                new BinaryTreeTasks.TreeNode(7),
                                new BinaryTreeTasks.TreeNode(2)),
                        null),
                new BinaryTreeTasks.TreeNode(8,
                        new BinaryTreeTasks.TreeNode(13),
                        new BinaryTreeTasks.TreeNode(4,
                                null,
                                new BinaryTreeTasks.TreeNode(1))));

        assertThat(BinaryTreeTasks.hasPathSum(root1, 22)).isTrue();

        // Тест 2: Пример из задачи - дерево [1,2,3], targetSum = 5
        BinaryTreeTasks.TreeNode root2 = new BinaryTreeTasks.TreeNode(1,
                new BinaryTreeTasks.TreeNode(2),
                new BinaryTreeTasks.TreeNode(3));

        assertThat(BinaryTreeTasks.hasPathSum(root2, 5)).isFalse();

        // Тест 3: Пустое дерево
        assertThat(BinaryTreeTasks.hasPathSum(null, 1)).isFalse();

        // Тест 4: Дерево из одного узла - положительный случай
        BinaryTreeTasks.TreeNode root3 = new BinaryTreeTasks.TreeNode(5);
        assertThat(BinaryTreeTasks.hasPathSum(root3, 5)).isTrue();

        // Тест 5: Дерево из одного узла - отрицательный случай
        BinaryTreeTasks.TreeNode root4 = new BinaryTreeTasks.TreeNode(5);
        assertThat(BinaryTreeTasks.hasPathSum(root4, 10)).isFalse();

        // Тест 6: Отрицательные числа
        BinaryTreeTasks.TreeNode root5 = new BinaryTreeTasks.TreeNode(-3,
                new BinaryTreeTasks.TreeNode(9),
                new BinaryTreeTasks.TreeNode(20,
                        new BinaryTreeTasks.TreeNode(15),
                        new BinaryTreeTasks.TreeNode(7)));
        assertThat(BinaryTreeTasks.hasPathSum(root5, 6)).isTrue(); // -3 + 9 = 6

        // Тест 7: Несколько возможных путей, один из которых подходит
        BinaryTreeTasks.TreeNode root6 = new BinaryTreeTasks.TreeNode(1,
                new BinaryTreeTasks.TreeNode(2,
                        new BinaryTreeTasks.TreeNode(3),
                        new BinaryTreeTasks.TreeNode(4)),
                new BinaryTreeTasks.TreeNode(5));
        assertThat(BinaryTreeTasks.hasPathSum(root6, 6)).isTrue(); // 1 + 5 = 6
        assertThat(BinaryTreeTasks.hasPathSum(root6, 7)).isTrue(); // 1 + 2 + 4 = 7
        assertThat(BinaryTreeTasks.hasPathSum(root6, 10)).isFalse();
    }
}

