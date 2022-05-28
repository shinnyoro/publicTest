import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

public class Hahuman {
   public void main(String args){

    List<Character> contents = new ArrayList<>();
    try(FileInputStream fs = new FileInputStream(args);
    InputStreamReader isr = new InputStreamReader(fs, "UTF-8")){
        //読み込むファイルを指定
        
        
        //InputStreamReaderクラスのreadメソッドでファイルを1文字ずつ読み込む
        int data;
        while((data = isr.read()) != -1) {
            System.out.println(data);
            contents.add((char)data);
        }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    Map<Character,Integer> hahumanDate = new HashMap<>();
    for(char content: contents){
        
        
            if(!hahumanDate.containsKey(content)){
                int count = 0;
                for(char cont: contents){
                    if(cont == content){
                        count++;
                    }
                }
                hahumanDate.put(content, count);
            }
        
    }

    // 2.Map.Entryのリストを作成する
    List<Map.Entry<Character,Integer>> list_entries = new ArrayList<>(hahumanDate.entrySet());
        
    // 3.比較関数Comparatorを使用してMap.Entryの値を比較する(昇順)
    Collections.sort(list_entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
    
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    List<Integer> freq = new ArrayList<>();
    List<Integer> freqCopy = new ArrayList<>();
    for(Map.Entry<Character,Integer> entry : list_entries) {
        freq.add(entry.getValue());
        freqCopy.add(entry.getValue());
        left.add(-1);
        right.add(-1);
    }
    int size = hahumanDate.size();
    int parent[] = new int[2 * size - 1];
    parent[2 * size - 2] = -1;
    while(freqCopy.size() == 1){
        int a = freqCopy.get(0);
        int b = freqCopy.get(1);

        left.add(freq.indexOf(a));
        right.add(freq.indexOf(b));

        freqCopy.add(a + b);
        freq.add(a + b);

        parent[freq.indexOf(a)] = freq.size();
        parent[freq.indexOf(b)] = freq.size();
        
        freqCopy.remove(0);
        freqCopy.remove(1);
        Collections.sort(freqCopy);

    }
    System.out.println("hello worl");

    }

    
}


