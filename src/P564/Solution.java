package P564;

class Solution {

    private boolean allNine(long number) {
        while (number > 0) {
            if (number % 10 != 9)
                return false;
            number /= 10;
        }
        return true;
    }

    private long generatePali(long number, boolean isEvenLong) {
        long current = number;
        long result = number;
        if (!isEvenLong) {
            current /= 10;
        }
        while (current > 0) {
            result = result * 10 + current % 10;
            current /= 10;
        }
        return result;
    }

    public String nearestPalindromic(String n) {
        if (n.length() == 1) {
            return "" + (char) (n.charAt(0) - 1);
        }
        int l = n.length();
        long original = Long.valueOf(n);
        long leftHalf = Long.valueOf(n.substring(0, (l + 1) / 2));
        long[] candidate = new long[3];
        boolean isEvenLong = (l % 2 == 0);
        candidate[0] = generatePali((allNine(leftHalf) && !isEvenLong) ? (leftHalf + 1) / 10
                : leftHalf + 1, allNine(leftHalf) ? !isEvenLong : isEvenLong);
        candidate[1] = generatePali(leftHalf, isEvenLong);
        candidate[2] = generatePali(
                (allNine(leftHalf - 1) && isEvenLong) ? (leftHalf - 1) * 10 + 9 : (leftHalf - 1),
                allNine(leftHalf - 1) ? !isEvenLong : isEvenLong);
        long result;
        for (int i = 0; i < 3; i++)
            System.out.print(candidate[i] + " ");
        System.out.println();
        if (candidate[1] == original) {
            result = ((candidate[0] - original) < (original - candidate[2]) ? candidate[0] : candidate[2]);
        } else if (candidate[1] < original) {
            result = ((candidate[0] - original) < (original - candidate[1]) ? candidate[0] : candidate[1]);
        } else {
            result = ((candidate[1] - original) < (original - candidate[2]) ? candidate[1] : candidate[2]);
        }
        return String.valueOf(result);
    }
}