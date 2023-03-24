package panyaprasirtkit.chatchanan.lab2;

/**
 * This DataTypes program is to print and declare these following variables:
 * 
 * 1. your name (firstname lastname)
 * 2. your student ID
 * 3. the first letter of your first name
 * 4. boolean value
 * 5. the Octal value of the last two digits of your ID number to Decimal
 * 6. the Hexadecimal value of the last two digits of your ID number to Decimal
 * 7. the Long value of the last two digits of your ID number
 * 8. the last two digits of your ID number and has the floating point of the
 * first two digits of your ID number with float value
 * 9. the last two digits of your ID number and has the floating point of the
 * last two digits of current year with double value
 * 
 * Author: Chatchanan Panyaprasirtkit
 * ID: 653040123-1
 * Sec: 2
 * Date: December 9, 2022
 *
 **/
class DataTypes {
    public static void main(String[] args) {
        String firstname_lastname = "Chatchanan Panyaprasirtkit";
        String student_id = "6530401231";
        char theFirstLetterOfYourFirstName = firstname_lastname.charAt(0);// charAt(index)
        boolean value_boolean = true;
        int lastTwoNumberOctalToDec = Integer.parseInt("37", 8);// 37 is 31's Octal
        int lastTwoNumberHexToDec = 0x1f;// This is 31's Hexadecimal
        long lastTwoNumberStringToLong = Long.parseLong("31");
        float lastTwoNumberStringToFloat = Float.parseFloat("31.65");
        double lastTwoNumberStringToDouble = Double.parseDouble("31.22");
        System.out.println("My name is " + firstname_lastname);
        System.out.println("My student ID was " + student_id);
        System.out.print(theFirstLetterOfYourFirstName + " ");
        System.out.print(value_boolean + " ");
        System.out.print(lastTwoNumberOctalToDec + " ");
        System.out.println(lastTwoNumberHexToDec);
        System.out.print(lastTwoNumberStringToLong + " ");
        System.out.print(lastTwoNumberStringToFloat + " ");
        System.out.print(lastTwoNumberStringToDouble);

    }
}
