
public class PrimeNumberChecker {
    public Boolean validate(Integer primeNumber) {
        for (int i = 2; i < Math.sqrt(primeNumber * 1.0); i++) {
            if (primeNumber % i == 0)
                return false;
        }
        return true;
    }
}


//sto ocekuvame bidejki e boolean testot
//in out
//5 true
//2 true