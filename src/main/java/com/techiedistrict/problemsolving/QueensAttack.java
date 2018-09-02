package com.techiedistrict.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class QueensAttack {
	
	static int queensAttack(int n, int k, int qR, int qC, int[][] obstacles) {
		int count = 0;

		List<Integer> listLeft = new ArrayList<>();
		List<Integer> listRight = new ArrayList<>();
		List<Integer> listUp = new ArrayList<>();
		List<Integer> listDown = new ArrayList<>();

		List<Integer> listLeftUp = new ArrayList<>();
		List<Integer> listRightUp = new ArrayList<>();
		List<Integer> listLeftDown = new ArrayList<>();
		List<Integer> listRightDown = new ArrayList<>();

		if(k != 0) {
			for(int i=0; i<obstacles.length; i++) {

				if(obstacles[i][0] == qR) {
					if(obstacles[i][1] < qC) {
						listLeft.add(obstacles[i][1]);
					} else {
						listRight.add(obstacles[i][1]);
					}
				}

				if(obstacles[i][1] == qC) {
					if(obstacles[i][0] > qR) {
						listUp.add(obstacles[i][0]);
					} else {
						listDown.add(obstacles[i][0]);
					}
				}

				if(obstacles[i][0] > qR) {
					if(obstacles[i][0] - qR == qC - obstacles[i][1]) {
						listLeftUp.add(obstacles[i][0]);
					} else if(obstacles[i][0] - qR == obstacles[i][1] - qC) {
						listRightUp.add(obstacles[i][0]);
					}
				} else if(obstacles[i][0] < qR) {
					if(qR - obstacles[i][0] == qC - obstacles[i][1]) {
						listLeftDown.add(obstacles[i][0]);
					} else if(qR - obstacles[i][0] == obstacles[i][1] - qC) {
						listRightDown.add(obstacles[i][0]);
					}
				}
			}
		}

		if(listLeft.isEmpty()) {
			count = count + qC - 1;
		} else {
			count = count + qC - findMax(listLeft) - 1;
		}

		if(listRight.isEmpty()) {
			count = count + n - qC;
		} else {
			count = count + findMax(listRight) - qC - 1;
		}

		if(listUp.isEmpty()) {
			count = count + n - qR;
		} else {
			count = count + findMin(listUp) - qR - 1;
		}

		if(listDown.isEmpty()) {
			count = count + qR - 1;
		} else {
			count = count + qR - findMax(listDown) - 1;
		}


		if(listLeftUp.isEmpty()) {
			int r = qR;
			int c = qC;

			if( !(qR == n || qC == 1) ) {
				while(true) {
					count = count + 1;
					r++;
					c--;

					if(r==n || c==1) {
						break;
					}
				}
			}

		} else {
			count = count + findMin(listLeftUp) - qR - 1;
		}

		if(listRightUp.isEmpty()) {
			int r = qR;
			int c = qC;

			if( !(qR == n || qC == n) ) {
				while(true) {
					count = count + 1;
					r++;
					c++;

					if(r==n || c==n) {
						break;
					}
				}
			}
		} else {
			count = count + findMin(listRightUp) - qR - 1;
		}

		if(listLeftDown.isEmpty()) {
			int r = qR;
			int c = qC;

			if( !(qR == 1 || qC == 1) ) {
				while(true) {
					count = count + 1;
					r--;
					c--;

					if(r==1 || c==1) {
						break;
					}
				}
			}
		} else {
			count = count + qR - findMax(listLeftDown) - 1;
		}
	
		if(listRightDown.isEmpty()) {
			int r = qR;
			int c = qC;

			if( !(qR == 1 || qC == n) ) {
				while(true) {
					count = count + 1;
					r--;
					c++;

					if(r==1 || c==n) {
						break;
					}
				}
			}
		} else {
			count = count + qR - findMax(listRightDown) - 1;
		}

		return count;
	}
	
	public static int findMax(List<Integer> list) {
		int max = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) > max) {
				max = list.get(i);
			}
		}
		return max;
	}
	
	public static int findMin(List<Integer> list) {
		int min = list.get(0);
		for(int i=1; i<list.size(); i++) {
			if(list.get(i) < min) {
				min = list.get(i);
			}
		}
		
		return min;
	}

}
