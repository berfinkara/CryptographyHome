import Cipher.SubstitutionCipher;
import staticClasses.CryptoTools;

public class main {
    public static void main(String[] args){


        String cipherText1 = "XIBKGLTIZKSBKIRLIGLGSVNLWVIMZTVDZHVUUVXGREVOBHBMLMBNLFHDRGSVMXIBKGRLMG" +
                "SVXLMEVIHRLMLURMULINZGRLMUILNZIVZWZYOVHGZGVGLZKKZIVMGMLMHVMHVGSVLIRTR" +
                "MZGLILUZMVMXIBKGVWNVHHZTVHSZIVWGSVWVXLWRMTGVXSMRJFVMVVWVWGLIVXLEVIG" +
                "SVLIRTRMZORMULINZGRLMLMOBDRGSRMGVMWVWIVXRKRVMGHGSVIVYBKIVXOFWRMTFMD" +
                "ZMGVWKVIHLMHGLWLGSVHZNVHRMXVDLIOWDZIRZMWGSVZWEVMGLUGSVXLNKFGVIGSVNV" +
                "GSLWHFHVWGLXZIIBLFGXIBKGLOLTBSZEVYVXLNVRMXIVZHRMTOBXLNKOVCZMWRGHZKKOR" +
                "XZGRLMNLIVDRWVHKIVZWNLWVIMXIBKGLTIZKSBRHSVZEROBYZHVWLMNZGSVNZGRXZOGSV" +
                "LIBZMWXLNKFGVIHXRVMXVKIZXGRXVXIBKGLTIZKSRXZOTLIRGSNHZIVWVHRTMVWZILFMWX" +
                "LNKFGZGRLMZOSZIWMVHHZHHFNKGRLMHNZPRMTHFXSZOTLIRGSNHSZIWGLYIVZPRMKIZXGR" +
                "XVYBZMBZWEVIHZIBRGRHGSVLIVGRXZOOBKLHHRYOVGLYIVZPHFXSZHBHGVNYFGRGRHRMU" +
                "VZHRYOVGLWLHLYBZMBPMLDMKIZXGRXZONVZMHGSVHVHXSVNVHZIVGSVIVULIVGVINVWXL" +
                "NKFGZGRLMZOOBHVXFIVGSVLIVGRXZOZWEZMXVHVTRNKILEVNVMGHRMRMGVTVIUZXGLIRA" +
                "ZGRLMZOTLIRGSNHZMWUZHGVIXLNKFGRMTGVXSMLOLTBIVJFRIVGSVHVHLOFGRLMHGLYVXL" +
                "MGRMFZOOBZWZKGVW";
        String cipherText2 = "KPUXBKIEKPYSSECPZDOHRRTIVZKXNOVRWMLSEIRRTBNMAKZWOWAGUIUQJDKHBVFXCMXAV" +
                "WVJPZZLRVZRQMYXVKRXZLKZVHVRXMSEEOVVNIXICPRGZLTIKXKSZIILCMVGZWLIIMUIIKKEY" +
                "PFADVMJBVFVBITMMEKMJVUJGLVIQQJIAGVWFMZGUMEKOPKWPIEIDAGPFSRJJZSSSHFGPUKRGE" +
                "KMJVGXNGIMHMYGRRVXCQYEYPFANNUVASKINBUFRXROZVGWJICPVAZSTELKZLOWGEEGZAG" +
                "RQSKLZZORSSIQVBOSAXYEOUGCASKFZMGWVPPHZBKGGIUJMWSSAPPEKPUXBKIEKPZLRMEZZA" +
                "ZMTEKSMACMYPUVVEUYGPFGVBOSAWFJZDOHRRTIVVJEYPFXCMXSONVGOAORGLVVJWSXUIJO" +
                "ZBILVWLWPIRPLHIERVLVBQRRVJUZRTFMIBUJIMVAIWZIFEIIOIQIAFPMIDKWGMXEOWXWGSVRN" +
                "CXIZIDSMQFEGMFRJNZLRMIXCWAKUXJEILYYFTZGDWTWNFFYOLOJSIIIIBVMRGVWJNKZVHVRX" +
                "MKZVHVRXMOWPSCPZKZIQXYVJCMLGAFAVGYJBVVRNQIWNRUMIBKVIMVANIRPSSIIIAOGRZZH" +
                "ZVIIVWSEBOKHFIGEMIZIYCKSKZKZRRKEIGIVBWJGJVZEZMEEOQURSSIIIAOGFYJINIBEEMVXTWL" +
                "HVJWIMMTXGSFPNITHGITLIQWYRWWMIOKVCVZROKUPYITXDWTXUVFYBPZLRYJIJNMVRCFVW" +
                "TGGXQRKIMZMPTFAYMXHAERRYWZLRVSSYQRCSPLMYAGVRGFPGMIXRHRRYENIGLVVDBOWU" +
                "EZVJZLPHMUJJZLYEXYIMMDEZMEEOQURVRRPVJYLBIRRYBOVRTIMIBYGNRSIXWRPRGKIYCYMA" +
                "KUIIBGPFXFRZMRIPXISIQIWNVVXVSKRSSIISISMAEKMJVHCNXVGCVOGNPVBKMXXGSJIVZILSSIJP" +
                "ZZLRVVZDLKRPIUSXCSIAXJJMWSXUIRVZIGVRECWJBGORRWSMNAVGLVVZFGQVRRXDWTEZQL" +
                "RDBOSAEEHRMGTBRJEMMZEXIEJJZSEGGYMIOZSJSLRYAGRQFRPGQYXVGJTCWZSTVRTCAUJGSF" +
                "PHIXOFEIIOIQIAFVGVCYIGLVCXITFRQRXXPKHGSRAZIVSAEKEGIZIEXZQZ";


        Cracker cracker1 = new Cracker(cipherText1);
        Cracker cracker2 = new Cracker(cipherText2);

        System.out.println("Question 1");
        System.out.println(cracker1.getDecryptedText());
        System.out.println(cracker1.getKey());
        System.out.println(cracker1.getType());
        System.out.println("\u00AE\u00AE\u00AE\u00AE\u00AE\u00AE\u00AE\u00AE\u00AE\u00AE\u00AE\u00AE");
        System.out.println("Question 2");
        System.out.println(cracker2.getDecryptedText());
        System.out.println(cracker2.getKey());
        System.out.println(cracker2.getType());

    }
}








































