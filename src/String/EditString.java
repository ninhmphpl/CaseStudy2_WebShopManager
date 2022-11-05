package String;

public class EditString {
    private static void up(char[] arr, int i){
        arr[i] = Character.toUpperCase(arr[i]);
    }
    public static String upperCaseAlphabetOfWord(String string){
        if (string.isEmpty())return "";
        char[] arrString = string.toCharArray();
        up(arrString,0);
        for (int i = 1; i < arrString.length; i++){
            if (arrString[i-1] == ' '){
                up(arrString,i);
            }
        }
        return new String(arrString);
    }
    public static String upperCaseAlphabetOfWord2(String string){
        StringBuilder builder = new StringBuilder(string);
        if (builder.isEmpty()) return "";
        builder.setCharAt(0, Character.toUpperCase(builder.charAt(0)));
        for (int i = 1 ; i < builder.length() ; i ++){
            if(builder.charAt(i-1) == ' '){
                builder.setCharAt(i, Character.toUpperCase(builder.charAt(i)));
            }
        }
        return builder.toString();
    }





}
