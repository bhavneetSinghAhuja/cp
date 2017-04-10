package twitter;

/**
 * Created by bhavneet.ahuja on 13/11/16.
 */
public class Test {
    static void decrypt(String total) {
        String key="8251220";
        char[] keys = key.toCharArray();
        char[] totalArr = total.toCharArray();
        StringBuffer buffer = new StringBuffer();

        int keyindex = 0;
        for (int i = 0; i < totalArr.length; i++) {
            if (totalArr[i] >= 'A' && totalArr[i] <= 'z'){
                int value=totalArr[i];
                int newValue=totalArr[i] - Integer.parseInt(String.valueOf(keys[keyindex++%key.length()]));
                if (value>=65 && value<=90){
                    if(newValue<65)
                        newValue+=26;
                }
                else if(value>=97 && value<=122){
                    if(newValue<97)
                        newValue+=26;
                }
                buffer.append((char)newValue);
            } else {
                buffer.append(totalArr[i]);
            }

// System.out.println(((one[i] - two[i]) + 26) % 26);
        }
        System.out.println(buffer.toString());
    }

    public static void main(String[] args) {
        decrypt("Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg");
    }
}
