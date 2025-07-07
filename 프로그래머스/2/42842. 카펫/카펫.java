import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int height = 3; height <= total / height; height++) {
            if (total % height != 0) continue;

            int width = total / height;
            int center = (width - 2) * (height - 2);
            if (center == yellow) {
                return new int[]{width, height};
            }
        }

        return new int[0];
    }
}
