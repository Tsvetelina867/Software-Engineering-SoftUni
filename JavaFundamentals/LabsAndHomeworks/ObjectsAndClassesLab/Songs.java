package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    public static class Song {
        String typeList;
        String name;
        String time;

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }

        public Song (String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] info = input.split("_");
            String typeList = info[0];
            String name = info[1];
            String time = info[2];
            Song currentSong = new Song(typeList, name, time);
            songs.add(currentSong);
        }
        String command = scanner.nextLine();

        if (command.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (song.getTypeList().equals(command)) {
                    System.out.println(song.getName());
                }
            }
        }

    }
}
