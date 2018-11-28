package io.oasp.gastronomy.restaurant.offermanagement.logic.api.to;

import java.time.DayOfWeek;

/**
 * @author PSTANKIE
 *
 */
public class WeeklyPeriod {

  private DayOfWeek startingDay;

  private int startingHour;

  private DayOfWeek endingDay;

  private int endingHour;

  public DayOfWeek getStartingDay() {

    return this.startingDay;
  }

  public void setStartingDay(DayOfWeek startingDay) {

    this.startingDay = startingDay;
  }

  public int getStartingHour() {

    return this.startingHour;
  }

  public void setStartingHour(int startingHour) {

    this.startingHour = startingHour;
  }

  public DayOfWeek getEndingDay() {

    return this.endingDay;
  }

  public void setEndingDay(DayOfWeek endingDay) {

    this.endingDay = endingDay;
  }

  public int getEndingHour() {

    return this.endingHour;
  }

  public void setEndingHour(int endingHour) {

    this.endingHour = endingHour;
  }

}