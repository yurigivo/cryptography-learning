package io.github.yurigivo.cryptolearning;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;

import static io.github.yurigivo.CustomAssert.assertAllEqual;
import static io.github.yurigivo.cryptolearning.SubstitutionCipher.*;
import static junit.framework.TestCase.assertEquals;
import static org.apache.commons.math3.util.CombinatoricsUtils.factorial;

public class SubstitutionCipherTest {
    /** Ex. 1.3 (a) */
    @Test public void encryptsMessage() {
        String plaintext = "The gold is hidden in the garden.";
        System.out.println(substitutionCipher().encrypt(plaintext));
    }
    /** Ex. 1.3 (b) */
    @Test public void printsEncryptionAndDecryptionTables() {
        SubstitutionCipher substitutionCipher = substitutionCipher();
        substitutionCipher.printEncryptionTable();
        substitutionCipher.printDecryptionTable();
    }
    /** Ex. 1.3 (c) */
    @Test public void decryptsMessage() {
        String ciphertext = "IBXLX JVXIZ SLLDE VAQLL DEVAU QLB";
        System.out.println(substitutionCipher().decrypt(ciphertext.replace(" ", "")));
    }
    private static SubstitutionCipher substitutionCipher() {
        return new SubstitutionCipher(
                new SimpleEntry<>('a', 'S'),
                new SimpleEntry<>('b', 'C'),
                new SimpleEntry<>('c', 'J'),
                new SimpleEntry<>('d', 'A'),
                new SimpleEntry<>('e', 'X'),
                new SimpleEntry<>('f', 'U'),
                new SimpleEntry<>('g', 'F'),
                new SimpleEntry<>('h', 'B'),
                new SimpleEntry<>('i', 'Q'),
                new SimpleEntry<>('j', 'K'),
                new SimpleEntry<>('k', 'T'),
                new SimpleEntry<>('l', 'P'),
                new SimpleEntry<>('m', 'R'),
                new SimpleEntry<>('n', 'W'),
                new SimpleEntry<>('o', 'E'),
                new SimpleEntry<>('p', 'Z'),
                new SimpleEntry<>('q', 'H'),
                new SimpleEntry<>('r', 'V'),
                new SimpleEntry<>('s', 'L'),
                new SimpleEntry<>('t', 'I'),
                new SimpleEntry<>('u', 'G'),
                new SimpleEntry<>('v', 'Y'),
                new SimpleEntry<>('w', 'D'),
                new SimpleEntry<>('x', 'N'),
                new SimpleEntry<>('y', 'M'),
                new SimpleEntry<>('z', 'O')
        );
    }

