# Efficient Computation of nCr % MOD using Fermat's Little Theorem

When `MOD` is a **prime number**, you can compute **nCr % MOD** efficiently using **Fermat's Little Theorem** to find modular inverses.

---


![image](https://github.com/user-attachments/assets/af1749fd-c9c9-4584-a419-0f94817661e8)



## 🔷 Formula Recap

The formula for computing **nCr modulo MOD** is:



Since direct division isn't valid under modular arithmetic, we use **modular inverses**.

---

## 📘 Fermat's Little Theorem

If `MOD` is prime, the modular inverse of `a` is:




This works because of **Fermat’s Little Theorem**, which says:



---

## ✅ Final Formula

We rewrite the nCr formula using modular inverses:



This approach ensures all divisions are replaced by multiplicative inverses under mod.

---

## 🔧 Implementation Outline (Java)

1. Precompute all factorials up to `n` modulo `MOD`
2. Precompute their modular inverses using `modPow(fact[i], MOD - 2)`
3. Use the formula to get the result

---

## 📌 Time Complexity

- Precomputation: `O(n)`
- Each nCr query: `O(1)`

Perfect for solving **combinatorics problems** in competitive programming!

---

## 🔐 Note

Make sure `MOD` is a **large prime** (commonly used: `10^9 + 7`, `998244353`).


