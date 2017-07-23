// The solution of the problem was written by Izaron
// Date: 13:19:20   29 May 2016
// Execution time: 0.109

// Please do not copy-paste the solution.
// Try to understand what is happening here and write your own.

import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class Main {
    FastScanner in;
    PrintWriter out;

    static final String FILE = "";

    public void solve() {
        int k = in.nextInt();
        int as[] = new int[k];
        for (int i = 0; i < k; i++)
            as[i] = in.nextInt();

        ArrayList<PairInt> list = new ArrayList<>();
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        for (int z = -1000*20; z <= 1000*20; z++) {
            int tmp = z;
            for (int i = 0; i < k; i++)
                tmp = abs(tmp - as[i]);

            if (tmp <= 1) {
                left = min(left, z);
                right = max(right, z);
            } else {
                if (right >= left)
                    list.add(new PairInt(left, right));
                left = Integer.MAX_VALUE;
            }
        }

        if (right >= left)
            list.add(new PairInt(left, right));

        out.println(list.size());
        for (PairInt pair : list)
            out.println(pair.a + " " + pair.b);
    }

    public void run() {
        if (FILE.equals("")) {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            try {
                in = new FastScanner(new FileInputStream(FILE +
                        ".in"));
                out = new PrintWriter(new FileOutputStream(FILE +
                        ".out"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        solve();
        out.close();
    }

    public static void main(String[] args) {
        (new Main()).run();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }
    }

    class Pair<A extends Comparable<A>, B extends Comparable<B>>
            implements Comparable<Pair<A, B>> {
        public A a;
        public B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair<A, B> o) {
            if (o == null || o.getClass() != getClass())
                return 1;
            int cmp = a.compareTo(o.a);
            if (cmp == 0)
                return b.compareTo(o.b);
            return cmp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (a != null ? !a.equals(pair.a) : pair.a != null) return
                    false;
            return !(b != null ? !b.equals(pair.b) : pair.b != null);
        }
    }

    class PairInt extends Pair<Integer, Integer> {
        public PairInt(Integer u, Integer v) {
            super(u, v);
        }
    }

    class PairLong extends Pair<Long, Long> {
        public PairLong(Long u, Long v) {
            super(u, v);
        }
    }

}