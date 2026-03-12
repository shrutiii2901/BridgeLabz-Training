import java.util.List;
import java.util.stream.Stream;
public class EarphoneUtil {
    public Stream<Earphone> getEarphonesByBrandName(Stream<Earphone> earphoneStream, String brandName){
        return earphoneStream.filter(e -> e.getName().equalsIgnoreCase(brandName));
    }

    public List<Earphone> getEarphonesWithinPriceRange(Stream<Earphone> earphoneStream, double minimumPrice, double maximumPrice){
        return earphoneStream.filter(e -> e.getPrice() >= minimumPrice && e.getPrice() <=maximumPrice).toList();
    }
    
}
