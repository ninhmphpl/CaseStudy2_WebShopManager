package String;

import org.junit.jupiter.api.Test;


class EditStringTest {

    @Test
    void name() {
        String a = "pham hai ninh";
        System.out.println(EditString.upperCaseAlphabetOfWord2(a));
    }
    @Test
    void name1() {
        String a = "nGUYE tHi Van";
        System.out.println(EditString.upperCaseAlphabetOfWord2(a));
    }
    @Test
    void name2() {
        String a = "pham 3498  a b  B  ! oi  i i i  a    a - = ";
        System.out.println(EditString.upperCaseAlphabetOfWord2(a));
    }
    @Test
    void name3() {
        String a = "pham   hai ninh";
        System.out.println(EditString.upperCaseAlphabetOfWord2(a));
    }
    @Test
    void name4() {
        String a = "pham  hai ninh";
        System.out.println(EditString.upperCaseAlphabetOfWord2(a));
    }
    @Test
    void name5() {
        String a = "";
        System.out.println(EditString.upperCaseAlphabetOfWord2(a));
    }
}