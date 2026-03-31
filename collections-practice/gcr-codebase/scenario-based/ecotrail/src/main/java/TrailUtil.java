import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TrailUtil {

    private List<Trail> trailList = new ArrayList<>();

    public List<Trail> getTrailList() {
        return trailList;
    }

    public void setTrailList(List<Trail> trailList) {
        this.trailList = trailList;
    }

    // Requirement 1
    public void addTrailRecord(Trail trail) {
        trailList.add(trail);
    }

    // Requirement 2
    public Trail getTrailById(String trailId) {
        for (Trail t : trailList) {
            if (t.getTrailId().equalsIgnoreCase(trailId)) {
                return t;
            }
        }
        return null;
    }

    // Requirement 3
    public Set<Trail> getMostHikedTrails() {
        int max = trailList.stream()
                .mapToInt(Trail::getHikeCount)
                .max()
                .orElse(0);

        return trailList.stream()
                .filter(t -> t.getHikeCount() == max)
                .collect(Collectors.toSet());
    }

    // Requirement 4
    public Map<String, Integer> getHikeCountByRegion() {
        return trailList.stream()
                .collect(Collectors.groupingBy(
                        Trail::getRegion,
                        LinkedHashMap::new,
                        Collectors.summingInt(Trail::getHikeCount)
                ));
    }

    // Requirement 5
    public Map<String, List<Trail>> groupTrailsByDifficulty() {
        return trailList.stream()
                .collect(Collectors.groupingBy(
                        Trail::getDifficulty,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
    }

    // Requirement 6
    public boolean updateHikeCount(String trailId, int additionalHikes) {
        Trail t = getTrailById(trailId);
        if (t != null) {
            t.setHikeCount(t.getHikeCount() + additionalHikes);
            return true;
        }
        return false;
    }

    // Requirement 7
    public List<Trail> filterTrails(String region, String difficulty) {
        return trailList.stream()
                .filter(t -> t.getRegion().equalsIgnoreCase(region)
                        && t.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }

    // Requirement 8
    public Map<String, List<Trail>> getTopTrailsByRegion(int n) {
        Map<String, List<Trail>> map = new LinkedHashMap<>();

        Map<String, List<Trail>> grouped =
                trailList.stream().collect(Collectors.groupingBy(Trail::getRegion));

        for (String region : grouped.keySet()) {
            List<Trail> sorted = grouped.get(region).stream()
                    .sorted(Comparator.comparingInt(Trail::getHikeCount).reversed())
                    .limit(n)
                    .collect(Collectors.toList());
            map.put(region, sorted);
        }

        return map;
    }

    // Requirement 9
    public Map<String, String> getDifficultyStats() {
        Map<String, String> result = new LinkedHashMap<>();

        Map<String, List<Trail>> grouped = groupTrailsByDifficulty();

        for (String diff : grouped.keySet()) {
            List<Trail> list = grouped.get(diff);
            int count = list.size();
            int total = list.stream().mapToInt(Trail::getHikeCount).sum();
            int avg = count == 0 ? 0 : total / count;

            result.put(diff, "count=" + count + ", totalHikes=" + total + ", averageHikes=" + avg);
        }

        return result;
    }
}
