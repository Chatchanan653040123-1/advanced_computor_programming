package panyaprasirtkit.chatchanan.lab2;

/**
 * This StringAPI program is to check the keyword
 * "university","University","college","College"
 * If program found these keyword then It's will
 * display "<schoolName> is a college" or "<schoolName> is a university"
 * if it's not found the it's will display "<schoolName> is neither a university
 * or a college"
 *
 * Author: Chatchanan Panyaprasirtkit
 * ID: 653040123-1
 * Sec: 2
 * Date: December 9, 2022
 *
 **/
class StringAPI {

    public static void main(String[] args) {
        String schoolName = args[0];
        String[] arrayOfKeyWord = { "university", "college" }; // You can add more keyword here!
        /*
         * Check keywords in <schoolName> If the keywords is match then display
         * "<schoolName> is a college" or "<schoolName> is a university" by check
         * the condition in for-loop.
         */
        try {
            for (int i = 0; i > -1; i++) {
                if (schoolName.toLowerCase().indexOf(arrayOfKeyWord[i].toLowerCase()) != -1) {
                    System.out.println(schoolName + String.format(" is a %s", arrayOfKeyWord[i]));
                    break;
                }
            }
        }
        /*
         * If the <schoolName> don't have keyword then
         * display "<schoolName> is neither a university or college"
         */
        catch (Exception e) {
            System.out.println(schoolName + " is neither a university or a college");
        }
    }
}
