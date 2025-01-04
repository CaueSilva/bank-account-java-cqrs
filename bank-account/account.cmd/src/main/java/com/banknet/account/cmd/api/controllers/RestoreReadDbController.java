package com.banknet.account.cmd.api.controllers;

import com.banknet.account.cmd.api.commands.OpenAccountCommand;
import com.banknet.account.cmd.api.commands.RestoreReadDbCommand;
import com.banknet.account.cmd.api.dto.OpenAccountResponse;
import com.banknet.account.common.dto.BaseResponse;
import com.banknet.cqrs.core.infrastructure.CommandDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/v1/restoreReadDb")
public class RestoreReadDbController {
    private final Logger logger = Logger.getLogger(RestoreReadDbController.class.getName());

    @Autowired
    private CommandDispatcher commandDispatcher;

    @PostMapping
    public ResponseEntity<BaseResponse> restoreReadDb(){
        try {
            commandDispatcher.send(new RestoreReadDbCommand());
            return new ResponseEntity<>(new BaseResponse("Read database restored successfully."), HttpStatus.CREATED);
        } catch (IllegalStateException e){
            logger.log(Level.WARNING, MessageFormat.format("Client made a bad request - {0}", e.toString()));
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            var safeErrorMessage = "Error while processing request to restore read database.";
            logger.log(Level.SEVERE, safeErrorMessage, e);
            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
