package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.OfferDao;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.embedded.WeeklyPeriodEmbeddable;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author PSTANKIE
 *
 */
@Transactional
@SpringBootTest(classes = { SpringBootApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpecialDaoTest extends ComponentTest {

  private static final String OFFER_NAME = "OfferName";

  private static final Money PRICE = Money.ZERO;

  @Inject
  SpecialDao dao;

  @Inject
  OfferDao offerDao;

  @Test
  public void shouldSaveSpecialEntity() {

    // given
    SpecialEntity toSave = createExampleSpecialEntity();

    // when
    SpecialEntity saved = this.dao.save(toSave);

    // then
    assertNotNull(saved);
    assertEquals(OFFER_NAME, saved.getName());

  }

  @Test
  public void shouldFindBySearchCriteria() {

    // given
    SpecialSearchCriteriaTo criteria = new SpecialSearchCriteriaTo();
    criteria.setValidDate(LocalDateTime.of(2018, 11, 27, 12, 30));

    SpecialEntity toSave = createExampleSpecialEntity();
    SpecialEntity saved = this.dao.save(toSave);

    // when
    PaginatedListTo<SpecialEntity> found = this.dao.findBySearchCriteria(criteria);

    // then
    assertNotNull(found);
  }

  private SpecialEntity createExampleSpecialEntity() {

    SpecialEntity entity = new SpecialEntity();
    entity.setName(OFFER_NAME);
    entity.setOfferId(1L);
    entity.setSpecialPrice(PRICE);
    WeeklyPeriod period = new WeeklyPeriodEmbeddable();
    period.setEndingDay(DayOfWeek.MONDAY);
    period.setEndingHour(10);
    period.setStartingDay(DayOfWeek.FRIDAY);
    period.setStartingHour(10);
    entity.setActivePeriod(period);
    return entity;
  }
}
