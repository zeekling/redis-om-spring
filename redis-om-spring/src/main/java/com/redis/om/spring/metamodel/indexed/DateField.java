package com.redis.om.spring.metamodel.indexed;

import java.lang.reflect.Field;

import com.redis.om.spring.metamodel.MetamodelField;
import com.redis.om.spring.search.stream.predicates.numeric.BetweenPredicate;
import com.redis.om.spring.search.stream.predicates.numeric.EqualPredicate;
import com.redis.om.spring.search.stream.predicates.numeric.GreaterThanOrEqualPredicate;
import com.redis.om.spring.search.stream.predicates.numeric.GreaterThanPredicate;
import com.redis.om.spring.search.stream.predicates.numeric.LessThanOrEqualPredicate;
import com.redis.om.spring.search.stream.predicates.numeric.LessThanPredicate;
import com.redis.om.spring.search.stream.predicates.numeric.NotEqualPredicate;

public class DateField<E, T> extends MetamodelField<E, T> {

  public DateField(Field field, boolean indexed) {
    super(field, indexed);
  }
  
  public EqualPredicate<? super E,T> eq(T value) {
    return new EqualPredicate<>(field,value);
  }
  
  public NotEqualPredicate<? super E,T> notEq(T value) {
    return new NotEqualPredicate<>(field,value);
  }
  
  public GreaterThanPredicate<? super E,T> after(T value) {
    return new GreaterThanPredicate<>(field,value);
  }
  
  public GreaterThanOrEqualPredicate<? super E,T> onOrAfter(T value) {
    return new GreaterThanOrEqualPredicate<>(field,value);
  }
  
  public LessThanPredicate<? super E,T> before(T value) {
    return new LessThanPredicate<>(field,value);
  }
  
  public LessThanOrEqualPredicate<? super E,T> onOrBefore(T value) {
    return new LessThanOrEqualPredicate<>(field,value);
  }
  
  public BetweenPredicate<? super E,T> between(T min, T max) {
    return new BetweenPredicate<>(field,min,max);
  }

}
