class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i <= high; i++){
            if(isSymmetricNumber(i)){
                count++;
            }
        }
        return count;
    }

    boolean isSymmetricNumber(int num){
        if((10 <= num && num <= 99) && (num % 11 == 0)){
            return true;
        }

        else if(1000 <= num && num <= 9999){
            int first = (num / 1000);
            int second = (num /100) % 10;
            int third = (num / 10) % 10;
            int forth = (num / 1) % 10;

            return ((first + second) == (third + forth));
        }

        return false;
    }
}