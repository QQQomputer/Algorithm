package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//성훈이 코드
//84ms -> 84ms 별 차이 없음
//why => 똑같은 O(N)을 3번 따로 돌리든 같이 돌리든 속도는 똑같다 비슷하다.
public class BOJ14719_G5_빗물_ver성훈_최적화해보기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[w];
        int maxHeight = 0;
        int standardIdx = 0;
        int sum = 0;
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (maxHeight < arr[i]) {
                maxHeight = arr[i];
                standardIdx = i;
            }
            sum+=arr[i];
        }

        int area = maxHeight;
        int leftMax = 0;
        int rightMax = 0;

        // 기준 인덱스 왼쪽 영역
        for (int i = 0; i < standardIdx; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            area += leftMax;
        }
        // 기준 인덱스 오른쪽 영역(꼭 거꾸로 순회해야 함!)
        for (int i = w - 1; i > standardIdx; i--) {
            rightMax = Math.max(rightMax, arr[i]);
            area += rightMax;
        }
        area -= sum;
        System.out.println(area);
    }

}