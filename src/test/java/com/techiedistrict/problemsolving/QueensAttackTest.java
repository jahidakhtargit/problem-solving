package com.techiedistrict.problemsolving;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueensAttackTest {
	
	@Test
	public void testExample1() {
		int n = 4;
		int k = 0;

		int qR = 4;
		int qC = 4;

		int[][] obstacles = {
				
		};
		
		int expected = 9;
		int actual = QueensAttack.queensAttack(n, k, qR, qC, obstacles);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testExample2() {
		int n = 5;
		int k = 3;

		int qR = 4;
		int qC = 3;

		int[][] obstacles = {
				{4, 2},
				{5, 5,},
				{2, 3}
		};
		
		int expected = 10;
		int actual = QueensAttack.queensAttack(n, k, qR, qC, obstacles);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testExample3() {
		int n = 8;
		int k = 8;

		int qR = 3;
		int qC = 5;

		int[][] obstacles = {
				{4, 5},
				{3, 6,},
				{5, 3},
				{2, 6},
				{4, 6},
				{2, 5},
				{2, 4},
				{3, 4}
		};
		
		int expected = 1;
		int actual = QueensAttack.queensAttack(n, k, qR, qC, obstacles);
		assertEquals(expected, actual);
	}

}
