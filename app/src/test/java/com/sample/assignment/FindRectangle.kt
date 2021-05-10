package com.sample.assignment

import org.junit.Test
import java.util.*

/**
 * Created by Nguyen Minh Thuan on 5/10/21.
 * com.sample.assignment
 */
class FindRectangle {
    /**
     * Get square distance between 2 points
     */
    private fun getDistance(a: IntArray, b: IntArray): Int {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1])
    }

    /**
     * Find the center point of rectangle is the same
     */
    private fun calculateCenterPoint(a: IntArray, b: IntArray, c: IntArray): IntArray {
        val d = IntArray(2)
        d[0] = a[0] + b[0] - c[0]
        d[1] = a[1] + b[1] - c[1]
        return d
    }

    /**
     * Find the fourth point of rectangle from triangle
     */
    private fun findFourth(arrData: Array<IntArray>): IntArray? {
        if (arrData.size == 3) {
            val d1 = getDistance(arrData[0], arrData[1])
            val d2 = getDistance(arrData[0], arrData[2])
            val d3 = getDistance(arrData[1], arrData[2])
            return when {
                d1 + d2 == d3 -> {//arrData[0] is square angle
                    calculateCenterPoint(arrData[1], arrData[2], arrData[0])
                }
                d1 + d3 == d2 -> {//arrData[1] is square angle
                    calculateCenterPoint(arrData[0], arrData[2], arrData[1])
                }
                d2 + d3 == d1 -> {//arrData[2] is square angle
                    calculateCenterPoint(arrData[1], arrData[0], arrData[2])
                }
                else -> {
                    println("these are not 3 points of a rectangle.")
                    null
                }
            }
        }
        return null
    }

    @Test
    fun `solution Test`() {
        val arr = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(1, 2)
        )
        val arr2 = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(3, 4),
            intArrayOf(3, 10)
        )
        val arr3 = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 0),
            intArrayOf(4, 2)
        )
        findFourth(arr)?.let {
            println(Arrays.toString(it))
        }
        findFourth(arr2)?.let {
            println(Arrays.toString(it))
        }
        findFourth(arr3)?.let {
            println(Arrays.toString(it))
        }
        // this is not triangle
        val arr4 = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 0),
            intArrayOf(4, 3)
        )
        findFourth(arr4)?.let {
            println(Arrays.toString(it))
        }
    }
}