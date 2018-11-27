package io.oasp.gastronomy.restaurant.offermanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;

/**
 * This is the interface for an {@link Special}
 *
 */
public interface Special extends ApplicationEntity {

  /**
   * @return name
   */
  String getName();

  /**
   * @param name new value
   */
  void setName(String name);

  /**
   * @return offer
   */
  public Long getOfferId();

  /**
   * @param offerId new value
   */
  void setOfferId(Long offerId);

  /**
   * @return activePeriod
   */
  WeeklyPeriod getActivePeriod();

  /**
   * @param activePeriod new value
   */
  void setActivePeriod(WeeklyPeriod activePeriod);

  /**
   * @return specialPrice
   */
  Money getSpecialPrice();

  /**
   * @param specialPrice new value
   */
  void setSpecialPrice(Money specialPrice);

}