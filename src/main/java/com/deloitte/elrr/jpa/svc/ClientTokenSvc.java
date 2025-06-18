package com.deloitte.elrr.jpa.svc;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.deloitte.elrr.entity.ClientToken;
import com.deloitte.elrr.repository.ClientTokenRepository;

@Service
public class ClientTokenSvc implements CommonSvc<ClientToken, UUID> {

    private final ClientTokenRepository clientTokenRepository;

    /**
     *
     * @param argsClientTokenRepository
     */
    public ClientTokenSvc(final ClientTokenRepository argsClientTokenRepository) {
        this.clientTokenRepository = argsClientTokenRepository;
    }

    @Override
    public CrudRepository<ClientToken, UUID> getRepository() {
        return this.clientTokenRepository;
    }

    @Override
    public UUID getId(final ClientToken clientToken) {
        return clientToken.getId();
    }

    @Override
    public ClientToken save(final ClientToken clientToken) {
        return CommonSvc.super.save(clientToken);
    }
}