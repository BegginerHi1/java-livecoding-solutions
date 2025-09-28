package ru.nazarovsa.livecodingtraining.matrix;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatrixTasksTest {

    @Test
    void diagonalSum_VariousMatrices_ReturnsCorrectSum() {
        int[][] mat1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThat(MatrixTasks.diagonalSum(mat1)).isEqualTo(25);

        int[][] mat2 = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        assertThat(MatrixTasks.diagonalSum(mat2)).isEqualTo(8);

        int[][] mat3 = new int[][]{{5}};
        assertThat(MatrixTasks.diagonalSum(mat3)).isEqualTo(5);

        int[][] mat4 = new int[][]{
                {1, 2},
                {3, 4}
        };
        assertThat(MatrixTasks.diagonalSum(mat4)).isEqualTo(10);

        int[][] mat5 = new int[][]{
                {1, -2, 3, -4, 5},
                {-6, 7, -8, 9, -10},
                {11, -12, 13, -14, 15},
                {-16, 17, -18, 19, -20},
                {21, -22, 23, -24, 25}
        };
        assertThat(MatrixTasks.diagonalSum(mat5)).isEqualTo(117);
    }
}


