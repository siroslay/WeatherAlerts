package net.theneophyte.weatheralerts.products;

/**
 * Class for storing latitude/longitude coordinates.
 * @author Matt Sutter
 *
 */
public class LatLng {
	public static final double 
			MAX_LATITUDE = 90.0d, 
			MIN_LATITUDE = -90.0d,
			MAX_LONGITUDE = 180.0d,
			MIN_LONGITUDE = -180.0d;
	
	public static final int 
			LATITUDE = 0,
			LONGITUDE = 1;
	
	private static final float FIXED_POINT_DIVISOR = 1000f;
	
	public final double latitude;
	public final double longitude;

	/**
	 * {@link LatLng} constructor. 
	 * @param lat - latitude
	 * @param lng - longitude
	 */
	public LatLng(final double lat, final double lng){
		this.latitude = lat;
		this.longitude = lng;
	}
	
	/**
	 * {@link LatLng} constructor. 
	 * @param lat - latitude
	 * @param lng - longitude
	 */
	public LatLng(final float lat, final float lng){
		this.latitude = lat;
		this.longitude = lng;
	}
	
	/**
	 * {@link LatLng} constructor. 
	 * @param latlng - String containing only a single latitude and longitude pair separated by a comma, e.g., "45.0,-124.58".
	 */
	public LatLng(String latlng){
		final String[] values = latlng.split(",");
		this.latitude = Double.parseDouble(values[LATITUDE]);
		this.longitude = Double.parseDouble(values[LONGITUDE]);
	}
	
	/**
	 * Construct a new {@link LatLng} object from an existing one.
	 */
	public LatLng(final LatLng coords){
		this.latitude = coords.latitude;
		this.longitude = coords.longitude;
	}
	
	/**
	 * Helper for loading radar sites from the database. The latitude and longitude values 
	 * stored in the database are fixed-point integers (three fractional digits).
	 * @param lat - latitude
	 * @param lng - longitude 
	 * @return new {@link LatLng} object.
	 */
	public static LatLng fromFixedPointInt(final int lat, final int lng){
		return new LatLng(lat / FIXED_POINT_DIVISOR, lng / FIXED_POINT_DIVISOR);
	}
}