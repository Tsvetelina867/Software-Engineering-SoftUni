package RegularExam.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {

    private List<Kid> data;
    private int capacity;

    public House(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void addKid(Kid kid) {
        if (data.size() < capacity) {
            data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        Kid kid = data.stream()
                .filter(k -> k.getName().equals(name))
                .findFirst()
                .orElse(null);
        data.remove(kid);
        return kid != null;
    }

    public Kid getKid(String street) {
        return data.stream()
                .filter(k -> k.getStreet().equals(street))
                .findFirst()
                .orElse(null);
    }

    public int getAllKids() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:\n");

        for (Kid kid : data) {
            sb.append(kid.getName()).append(" from ").append(kid.getStreet()).append(" street").append("\n");
        }
        return sb.toString().trim();
    }


}
