// The solution of the problem was written by Izaron
// Date: 13:21:21   20 Aug 2016
// Execution time: 0.124

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
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] ms = new int[n];
        for (int i = 0; i < n; i++)
            ms[i] = in.nextInt() - 1;
        for (int i = 0; i < n; i++) {
            a[ms[i]] = 1;
            b[ms[i]] = n;
            for (int z = 0; z < i; z++)
                if (ms[z] > ms[i])
                    a[ms[i]]++;
            for (int z = i + 1; z < n; z++)
                if (ms[i] > ms[z])
                    b[ms[i]]--;
        }
        for (int i = 0; i < n; i++)
            out.println(a[i] + " " + b[i]);
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