import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xu.yu
 *
 * @date 2017/3/9.
 * @update
 * @function
 */
public class Test {
    //    public final static String urlExp = "(([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/]))";
    public final static String urlExp = "((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";

    public static void main(String[] args) {

        String text = "text http://www.baidu.com";
        String text2 = "text2 http://www.baidu.com cbbc";
        String text3 = "text3 http://www.baidu.com  cbbc";
        String text4 = "text4 http://www.baidu.com  asdahjsdk Http://www.baidu.com";
        String text5 = "text5 https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000";
        String text6 = "text6 https://www.youtube.com/watch?v=HI4PU8YGmHM";
        String text7 = "text7 https://www.youtube.com/watch?v=wT0ZkLrflNs&feature=youtu.be";

        Pattern p = Pattern.compile(urlExp, Pattern.CASE_INSENSITIVE);

        print(p, text);
        print(p, text2);
        print(p, text3);
        print(p, text4);
        print(p, text5);
        print(p, text6);
        print(p, text7);

//        System.out.println("number=0 --" + getString(0));
//        System.out.println("number=1 --" + getString(1));
//        System.out.println("number=999 --" + getString(999));
//        System.out.println("number=9999 --" + getString(9999));
//        System.out.println("number=10000 --" + getString(10000));
//        System.out.println("number=1000000000--" + getString(1000000000));
//        System.out.println("number=9999999 --" + getString(9999999));


//        HashMap map = new HashMap();
//        map.put("aa", "1");
//        map.put("abkdjf7", "3");
//        map.put("jbkdjf7", "4");
//
//        Collection<String> keyset = map.keySet();
//        List<String> list = new ArrayList<String>(keyset);
//
//        //对key键值按字典升序排序
//        Collections.sort(list);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("key键---值: " + list.get(i) + "," + map.get(list.get(i)));
//        }

    }

    private static void print(Pattern p, String text) {
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println("原文：" + text + " start=" + m.start() + "  end=" + m.end() + " 值=" + m.group());//          每次返回第一个即可 可用groupcount()方法来查看捕获的组数 个数
        }
    }

    private static String getString(int praiseNum) {
        java.text.DecimalFormat formater = new java.text.DecimalFormat("###,##0.0");
        formater.setRoundingMode(RoundingMode.FLOOR);
        return formater.format(praiseNum / 1000.0);
    }
}
