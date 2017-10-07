package net.perfectsolution.frontend.restfulConsumer;

import static net.perfectsolution.backend.utils.Utilities.getTodaysCalendar;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository("weatherProvider")
public class WeatherProvider {

	private static final String API_URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22amman%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
	private static Map<String, Object> todayForecast;
	private Date lastUpdatedDate;

	/*
	public String getWeatherDesc(){
		WeatherProvider w = new WeatherProvider();
		
		HashMap query = (HashMap)w.getTodayWeather().get("query");
		HashMap results = (HashMap)query.get("results");
		HashMap channel = (HashMap)results.get("channel");
		HashMap item = (HashMap)channel.get("item");
		String description = (String)item.get("description");
		
		return description;
		
	}*/
	
	public Map<String, Object> getTodayWeather() {
		if (todayForecast == null || todayForecast.isEmpty() || shouldUpdate()) {
			try {
				updateWeatherForecast();
			} catch (IOException e) {
				System.out.println("error when updating the weather forecast");
			}
		}
		return todayForecast;
	}

	private boolean shouldUpdate() {
		Date today = getTodaysCalendar().getTime();
		return lastUpdatedDate.before(today);
	}

	private void updateWeatherForecast() throws JsonParseException, JsonMappingException, IOException {
		URL apiUrl = new URL(API_URL);
		ObjectMapper mapper = new ObjectMapper();
		todayForecast = mapper.readValue(apiUrl, Map.class);
		lastUpdatedDate = getTodaysCalendar().getTime();
	}
	
	
	
}
