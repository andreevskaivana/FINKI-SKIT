public class PatternIndex {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Java Pattern Index Subject Pattern");
            return;
        }
        String subject = args[0];
        String pattern = args[0];

        int n = 0;
        if ((n = patternIndex(subject, pattern)) == -1)
            System.out.println("Pattern string is not a substring of the subject string");
        else
            System.out.println("Paatern string begins at character: " + n);
    }

    public static int patternIndex(String subject, String pattern) {
        final int NOTFOUND = -1;
        int iSub = 0;
        int returnIndex = NOTFOUND;
        boolean isPattern = false;
        int subjectLength = subject.length();
        int patternLength = pattern.length();


        while (isPattern == false && iSub + patternLength - 1 < subjectLength) {
            if (subject.charAt(iSub) == pattern.charAt(0)) {
                //starting at zero
                returnIndex = iSub;
                isPattern = true;
                for (int iPat = 1; iPat < patternLength; iPat++) {
                    if (subject.charAt(iSub + iPat) != pattern.charAt(iPat)) {
                        returnIndex = NOTFOUND;
                        isPattern = false;
                        break;
                    }
                }
            }
            iSub++;
        }
        return returnIndex;
    }

}
