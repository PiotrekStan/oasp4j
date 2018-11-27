package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import static com.querydsl.core.alias.Alias.$;
import static io.oasp.gastronomy.restaurant.offermanagement.common.util.LocalDateUtil.getDayOfWeek;
import static io.oasp.gastronomy.restaurant.offermanagement.common.util.LocalDateUtil.getHour;

import java.time.LocalDateTime;

import javax.inject.Named;

import com.querydsl.core.alias.Alias;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.OfferDao;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of {@link OfferDao}.
 *
 */
@Named
public class SpecialDaoImpl extends ApplicationMasterDataDaoImpl<SpecialEntity> implements SpecialDao {

  /**
   * The constructor.
   */
  public SpecialDaoImpl() {

    super();
  }

  @Override
  public Class<SpecialEntity> getEntityClass() {

    return SpecialEntity.class;
  }

  @Override
  public PaginatedListTo<SpecialEntity> findBySearchCriteria(SpecialSearchCriteriaTo criteria) {

    if (criteria != null) {
      SpecialEntity special = Alias.alias(SpecialEntity.class);
      EntityPathBase<SpecialEntity> alias = $(special);
      JPAQuery<SpecialEntity> query = new JPAQuery<SpecialEntity>(getEntityManager()).from(alias);

      String name = criteria.getName();
      if (name != null) {
        query.where($(special.getName()).eq(name));
      }

      Money maxPrice = criteria.getMaxPrice();
      if (maxPrice != null) {
        query.where($(special.getSpecialPrice()).loe(maxPrice));
      }

      LocalDateTime validDate = criteria.getValidDate();
      if (validDate != null) {
        Predicate startDate = $(special.getActivePeriod().getStartingDay()).loe(getDayOfWeek(validDate))
            .and($(special.getActivePeriod().getStartingHour()).loe(getHour(validDate)));
        Predicate endDate = $(special.getActivePeriod().getEndingDay()).goe(getDayOfWeek(validDate))
            .and($(special.getActivePeriod().getEndingHour()).goe(getHour(validDate)));
        query.where(startDate).where(endDate);
      }

      return findPaginated(criteria, query);

    }
    return null;
  }

}
