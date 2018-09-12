package org.axonframework.sample.axonbank.axonbank.coreapi

import org.axonframework.commandhandling.TargetAggregateIdentifier

class CreateAccountCommand(val accountId : String, val overdraftLimit :Int)
class WithdrawMoneyComand(@TargetAggregateIdentifier val accoundId: String, val amount : Int)

class AccountCreatedEvent(val accountId: String, val overdraftLimit: Int)
class MoneyWithdrawnEvent(val accountId: String, val amount: Int, val balance : Int)