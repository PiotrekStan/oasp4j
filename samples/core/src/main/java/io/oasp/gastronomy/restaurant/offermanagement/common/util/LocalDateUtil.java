package io.oasp.gastronomy.restaurant.offermanagement.common.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * @author PSTANKIE
 *
 */
public class LocalDateUtil {

  private LocalDateUtil() {

  }

  public static int getHour(LocalDateTime dateTime) {

    return dateTime.getHour();
  }

  public static DayOfWeek getDayOfWeek(LocalDateTime dateTime) {

    return dateTime.getDayOfWeek();
  }

}
