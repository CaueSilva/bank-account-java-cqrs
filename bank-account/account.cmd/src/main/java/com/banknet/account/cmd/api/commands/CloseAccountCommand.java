package com.banknet.account.cmd.api.commands;

import com.banknet.cqrs.core.commands.BaseCommand;

public class CloseAccountCommand extends BaseCommand {

    public CloseAccountCommand(String id){
        super(id);
    }
}
