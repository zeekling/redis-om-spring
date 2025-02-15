package com.redis.om.spring.search.stream.predicates.numeric;

import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import com.redis.om.spring.search.stream.predicates.BaseAbstractPredicate;

import io.redisearch.querybuilder.Node;
import io.redisearch.querybuilder.QueryBuilder;
import io.redisearch.querybuilder.Values;

public class LessThanOrEqualPredicate<E, T> extends BaseAbstractPredicate<E, T> {

  private T value;

  public LessThanOrEqualPredicate(Field field, T value) {
    super(field);
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  @Override
  public Node apply(Node root) {
    Class<?> cls = value.getClass();
    if (cls == LocalDate.class) {
      LocalDate localDate = (LocalDate) getValue();
      Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
      Long unixTime = instant.getEpochSecond();
      return QueryBuilder.intersect(root).add(getField().getName(), Values.le(unixTime));
    } else if (cls == Integer.class) {
      return QueryBuilder.intersect(root).add(getField().getName(), Values.le(Integer.valueOf(getValue().toString())));
    } else if (cls == Double.class) {
      return QueryBuilder.intersect(root).add(getField().getName(), Values.le(Double.valueOf(getValue().toString())));
    } else {
      return root;
    }
  }

}
