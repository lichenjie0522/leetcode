package easy;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * Assume that the total area is never beyond the maximum possible value of int.
 * 
 * @author lichenjie0522
 *
 */
public class No223_RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area1 = (C - A) * (D - B);
		int area2 = (G - E) * (H - F);
		int overlapArea = overlap(A, B, C, D, E, F, G, H);
		return area1 + area2 - overlapArea;
	}

	public int overlap(int A, int B, int C, int D, int E, int F, int G, int H) {
		int x1 = Math.max(A, E);
		int x2 = Math.min(C, G);
		int x = x2 - x1;
		int y1 = Math.max(B, F);
		int y2 = Math.min(D, H);
		int y = y2 - y1;
		if (x2 <= x1 || y2 <= y1) {
			return 0;
		}
		return x * y;
	}
}
