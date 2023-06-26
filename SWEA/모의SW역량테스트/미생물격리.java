package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 미생물격리 {
	static class Cell {
		int r, c, num, dir;

		Cell(int r, int c, int num, int dir) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
		}
	}

	static int N, M, K, result;
	static ArrayList<Cell>[][] cellList;
	static ArrayList<Cell> cells;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cells = new ArrayList<>();
			cellList = new ArrayList[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cellList[i][j] = new ArrayList<>();
				}
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				cells.add(new Cell(r, c, num, dir));
			}
			
			while(M-- > 0) {
				moveCells();
				changeCells();
				addCells();
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static void moveCells() {
		for (Cell cell : cells) {
			cell.r += dx[cell.dir];
			cell.c += dy[cell.dir];
			
			cellList[cell.r][cell.c].add(cell);
		}
	}
	static void changeCells() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cellList[i][j].size() > 0) {
					if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
						for (Cell cell : cellList[i][j]) {
							cell.num = (int) cell.num / 2;
							cell.dir = changeDir(cell.dir);
						}
					}
					
					if (cellList[i][j].size() >= 2) {
						int sum = 0;
						int max = 0;
						int dir = 0;
						for (Cell cell : cellList[i][j]) {
							sum += cell.num;
							if (cell.num > max) {
								max = cell.num;
								dir = cell.dir;
							}
						}
						cellList[i][j].clear();
						cellList[i][j].add(new Cell(i, j, sum, dir));
					}
				}
			}
		}
	}
	static void addCells() {
		cells.clear();
		result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cellList[i][j].size() > 0) {
					for (Cell cell : cellList[i][j]) {
						cells.add(cell);
						result += cell.num;
					}
					cellList[i][j].clear();
				}
			}
		}
	}
	static int changeDir(int dir) {
		if (dir == 1) {
			dir = 2;
		} else if (dir == 2){
			dir = 1;
		} else if (dir == 3) {
			dir = 4;
		} else if (dir == 4) {
			dir = 3;
		}
		return dir;
	}
}
