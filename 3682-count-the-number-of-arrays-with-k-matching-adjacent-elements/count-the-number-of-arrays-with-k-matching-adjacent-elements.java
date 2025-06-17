class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX = 100_005; // Based on constraints

    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];

    // Precompute factorials and inverse factorials
    static {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 1; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    static long modInverse(long a) {
        return binExpo(a, MOD - 2);
    }

    static long binExpo(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) result = result * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return result;
    }

    static long nCr(int n, int r) {
        if (r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        long result = m * binExpo(m - 1, n - k - 1) % MOD;
        result = result * nCr(n - 1, k) % MOD;
        return (int) result;
    }
}