    /** Ex. 1.4 (a) A Piratical Treasure */
    @Test public void decryptsPiraticalTreasure() {
//        String ciphertext =
//                "JNRZR BNIGI BJRGZ IZLQR OTDNJ GRIHT USDKR ZZWLG OIBTM NRGJN\n" +
//                "IJTZJ LZISJ NRSBL QVRSI ORIQT QDEKJ JNRQW GLOFN IJTZX QLFQL\n" +
//                "WBIMJ ITQXT HHTBL KUHQL JZKMM LZRNT OBIMI EURLW BLQZJ GKBJT\n" +
//                "QDIQS LWJNR OLGRI EZJGK ZRBGS MJLDG IMNZT OIHRK MOSOT QHIJL\n" +
//                "QBRJN IJJNT ZFIZL WIZTO MURZM RBTRZ ZKBNN LFRVR GIZFL KUHIM\n" +
//                "MRIGJ LJNRB GKHRT QJRUU RBJLW JNRZI TULGI EZLUK JRUST QZLUK\n" +
//                "EURFT JNLKJ JNRXR S";
        String ciphertext =
                "JNRZR BNIGIBJRGZ IZ LQR OTDNJ GRIHTUS DKRZZ WLGO I BTMNRG JNIJ\n" +
                "TZ JL ZIS JNRS BLQVRS I ORIQTQD EKJ JNRQ WGLO FNIJ TZ XQLFQ LW\n" +
                "BIMJITQ XTHH T BLKUH QLJ ZKMMLZR NTO BIMIEUR LW BLQZJGKBJTQD\n" +
                "IQS LW JNR OLGR IEZJGKZR BGSMJLDGIMNZ T OIHR KM OS OTQH IJ\n" +
                "LQBR JNIJ JNTZ FIZ LW I ZTOMUR ZMRBTRZ ZKBN NLFRVRG IZ FLKUH\n" +
                "IMMRIG JL JNR BGKHR TQJRUURBJ LW JNR ZITULG IEZLUKJRUS TQZLUKEUR\n" +
                "FTJNLKJ JNR XRS";
        SubstitutionCipherDecryption decryption = new SubstitutionCipherDecryption(ciphertext);
        System.out.println(decryption.getLetterFrequencies());
        System.out.println(decryption.getBigramFrequencies());
        //{R=33, J=30, I=27, L=25, Z=24, T=20, N=19, Q=16, B=15, G=15, K=13, U=12, M=12, O=10, S=9, H=8, W=7, F=6, D=5, E=5, X=3, V=2}
        //{JN=11, NR=8, TQ=6, RZ=5, RB=5, JL=5, LW=5, NI=4, GI=4, IZ=4, ZL=4, LQ=4, RI=4, IJ=4, IM=4, UR=4}

        SubstitutionCipher guess = new SubstitutionCipher(
                new SimpleEntry<>('e', 'R'),
                new SimpleEntry<>('t', 'J'),
                new SimpleEntry<>('a', 'I'),
                new SimpleEntry<>('o', 'L'),
                new SimpleEntry<>('n', 'Q'),
                new SimpleEntry<>('r', 'G'),
                new SimpleEntry<>('i', 'T'),
                new SimpleEntry<>('s', 'Z'),
                new SimpleEntry<>('h', 'N'),
                new SimpleEntry<>('d', 'H'),
                new SimpleEntry<>('l', 'U'),
                new SimpleEntry<>('f', 'W'),
                new SimpleEntry<>('c', 'B'),
                new SimpleEntry<>('m', 'O'),
                new SimpleEntry<>('u', 'K'),
                new SimpleEntry<>('g', 'D'),
                new SimpleEntry<>('y', 'S'),
                new SimpleEntry<>('p', 'M'),
                new SimpleEntry<>('w', 'F'),
                new SimpleEntry<>('b', 'E'),
                new SimpleEntry<>('v', 'V'),
                new SimpleEntry<>('k', 'X')
        );
        System.out.println();
        decryption.printGuess(guess);
        System.out.println();

        System.out.println("These characters, as one might readily guess, form a cipher - that\n" +
                "is to say, they convey a meaning; but then, from what is known of\n" +
                "captain Kidd, I could not suppose him capable of constructing\n" +
                "any of the more abstruse cryptographs. I made up my mind, at\n" +
                "once, that this was of a simple species - such, however, as would\n" +
                "appear, to the crude intellect of the sailor, absolutely insoluble\n" +
                "without the key.");
    }
    /** Ex. 1.4 (b) A Botanical Code */
    @Test public void decryptsBotanicalCode() {
//        String ciphertext =
//                "KZRNK GJKIP ZBOOB XLCRG BXFAU GJBNG RIXRU XAFGJ BXRME MNKNG\n" +
//                "BURIX KJRXR SBUER ISATB UIBNN RTBUM NBIGK EBIGR OCUBR GLUBN\n" +
//                "JBGRL SJGLN GJBOR ISLRS BAFFO AZBUN RFAUS AGGBI NGLXM IAZRX\n" +
//                "RMNVL GEANG CJRUE KISRM BOOAZ GLOKW FAUKI NGRIC BEBRI NJAWB\n" +
//                "OBNNO ATBZJ KOBRC JKIRR NGBUE BRINK XKBAF QBROA LNMRG MALUF\n" +
//                "BBG";
        String ciphertext =
                "K ZRN K GJKIP ZBOO BXLCRGBX FAU GJB NGRIXRUX AF GJB XRM EM NKNGBU\n" +
                "RIX K JRX R SBUERI SATBUIBNN R TBUM NBIGKEBIGRO CUBRGLUB\n" +
                "NJB GRLSJG LN GJB ORISLRSB AF FOAZBUN R FAUSAGGBI NGLXM IAZRXRMN\n" +
                "VLG EANG CJRUEKIS R MBOOAZ GLOKW FAU KINGRICB EBRIN JAWBOBNN\n" +
                "OATB ZJKOB R CJKIR RNGBU EBRIN K XKB AF QBROALNM RG MALU FBBG";
        SubstitutionCipherDecryption decryption = new SubstitutionCipherDecryption(ciphertext);
        System.out.println(decryption.getLetterFrequencies());
        System.out.println(decryption.getBigramFrequencies());
        //{B=32, R=28, G=22, N=20, I=16, A=16, U=14, K=13, O=12, J=11, X=10, L=10, F=8, M=8, E=7, S=7, Z=6, C=5, T=3, W=2, P=1, V=1, Q=1}
        //{NG=7, RI=7, BU=6, BR=5, GJ=4, KI=4, BO=4, GB=4, JB=4, BN=4, GR=4, XR=4, GL=4, OA=4, IN=4}

        SubstitutionCipher guess = new SubstitutionCipher(
                new SimpleEntry<>('e', 'B'),
                new SimpleEntry<>('t', 'G'),
                new SimpleEntry<>('a', 'R'),
                new SimpleEntry<>('o', 'A'),
                new SimpleEntry<>('n', 'I'),
                new SimpleEntry<>('r', 'U'),
                new SimpleEntry<>('i', 'K'),
                new SimpleEntry<>('s', 'N'),
                new SimpleEntry<>('h', 'J'),
                new SimpleEntry<>('d', 'X'),
                new SimpleEntry<>('l', 'O'),
                new SimpleEntry<>('f', 'F'),
                new SimpleEntry<>('c', 'C'),
                new SimpleEntry<>('m', 'E'),
                new SimpleEntry<>('u', 'L'),
                new SimpleEntry<>('g', 'S'),
                new SimpleEntry<>('y', 'M'),
                new SimpleEntry<>('p', 'W'),
                new SimpleEntry<>('w', 'Z'),
                new SimpleEntry<>('b', 'V'),
                new SimpleEntry<>('v', 'T'),
                new SimpleEntry<>('k', 'P'),
                new SimpleEntry<>('j', 'Q')
        );
        System.out.println();
        decryption.printGuess(guess);
        System.out.println();

        System.out.println("I was, I think, well educated for the standard of my day. My sister\n" +
                "and I had a German governess a Fraulein. A very sentimental creature.\n" +
                "She taught us the language of flowers a forgotten study nowadays,\n" +
                "but most charming. A yellow tulip, for instance, means ‘Hopeless Love,’\n" +
                "while a China aster means ‘I Die of Jealousy at Your Feet.’");
    }
    /** Ex. 1.4 (c) A Brilliant Detective */
    @Test public void decryptsBrilliantDetective() {
//        String ciphertext =
//                "GSZES GNUBE SZGUG SNKGX CSUUE QNZOQ EOVJN VXKNG XGAHS AWSZZ\n" +
//                "BOVUE SIXCQ NQESX NGEUG AHZQA QHNSP CIPQA OIDLV JXGAK CGJCG\n" +
//                "SASUB FVQAV CIAWN VWOVP SNSXV JGPCV NODIX GJQAE VOOXC SXXCG\n" +
//                "OGOVA XGNVU BAVKX QZVQD LVJXQ EXCQO VKCQG AMVAX VWXCG OOBOX\n" +
//                "VZCSO SPPSN VAXUB DVVAX QJQAJ VSUXC SXXCV OVJCS NSJXV NOJQA\n" +
//                "MVBSZ VOOSH VSAWX QHGMV GWVSX CSXXC VBSNV ZVNVN SAWQZ ORVXJ\n" +
//                "CVOQE JCGUW NVA";
        String ciphertext =
                "G SZ ESGNUB ESZGUGSN KGXC SUU EQNZO QE OVJNVX KNGXGAH SAW SZ\n" +
                "ZBOVUE SIXCQN QE S XNGEUGAH ZQAQHNSPC IPQA OIDLVJX GA KCGJC G\n" +
                "SASUBFV QAV CIAWNVW OVPSNSXV JGPCVNO DIX G JQAEVOO XCSX XCGO\n" +
                "GO VAXGNVUB AVK XQZV QDLVJX QE XCQOV KCQ GAMVAXVW XCGO OBOXVZ\n" +
                "CSO SPPSNVAXUB DVVA XQ JQAJVSU XCSX XCVOV JCSNSJXVNO JQAMVB\n" +
                "S ZVOOSHV SAW XQ HGMV GWVS XCSX XCVB SNV ZVNV NSAWQZ\n" +
                "ORVXJCVO QE JCGUWNVA";
        SubstitutionCipherDecryption decryption = new SubstitutionCipherDecryption(ciphertext);
        System.out.println(decryption.getLetterFrequencies());
        System.out.println(decryption.getBigramFrequencies());
        //{V=39, S=29, X=29, G=22, O=21, A=21, C=20, Q=20, N=19, J=13, Z=11, U=11, E=10, B=8, W=8, P=6, K=5, H=5, I=5, D=4, M=3, L=2, F=1, R=1}
        //{XC=10, NV=7, CS=6, OV=6, SX=6, QA=6, SN=5, VJ=5, CG=5, VA=5, SZ=4, ES=4, UB=4, QE=4, XG=4, GA=4, SA=4, AW=4, NS=4, JC=4, XV=4, CV=4, VN=4, VO=4, AX=4, XQ=4

        SubstitutionCipher guess = new SubstitutionCipher(
                new SimpleEntry<>('e', 'V'),
                new SimpleEntry<>('t', 'X'),
                new SimpleEntry<>('a', 'S'),
                new SimpleEntry<>('o', 'Q'),
                new SimpleEntry<>('n', 'A'),
                new SimpleEntry<>('r', 'N'),
                new SimpleEntry<>('i', 'G'),
                new SimpleEntry<>('s', 'O'),
                new SimpleEntry<>('h', 'C'),
                new SimpleEntry<>('d', 'W'),
                new SimpleEntry<>('l', 'U'),
                new SimpleEntry<>('f', 'E'),
                new SimpleEntry<>('c', 'J'),
                new SimpleEntry<>('m', 'Z'),
                new SimpleEntry<>('u', 'I'),
                new SimpleEntry<>('g', 'H'),
                new SimpleEntry<>('y', 'B'),
                new SimpleEntry<>('p', 'P'),
                new SimpleEntry<>('w', 'K'),
                new SimpleEntry<>('b', 'D'),
                new SimpleEntry<>('v', 'M'),
                new SimpleEntry<>('k', 'R'),
                new SimpleEntry<>('j', 'L'),
                new SimpleEntry<>('z', 'F')
        );
        System.out.println();
        decryption.printGuess(guess);
        System.out.println();

        System.out.println("I am fairly familiar with all forms of secret writings, and am\n" +
                "myself the author of a trifling monograph upon the subject, in which I\n" +
                "analyze one hundred and sixty separate ciphers; but I confess that this\n" +
                "is entirely new to me. The object of those who invented the system\n" +
                "has apparently been to conceal that these characters convey\n" +
                "a message, and to give the idea that they are the mere random\n" +
                "sketches of children.");
    }

