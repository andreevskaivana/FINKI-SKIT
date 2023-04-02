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

    //1 - se definiraat subject i pattern def(1)=subject,pattern
    public static int patternIndex(String subject, String pattern) {
        //2-def(2)=na not found....i site promenlivi vo ovoj blok
        final int NOTFOUND = -1;
        int iSub = 0;
        int returnIndex = NOTFOUND;
        boolean isPattern = false;
        int subjectLength = subject.length();
        int patternLength = pattern.length();

        //3 jazol e while blok i tuka nema definiranje promenlivi
        //moze da definirame deka ako uslovot vo 3 ne e ispolnet direktno odi na return index
        //use(3,11)
        while (isPattern == false && iSub + patternLength - 1 < subjectLength) {
            if (subject.charAt(iSub) == pattern.charAt(0)) { //4
                //starting at zero
                //5 e definicija na ovie promenlivi plus pocetok iPat=1 na for ciklus
                //ima def i use tuka
                returnIndex = iSub;
                isPattern = true;
                //6 e ako ne e ispolnet uslovot(vtoriot del od for ciklus)
                for (int iPat = 1; iPat < patternLength; iPat++) {
                    //7 e vtoriot del od ciklusot ako e ispolnet vleguva vo for
                    //8 e ispolnet uslov-da napravi break
                    //9 e ako e == da se zgolemuva
                    //9 e posledniot del od for ciklusot
                    if (subject.charAt(iSub + iPat) != pattern.charAt(iPat)) {
                        //8 e definiranje na promenlivite i da odi vo break
                        returnIndex = NOTFOUND;
                        isPattern = false;
                        break;
                    }
                }
            }
            iSub++; //10,ako 4 ne e ispolneto ide tuka,ako 6 ne e ispolneto ide tuka , 8 ide tuka
        }
        return returnIndex; //1
    }

}
