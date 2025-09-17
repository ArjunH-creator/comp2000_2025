public interface Item {
    String getName();
}

public class Bone implements Item {
    public String getName() {
        return "Bone";
    }
}

public class Seed implements Item {
    public String getName() {
        return "Seed";
    }
}

public class Fish implements Item {
    public String getName() {
        return "Fish";
    }
}