package org.axonframework.sample.axonbank.axonbank.account;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.sample.axonbank.axonbank.coreapi.AccountCreatedEvent;
import org.axonframework.sample.axonbank.axonbank.coreapi.CreateAccountCommand;
import org.axonframework.sample.axonbank.axonbank.coreapi.MoneyWithdrawnEvent;
import org.axonframework.sample.axonbank.axonbank.coreapi.WithdrawMoneyComand;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;
@Aggregate(repository = "jpaAccountRepository")
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @Basic
    @AggregateIdentifier
    private  String accountId;

    @Basic
    private int balance;

    @Basic
    private int overdraftLimit;

    @CommandHandler
    public Account(CreateAccountCommand command){
        apply(new AccountCreatedEvent(command.getAccountId(), command.getOverdraftLimit()));
    }

    @CommandHandler
    public void handle(WithdrawMoneyComand comand) throws OverdraftLimitExceededException {

        if(balance + overdraftLimit >= comand.getAmount()) {
            apply(new MoneyWithdrawnEvent(accountId, comand.getAmount(), balance - comand.getAmount()));
        }else {
            throw new OverdraftLimitExceededException();
        }
    }


    @EventSourcingHandler
    public void on(AccountCreatedEvent event){
        this.accountId = event.getAccountId();
        this.overdraftLimit = event.getOverdraftLimit();
    }

    @EventSourcingHandler
    public void on(MoneyWithdrawnEvent event){

       this.balance = event.getBalance();
    }
}
