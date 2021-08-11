package eu.tlach;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndValidString {
    public static String isValid(String s) {
        Map<Character, Integer> letters = new HashMap<>();
        boolean flag = true;

        for (Character letter : s.toCharArray()) {
            letters.compute(letter, (k, v) -> (v == null) ? 1 : v + 1);
        }

        Integer previous = letters.get(s.charAt(0));
        int numOfHigher = 0;
        for (Integer value : letters.values()) {
            if (!value.equals(previous)) {
                int diff = Math.abs(previous - value);
                if (diff >= 1) {
                    numOfHigher++;
                    if (numOfHigher > 1) {
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (flag) {
            return "YES";
        } else {
            return "NO";
        }

    }

    public static void main(String[] args) {
        String firstYesCase = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";

        // System.out.println(isValid("aabbcd"));

        System.out.println(isValid(firstYesCase));
    }
}
