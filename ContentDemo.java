import java.time.Year;
import java.util.ArrayList;

public class ContentDemo {

    public static void main(String[] args) {

        ArrayList<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture(
                "Java OOP Basics", 2024, 90, "HD"));
        items.add(new VideoLecture(
                "Advanced Java", 2021, 120, "4K"));

        items.add(new PodcastEpisode(
                "Tech Talk", 2023, 45, "Alice"));
        items.add(new PodcastEpisode(
                "Programming Stories", 2020, 60, "Bob"));

        int currentYear = Year.now().getValue();

        for (ContentItem item : items) {
            System.out.println(
                    item + " | licenseCost=" +
                            item.getLicenseCost(currentYear)
            );

            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                d.download();
                System.out.println(
                        "Max downloads per day: " +
                                d.getMaxDownloadsPerDay()
                );
            }

            System.out.println("---------------------------");
        }
    }
}
