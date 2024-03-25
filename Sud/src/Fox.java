public class Fox {
    public String name;
    public int age;

    public String color;

    public Fox(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    public String toString() {
        return "Fox[" + this.name + ", " + this.color + ", " + this.age + "]";
    }
}
