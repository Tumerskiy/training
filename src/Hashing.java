import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Hashing {
    private static HashMap<Integer, Integer> hashMap = new HashMap<>();
    private static String toPrint= "";

    public static int lastSequence(int j,int lr, int n){
        int result = 0;
        if (lr>j){
            for (int i=j+1;i<j+n;i++){
                if(hashMap.get(i%n)!=null){
                    toPrint+=" "+i%n;
                }else{
                    toPrint+=" "+i%n;
                    result = i%n;
                    break;
                }
            }
        } else{
            for (int i=j-1;i>j-n;i--){
                int val = i;
                if (i<0){
                    val = n-1-i;
                }
                if(hashMap.get(val)!=null){
                    toPrint+=" "+val;
                }else{
                    toPrint+=" "+val;
                    result = val;
                    break;
                }
            }
        }
        return result;
    }

    public static int reBound(int value,int j, int n, int lr, String print){
        int result = 0;
        if (value ==0){
            toPrint= print;
            result = lastSequence(j,lr,n);
            print += " "+result;
            if (toPrint.length()<print.length()) {
                toPrint = print;
            }
            return result;
        }

        int j1r = value%10;
        int j1f = (value/10)%n+j;
        if (j1f>n-1){
            j1f = j1f%n;
        }
        int j1b = j-(value/10)%n;
        if (j1b<0){
            j1b = n+j1b;
        }

        if(j1r%2!=0&&hashMap.get(j1f)==null){
            print+=" "+j1f;
            result = j1f;
        } else if(j1r%2!=0&&hashMap.get(j1f)!=null){
            print+=" "+j1f;
            result = reBound(value/10, j1f, n, value%10,print);
        } else if (j1r%2==0&&hashMap.get(j1b)==null){
            print+=" "+j1b;
            result = j1b;
        }else if (j1r%2==0&&hashMap.get(j1b)!=null){
            print += " "+j1b;
            result = reBound(value/10, j1b, n, value%10, print);
        }
        if (toPrint.length()<print.length()) {
            toPrint = print;
        }
        return result;
    }

    public static int getHash(int value, int n){
        int result = 0;
        int j = value%n;
        String print = "";

        if (hashMap.get(j)!=null){
            print+=j;
            result = reBound(value,j,n,value%10, print);
        } else{
            toPrint=Integer.toString(j);
            result = j;
        }

        return result;
    }

    public static void main(String[] args){
        BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int n = Integer.parseInt(inReader.readLine());
            String inString = inReader.readLine();
            int inSize = inString.split(" ").length-1;
            for (int i=0;i<inSize;i++){
                toPrint="";
                int value=Integer.parseInt(inString.split(" ")[i]);
                hashMap.put(getHash(value,n),value);
                System.out.println(toPrint);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
