import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap();

    public void add(String name, Integer phoneNumber){
        if(phoneBook.containsKey(name)){
            ArrayList<Integer> list = phoneBook.get(name);
            list.add(phoneNumber);
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(phoneNumber);
            phoneBook.put(name, list);
        }
    }

    public ArrayList<Integer> find(String name){
        if(phoneBook.containsKey(name)){
            return phoneBook.get(name);
        }else{
            return new ArrayList<>();
        }
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook(){
        return phoneBook;
    }

    public void sortBook(){
        List<Map.Entry<String, ArrayList<Integer>>> sorted = new ArrayList<>(phoneBook.entrySet());
        sorted.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for(Map.Entry<String, ArrayList<Integer>> entry : sorted){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Anna", 12345);
        pb.add("Nina", 25648);
        pb.add("Nina", 25649);
        pb.add("Nina", 25650);
        pb.add("Anna", 25651);
        pb.add("Rita", 25652);
        pb.add("Nina", 25653);
        pb.add("Rita", 25654);
        pb.add("Anna", 25655);
        System.out.println(PhoneBook.getPhoneBook());

        pb.sortBook();
    }
}