package gold;
import java.io.*;
import java.util.*;

public class Q7570 {
    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("src/gold/input.txt"));
        int col = readInt();
        int row = readInt();
        int height = readInt();
        
        int complete = col * row * height;
        int[] q = new int[col * row * height * 3];
        int front = 0;
        int back = 0;
        boolean[][][] visited = new boolean[height][row][col];
        
        for (int i = 0; i < height; i++)
            for (int j = 0; j < row; j++)
                for (int k = 0; k < col; k++) {
                    switch (System.in.read()) {
                        case '-':
                            System.in.read();
                            visited[i][j][k] = true;
                            --complete;
                            break;
                        case '1':
                            visited[i][j][k] = true;
                            q[front] = i;
                            q[front + 1] = j;
                            q[front + 2] = k;
                            front += 3;
                            --complete;
                            break;
                    }
                    System.in.read();
                }
        
        int count = -1;
        int[] deltaX = {-1, 1, 0, 0, 0, 0};
        int[] deltaY = {0, 0, -1, 1, 0, 0};
        int[] deltaZ = {0, 0, 0, 0, -1, 1};
        
        while (back != front) {
            count++;
            
            int from = back;
            int end = front;
            back = front;
            
            for (int i = from; i < end; i += 3) {
                int z = q[i];
                int y = q[i + 1];
                int x = q[i + 2];
                
                for (int j = 0; j < 6; j++) {
                    int currentZ = z + deltaZ[j];
                    int currentY = y + deltaY[j];
                    int currentX = x + deltaX[j];
                    
                    if (currentZ >= 0 && currentZ < height &&
                       currentY >= 0 && currentY < row &&
                       currentX >= 0 && currentX < col &&
                       visited[currentZ][currentY][currentX] == false) {
                        --complete;
                        visited[currentZ][currentY][currentX] = true;
                        q[front] = currentZ;
                        q[front + 1] = currentY;
                        q[front + 2] = currentX;
                        front += 3;
                    }
                }
            }
        }
        
        System.out.print(complete == 0 ? count : -1);
    }
    
    public static int readInt() throws IOException {
        int n = 0;
        while (true) {
            int input = System.in.read();
            if (input > 32)
                n = (n << 3) + (n << 1) + (input & 15);
            else
                return n;
        }
    }
}