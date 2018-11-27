package io.oasp.gastronomy.restaurant.offermanagement.common.api;

import java.time.DayOfWeek;

/**
 * This is the interface for an {@link WeeklyPeriod}
 *
 */
public interface WeeklyPeriod {

  /**
   * @return startingDay
   */
  public DayOfWeek getStartingDay();

  /**
   * @param startingDay new value
   */
  void setStartingDay(DayOfWeek startingDay);

  /**
   * @return startingHour
   */
  int getStartingHour();

  /**
   * @param startingHour new value
   */
  void setStartingHour(int startingHour);

  /**
   * @return endingDay
   */
  DayOfWeek getEndingDay();

  /**
   * @param endingDay new value
   */
  void setEndingDay(DayOfWeek endingDay);

  /**
   * @return endingHour
   */
  int getEndingHour();

  /**
   * @param endingHour new value
   */
  void setEndingHour(int endingHour);

}