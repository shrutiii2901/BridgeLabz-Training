public class Utility {

    public boolean validateTransportId(String transportId) {
        if (transportId.matches("RTS\\d{3}[A-Z]")) {
            return true;
        } else {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }
    }

    public GoodsTransport parseDetails(String input) {
        String[] data = input.split(":");

        String transportId = data[0];
        String transportDate = data[1];
        int rating = Integer.parseInt(data[2]);
        String type = data[3];

        if (type.equalsIgnoreCase("BrickTransport")) {
            return new BrickTransport(
                    transportId, transportDate, rating,
                    Float.parseFloat(data[4]),
                    Integer.parseInt(data[5]),
                    Float.parseFloat(data[6])
            );
        } else {
            return new TimberTransport(
                    transportId, transportDate, rating,
                    Float.parseFloat(data[4]),
                    Float.parseFloat(data[5]),
                    data[6],
                    Float.parseFloat(data[7])
            );
        }
    }

    public String findObjectType(GoodsTransport gt) {
        if (gt instanceof TimberTransport)
            return "TimberTransport";
        else
            return "BrickTransport";
    }
}
