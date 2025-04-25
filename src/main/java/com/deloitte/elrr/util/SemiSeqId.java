package com.deloitte.elrr.util;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import org.hibernate.annotations.IdGeneratorType;

@IdGeneratorType(SemiSeqUUIdGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD, METHOD})
public @interface SemiSeqId {

}
