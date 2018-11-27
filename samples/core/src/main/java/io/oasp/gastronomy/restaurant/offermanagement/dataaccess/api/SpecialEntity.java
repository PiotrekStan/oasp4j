package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.Offer;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.Special;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.embedded.WeeklyPeriodEmbeddable;

/**
 * @author PSTANKIE
 *
 */
@Entity
@Table(name = "Special")
public class SpecialEntity extends ApplicationPersistenceEntity implements Special {

  private static final long serialVersionUID = 1L;

  private String name;

  private OfferEntity offer;

  private WeeklyPeriodEmbeddable activePeriod;

  private Money specialPrice;

  /**
   * @return name
   */
  @Column(unique = true)
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
   * @return offer
   */
  @ManyToOne
  @JoinColumn(name = "offerId")
  public OfferEntity getOffer() {

    return this.offer;
  }

  /**
   * @param offer new value
   */
  public void setOffer(OfferEntity offer) {

    this.offer = offer;
  }

  /**
   * @return activePeriod
   */
  @Embedded
  public WeeklyPeriodEmbeddable getActivePeriod() {

    return this.activePeriod;
  }

  /**
   * @param activePeriod new value
   */
  public void setActivePeriod(WeeklyPeriodEmbeddable activePeriod) {

    this.activePeriod = activePeriod;
  }

  /**
   * @return specialPrice
   */
  public Money getSpecialPrice() {

    return this.specialPrice;
  }

  /**
   * @param specialPrice new value
   */
  public void setSpecialPrice(Money specialPrice) {

    this.specialPrice = specialPrice;
  }

  /**
   * @return offerId
   */
  @Override
  @Transient
  public Long getOfferId() {

    return Optional.ofNullable(this.offer).map(Offer::getId).orElse(null);
  }

  /**
   * @param offerId new value
   */
  @Override
  @Transient
  public void setOfferId(Long offerId) {

    OfferEntity newOffer = null;
    if (offerId != null) {
      newOffer = new OfferEntity();
      newOffer.setId(offerId);
    }
    this.offer = newOffer;
  }

  /**
   * @param activePeriod new value
   */
  @Override
  public void setActivePeriod(WeeklyPeriod activePeriod) {

    WeeklyPeriodEmbeddable weeklyPeriod = null;
    if (activePeriod != null) {
      weeklyPeriod = new WeeklyPeriodEmbeddable();
      weeklyPeriod.setStartingDay(activePeriod.getStartingDay());
      weeklyPeriod.setStartingHour(activePeriod.getStartingHour());
      weeklyPeriod.setEndingDay(activePeriod.getEndingDay());
      weeklyPeriod.setEndingHour(activePeriod.getEndingHour());
    }

    this.activePeriod = weeklyPeriod;
  }

}
