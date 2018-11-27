package io.oasp.gastronomy.restaurant.offermanagement.logic.api.to;

import java.time.LocalDateTime;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * @author PSTANKIE
 *
 */
public class SpecialSearchCriteriaTo extends SearchCriteriaTo {

  /** UID for serialization. */
  private static final long serialVersionUID = 1L;

  private String name;

  private Money maxPrice;

  private LocalDateTime validDate;

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return maxPrice
   */
  public Money getMaxPrice() {

    return this.maxPrice;
  }

  /**
   * @param maxPrice new value
   */
  public void setMaxPrice(Money maxPrice) {

    this.maxPrice = maxPrice;
  }

  /**
   * @return validDate
   */
  public LocalDateTime getValidDate() {

    return this.validDate;
  }

  /**
   * @param validDate new value
   */
  public void setValidDate(LocalDateTime validDate) {

    this.validDate = validDate;
  }

}
