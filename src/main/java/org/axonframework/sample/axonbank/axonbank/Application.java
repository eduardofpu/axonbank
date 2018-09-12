package org.axonframework.sample.axonbank.axonbank;

import org.axonframework.commandhandling.AsynchronousCommandBus;
import org.axonframework.config.Configuration;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.sample.axonbank.axonbank.account.Account;
import org.axonframework.sample.axonbank.axonbank.coreapi.CreateAccountCommand;
import org.axonframework.sample.axonbank.axonbank.coreapi.WithdrawMoneyComand;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;

public class Application {

    public static void main(String[] args) {
        Configuration config = DefaultConfigurer.defaultConfiguration()
                .configureAggregate(Account.class)
                .configureEmbeddedEventStore(c-> new InMemoryEventStorageEngine())
                .configureCommandBus(c -> new AsynchronousCommandBus())
                .buildConfiguration();

        config.start();
        config.commandBus().dispatch(asCommandMessage(new CreateAccountCommand("4321", 500)));
        config.commandBus().dispatch(asCommandMessage(new WithdrawMoneyComand("4321", 250)));
        config.commandBus().dispatch(asCommandMessage(new WithdrawMoneyComand("4321", 251)));
    }
}
