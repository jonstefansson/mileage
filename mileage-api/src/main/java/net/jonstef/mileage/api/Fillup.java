package net.jonstef.mileage.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 *
 */
public class Fillup {

	private final Long id;

	private final Integer mileage;

	private final BigDecimal quantity;

	private final DateTime date;

	private final String vehicle;

	private BigDecimal mpg;

	public Fillup(
			@JsonProperty("id") Long id,
			@JsonProperty("mileage") Integer mileage,
			@JsonProperty("quantity") BigDecimal quantity,
			@JsonProperty("date") DateTime date,
			@JsonProperty("vehicle") String vehicle) {
		this.id = id;
		this.mileage = mileage;
		this.quantity = quantity;
		this.vehicle = vehicle;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public Integer getMileage() {
		return mileage;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public String getVehicle() {
		return vehicle;
	}

	public DateTime getDate() {
		return date;
	}

	public BigDecimal getMpg() {
		return mpg;
	}

	public void setMpg(BigDecimal mpg) {
		this.mpg = mpg;
	}

	@Override
	public String toString() {
		return String.format(
				"Fillup[id=%d, mileage=%s, quantity=%s, vehicle=%s, date=%s]",
				id,
				mileage,
				quantity,
				vehicle,
				date
		);
	}

}