    /** Ex. 1.5 (a) */
    @Test public void calculatesNumberOfCiphers() {
        assertEquals( 1, getNumberOfCiphers(1));
        assertEquals( 2, getNumberOfCiphers(2));
        assertEquals( 6, getNumberOfCiphers(3));
        assertEquals(24, getNumberOfCiphers(4));
        assertEquals(factorial(20), getNumberOfCiphers(20));
    }
    /** Ex. 1.5 (b) */
    @Test public void calculatesNumberOfCiphers_whenFixedLetters() {
        Permutations withThree = Permutations.fromLetters('a', 'b', 'c');
        assertAllEqual(2, withThree.withExactlyNumberOfFixedLetters(0).size(), getNumberOfCiphersWithExactlyFixed(3, 0));
        assertAllEqual(4, withThree.withAtLeastNumberOfFixedLetters(1).size(), getNumberOfCiphersWithAtLeastFixed(3, 1));
        assertAllEqual(3, withThree.withExactlyNumberOfFixedLetters(1).size(), getNumberOfCiphersWithExactlyFixed(3, 1));
        assertAllEqual(1, withThree.withAtLeastNumberOfFixedLetters(2).size(), getNumberOfCiphersWithAtLeastFixed(3, 2));

        Permutations withFour = Permutations.fromLetters('a', 'b', 'c', 'd');
        assertAllEqual( 9, withFour.withExactlyNumberOfFixedLetters(0).size(), getNumberOfCiphersWithExactlyFixed(4, 0));
        assertAllEqual(15, withFour.withAtLeastNumberOfFixedLetters(1).size(), getNumberOfCiphersWithAtLeastFixed(4, 1));
        assertAllEqual( 8, withFour.withExactlyNumberOfFixedLetters(1).size(), getNumberOfCiphersWithExactlyFixed(4, 1));
        assertAllEqual( 7, withFour.withAtLeastNumberOfFixedLetters(2).size(), getNumberOfCiphersWithAtLeastFixed(4, 2));

        Permutations withFive = Permutations.fromLetters('a', 'b', 'c', 'd', 'e');
        assertAllEqual(44, withFive.withExactlyNumberOfFixedLetters(0).size(), getNumberOfCiphersWithExactlyFixed(5, 0));
        assertAllEqual(76, withFive.withAtLeastNumberOfFixedLetters(1).size(), getNumberOfCiphersWithAtLeastFixed(5, 1));
        assertAllEqual(45, withFive.withExactlyNumberOfFixedLetters(1).size(), getNumberOfCiphersWithExactlyFixed(5, 1));
        assertAllEqual(31, withFive.withAtLeastNumberOfFixedLetters(2).size(), getNumberOfCiphersWithAtLeastFixed(5, 2));

        Permutations withSix = Permutations.fromLetters('a', 'b', 'c', 'd', 'e', 'f');
        assertAllEqual(265, withSix.withExactlyNumberOfFixedLetters(0).size(), getNumberOfCiphersWithExactlyFixed(6, 0));
        assertAllEqual(455, withSix.withAtLeastNumberOfFixedLetters(1).size(), getNumberOfCiphersWithAtLeastFixed(6, 1));
        assertAllEqual(264, withSix.withExactlyNumberOfFixedLetters(1).size(), getNumberOfCiphersWithExactlyFixed(6, 1));
        assertAllEqual(191, withSix.withAtLeastNumberOfFixedLetters(2).size(), getNumberOfCiphersWithAtLeastFixed(6, 2));
    }
}