import java.util.ArrayList;

public class Program {
	
    public static String blah(String[][] table,String IP) {
    	
    	//declare variables
    	ArrayList<String[]> split = new ArrayList<String[]>();
    	ArrayList<String[]> binary = new ArrayList<String[]>();
    	ArrayList<String[]> subnet = new ArrayList<String[]>();
    	String[] ip_in = IP.split("\\W");
    	
    	//Build the binary and subnet array lists
    	for (int i = 0; i < table.length; i++) {
    		split.add(table[i][0].split("\\W"));
    		binary.add(new String[4]);
    		subnet.add(new String[4]);
    	}
    	
    	//Fill the ip_in array with 8 bit binary form
    	for (int i = 0; i < 4; i++) {
    		ip_in[i] = eight_bit(ip_in[i]);
    	}
    	
    	//Fill the binary and subnet array lists with 8 bit binary form
    	for (int i = 0; i < split.size(); i++) {
    		String[] temp = split.get(i);
    		int x = Integer.parseInt(temp[4]);
    		
    		for (int j = 0; j < 4; j++) {
   
    			//Build the routing table binary
    			binary.get(i)[j] = eight_bit(temp[j]);
    			
    			//Build the subnet mask binary
    			subnet.get(i)[j] = subnet(x);
    			x -= 8;
    			
    		}
    		
    		binary.set(i, convert_down(binary.get(i), Integer.parseInt(split.get(i)[4])));
    	}
    	
    	//compare data to obtain results
    	for (int i = 0; i < table.length; i++) {
    		if (compare(ip_in,subnet.get(i),binary.get(i))) {
    			return table[i][1];
    		}
    	}
    	
    	return "default";
    	
    }
    
    //ensures routing IP are in reduced form
    public static String[] convert_down(String[] binary, int x) {
    	
    	String str = "00000000";
    	
    	for (int i = 0; i < 4; i++) {
    		if (x < 8 && x > 0) {
    			binary[i] = binary[i].substring(0, x) + str.substring(x);
    			x = 0;
    		} else if (x <= 0) {
    			binary[i] = str;
    		} else {
    			x -= 8;
    		}
    	}
    	
    	return binary;
    }
    
    public static boolean compare(String[] ip_in, String[] subnet, String[] binary) {
    
    	String[] result = new String[4];
    	
    	for (int i = 0; i < 4; i++) {
    		result[i] = eight_bit(ip_in[i], subnet[i]);
    		if (result[i].equals(binary[i])) {
    			continue;
    		} else {
    			return false;
    		}
    	}
    	
    	return true;
    	
    }
    
    //compare subnet and ip_in and obtain their 8-bit binary AND
    public static String eight_bit(String str1, String str2) {
    	
    	String str = "";
    	
    	for (int i = 0; i < 8; i++) {
    		if (str1.charAt(i) == str2.charAt(i) && str1.charAt(i) == '1') {
    			str += "1";
    		}
    		else {
    			str += "0";
    		}
    	}
    	
    	return str;
    }
    
    //Method takes subnet as int and converts it to 8-bit binary
    public static String subnet(int i) {
    	
    	String str1 = "11111111";
    	String str2 = "00000000";
    	
    	if (i >= 8) {
    		return str1;
    	} 
    	else if (i <= 0) {
    		return str2;
    	}
    	else {
    		return str1.substring(0, i) + str2.substring(i);
    	}
    	
    }
    
    //Method takes any Integer string and converts it to 8-bit binary
    public static String eight_bit(String str) {
    	
    	str = Integer.toBinaryString(Integer.parseInt(str));
    	while (str.length() < 8) {
			str = "0" + str;
		}
    	return str;
    	
    }
    
}
