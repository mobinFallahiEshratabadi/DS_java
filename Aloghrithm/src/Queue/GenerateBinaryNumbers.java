package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public String[] generateBinary(int n) {
        String[] result = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i = 1; i < n; i++) {
            result[i] = q.poll();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            q.offer(s1);
            q.offer(s2);
        }
        return result;
    }
}
