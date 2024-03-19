import java.util.LinkedHashMap;

public class Che {
    public LinkedHashMap<String,Integer> meals;
    public String name;
    public int experience;
    public Che(String name) {
        this.name = name;
        this.meals = new LinkedHashMap<>();
        this.experience = 1;
    }
    public void cook(String meal) {
        if (this.meals.containsKey(meal)) {
            this.meals.put(meal,this.meals.get(meal) + 1);
        } else {
            this.meals.put(meal,1);
        }
        this.experience++;
    }
    public static void main(String[] args) {
        Che ali = new Che("Ali");
        ali.cook("rice");
        ali.cook("soup");
        ali.cook("rice");
        ali.cook("meat");

        System.out.println(ali.meals);
        System.out.println(ali.name+"'s current experience level is " + ali.experience + ".");
    }
}
