package ego.sexy.xyz.model;

import io.vertx.core.json.JsonObject;

import java.io.Serializable;

/**
 * Created by foogaro on 04/10/17.
 */
public class GeoLocation implements Serializable {

    private String geoLat;
    private String geoLong;

    public GeoLocation(JsonObject jsonObject) {
        this.geoLat = jsonObject.getString("lat");
        this.geoLong = jsonObject.getString("long");
    }

    public String getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(String geoLat) {
        this.geoLat = geoLat;
    }

    public String getGeoLong() {
        return geoLong;
    }

    public void setGeoLong(String geoLong) {
        this.geoLong = geoLong;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeoLocation{");
        sb.append("geoLat='").append(geoLat).append('\'');
        sb.append(", geoLong='").append(geoLong).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
