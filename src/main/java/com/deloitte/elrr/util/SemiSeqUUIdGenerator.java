package com.deloitte.elrr.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.fasterxml.uuid.Generators;

public class SemiSeqUUIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(final SharedSessionContractImplementor session,
                    final Object object) {
        return Generators.timeBasedEpochRandomGenerator().generate();
    }
}
