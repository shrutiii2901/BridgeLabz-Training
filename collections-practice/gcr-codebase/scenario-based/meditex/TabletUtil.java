import java.util.List;
import java.util.stream.Stream;

public class TabletUtil {


    public List<Tablet> retrieveTabletsByBrand(Stream<Tablet> tabletStream, String brand){
        return tabletStream.filter(t -> t.getBrand().equalsIgnoreCase(brand)).toList();
    }

    public List<String> getTabletsAboveMg(Stream<Tablet> tabletStream, int mg){
        return tabletStream.filter(t -> t.getMg()>mg )
                            .map(Tablet::getName)
                            .toList();
    }

}
