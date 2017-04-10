package browserstack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by bhavneet.ahuja on 27/11/16.
 */
public class TestClass {

    public static final String STARTED = "Started ";
    public static final String PROCESSING_BY = "Processing by ";

    private static int getIntegerFromString(String numStr) {
        return Integer.parseInt(numStr);
    }

    private static String[] getSplitSpace(String line) {
        return line.split("\\s+");
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bi = getBufferedReader();
        String line;
        ArrayList<String> requests = new ArrayList<>();
        ArrayList<String> filters = new ArrayList<>();
        String request = "";
        while (true) {
            line = bi.readLine();
            if (line.compareTo("***************###############***************") == 0) {
                requests.add(request);
                for (int i = 0; i < 5; i++) {
                    line = bi.readLine();
                    filters.add(line);
                }
                break;
            } else {
                if (line.startsWith("Started ")) {
                    if (!(request.compareTo("") == 0)) {
                        requests.add(request);
                    }
                    request = "";
                }
                request = request + "\n" + line;
            }
        }
        printResult(requests, filters);
    }

    private static void printResult(ArrayList<String> requests, ArrayList<String> filters) {
        Map<String, Integer> result = new LinkedHashMap<>();
        String type = null,url =null, ip=null, format=null, code=null;
        for (String filter : filters) {
            result.put(filter, 0);
            if(isStringEqual(filter, "GET") || isStringEqual(filter, "PUT") || isStringEqual(filter, "POST") || isStringEqual(filter, "DELETE")) type=filter;
            else if (filter.contains("/"))url=filter;
            else if (filter.contains("."))ip=filter;
            else if (filter.contains("1") || filter.contains("2") || filter.contains("3") || filter.contains("4") ||filter.contains("5"))code=filter;
            else format=filter;
        }


        for (String request : requests) {
                String lines[]=request.split("\n");
                String line;
                for (int i = 0; i < lines.length; i++) {
                    line=lines[i];

                    if (line.contains(STARTED)){
                        if (line.contains(STARTED+type)) result.put(type, result.get(type) + 1);
                        if (line.contains("\""+url+"\"")) result.put(url, result.get(url) + 1);
                        if (line.contains("for "+ip)) result.put(ip, result.get(ip) + 1);
                    }
                    else if (line.contains(PROCESSING_BY)){
                        if (line.contains("as "+format)) result.put(format, result.get(format) + 1);
                    }
                    else if (line.contains("Completed")){
                        if (line.contains("Completed "+code)) result.put(code, result.get(code) + 1);
                    }

                }

        }
        for (Integer integer : result.values()) {
            System.out.println(integer);
        }
    }

    private static boolean isStringEqual(String filter, String get) {
        if(filter.compareTo(get)==0) return true;
        return false;
    }
}
