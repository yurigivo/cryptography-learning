package io.github.yurigivo.cryptolearning;

import java.util.*;
import java.util.Map.Entry;

public class Decrypt {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        String ciphertext = "ёйцахй эе феифеод гкхвдшгм гухэ сешхэ оиейх дяг \n" +
                "ахйхэ чшхзйг шео дмц чхёнмг хо угме чхздъ дмц \n" +
                "ёъешцые меън ёъеше п ца ёъейе х ыгщдъёп чдшду \n" +
                "ёмдшънж чгихуеън йжсхмгяг ётэфе чшхдоаею ёг \n" +
                "мэгю чшгёъхънёп чгыгшгэх е ъем х ё сгягм \n" +
                "чгдоаею гчпън эе ёйцасц е п ъдсд х эдидёъц \n" +
                "чшххёфейе х цмэеп х ыгшгзеп х хмдэнд дёън \n" +
                "чгйжсхъёп ъдсд мгадъ х адэхзнёп х ёгиёдм гёъеэдзнёп\n";
        Map<Character, Integer> frequencies = getLetterFrequencies(ciphertext);
        System.out.println(frequencies);
        // х=29, г=27, е=26, д=25, ё=22, ъ=19, м=15, э=13, ч=12, ш=12, й=10, н=10, п=10, ц=9, а=9,
        // с=7 , о=6 , з=5 , и=5 , у=4 , ф=4 , ы=4 , ю=3 , я=3 , ж=3 , щ=2 , т=1 , в=1 , к=1

        Map<Character, Character> cipherToPlain = new HashMap<>();
        cipherToPlain.put('х', 'и');
        cipherToPlain.put('е', 'а');
        cipherToPlain.put('й', 'л');
        cipherToPlain.put('г', 'о');

        cipherToPlain.put('э', 'н');
        cipherToPlain.put('у', 'д');
        cipherToPlain.put('ш', 'р');
        cipherToPlain.put('з', 'ш');
        cipherToPlain.put('п', 'я');
        cipherToPlain.put('ч', 'п');
        cipherToPlain.put('о', 'з');
        cipherToPlain.put('ъ', 'т');
        cipherToPlain.put('н', 'ь');
        cipherToPlain.put('ё', 'с');
        cipherToPlain.put('ы', 'х');
        cipherToPlain.put('и', 'в');

        cipherToPlain.put('ц', 'у');
        cipherToPlain.put('а', 'ж');
        cipherToPlain.put('ф', 'к');
        cipherToPlain.put('д', 'е');
        cipherToPlain.put('я', 'г');
        cipherToPlain.put('с', 'б');

        cipherToPlain.put('м', 'м');
        cipherToPlain.put('щ', 'ч');
        cipherToPlain.put('ж', 'ю');
        cipherToPlain.put('т', 'ы');
        cipherToPlain.put('ю', 'й');
        cipherToPlain.put('к', 'ф');
        cipherToPlain.put('в', 'ц');

        System.out.println("\n");
        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);
            if (cipherToPlain.containsKey(ch)) {
                ch = cipherToPlain.get(ch);
                System.out.print(ANSI_RED + ch + ANSI_RESET);
            } else
                System.out.print(ch);
        }
        System.out.println("\n");
    }
    private static Map<Character, Integer> getLetterFrequencies(String input) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != ' ' && ch != '\n') {
                Integer freq = result.get(ch);
                if (freq == null)
                    freq = 0;
                result.put(ch, freq + 1);
            }
        }
        return sortByValueDesc(result);
    }
    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDesc(Map<K, V> map) {
        List<Entry<K, V>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : entries)
            result.put(entry.getKey(), entry.getValue());
        return result;
    }

    /*
        Frequency of Russian letters:
        1	о	55414481	10.97%
        2	е	42691213	8.45%
        3	а	40487008	8.01%
        4	и	37153142	7.35%
        5	н	33838881	6.70%
        6	т	31620970	6.26%
        7	с	27627040	5.47%
        8	р	23916825	4.73%
        9	в	22930719	4.54%
        10	л	22230174	4.40%
        11	к	17653469	3.49%
        12	м	16203060	3.21%
        13	д	15052118	2.98%
        14	п	14201572	2.81%
        15	у	13245712	2.62%
        16	я	10139085	2.01%
        17	ы	9595941 	1.90%
        18	ь	8784613	    1.74%
        19	г	8564640	    1.70%
        20	з	8329904	    1.65%
        21	б	8051767	    1.59%
        22	ч	7300193	    1.44%
        23	й	6106262	    1.21%
        24	х	4904176	    0.97%
        25	ж	4746916	    0.94%
        26	ш	3678738	    0.73%
        27	ю	3220715	    0.64%
        28	ц	2438807	    0.48%
        29	щ	1822476	    0.36%
        30	э	1610107	    0.32%
        31	ф	1335747	    0.26%
        32	ъ	185452	    0.04%
        33	ё	184928	    0.04%
     */
}
