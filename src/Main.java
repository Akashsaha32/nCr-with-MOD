import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final int MOD = 1000000007;
    private static int[] fact;
    private static int[] invFact;

    public static void main(String[] args) {
        int n = 100000;
        int r = 5;
        factorial(n);
        //System.out.println("Factorial of 5 is: " + Arrays.toString(fact));
        System.out.println(n+"C"+r+" = "+(fact[n]/((1L * fact[r]*fact[n-r]) % MOD)));

        System.out.println("\n\nAnother Direcxt answer: \n\n");
        long rslt = 1L * fact[n];
        rslt = (rslt * (modPowerCalculation(fact[r], MOD-2) % MOD)) % MOD;
        rslt = (rslt * (modPowerCalculation(fact[n-r], MOD-2) % MOD)) % MOD;
        System.out.println("Direct Answer: "+rslt);

        System.out.println("\n\nNow compute Inverse Factorial:..............\n\n\n");


        long res = 1L * fact[n];              // cast to long
        res = (res * (invFact[r] % MOD)) % MOD;         // mod after each multiplication
        res = (res * (invFact[n-r] % MOD)) % MOD;

        System.out.println(n + "C" + r + " = " + res);

    }

    private static void factorial(int n){
        fact = new int[n+1];
        invFact = new int[n+1];

        fact[0] = 1;
        for(int i=1; i<=n; i++){
            fact[i] = (int)((1L * fact[i-1]*i) % MOD);
        }

        invFact[n] = modPowerCalculation(fact[n], MOD - 2); // Fermat's Little Theorem
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = (int)(( 1L * invFact[i + 1] * (i + 1)) % MOD);
        }
    }

    private static int modPowerCalculation(int base, int exp){
        long temp = base % MOD;
        long rslt = 1;

        while(exp > 0){
            if(exp % 2 == 1){
                rslt = (rslt *temp) % MOD;
            }
            temp = (temp * temp) % MOD;
            exp = exp / 2;
        }
        return (int) rslt;
    }
}