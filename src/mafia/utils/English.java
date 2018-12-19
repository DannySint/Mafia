package mafia.utils;

public class English
{

    public English()
    {
    }

    private static String VOWELS = "AEIOU";
    private static boolean isVowel(char c)
    {
        return VOWELS.indexOf(Character.toUpperCase(c)) >= 0;
    }
}
