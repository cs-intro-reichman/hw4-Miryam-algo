public class Primes {
    public static void main(String[] args) {
        int upToNum = Integer.parseInt(args[0]);
        boolean [] checkPrime = new boolean [upToNum + 1];
        for (int i = 2; i < checkPrime.length; i++){
            checkPrime [i] = true;
        }

        for (int i = 0; i < checkPrime.length; i++){
            if (checkPrime[i] == true){
                int changeI = i;
                while (changeI + i < checkPrime.length){
                    checkPrime [changeI + i] = false;
                    changeI = changeI + i;
                }
            }
        }
        int countPrime = 0;
        System.out.println("Prime numbers up to " + upToNum + ":");
        for (int i = 0; i < checkPrime.length; i++){
            if (checkPrime[i]){
                System.out.println(i);
                countPrime ++;
            }
        }
        System.out.println("There are " + countPrime + " primes between 2 and " + upToNum + " (" + (countPrime * 100) / upToNum + "% are primes)");
    }
}