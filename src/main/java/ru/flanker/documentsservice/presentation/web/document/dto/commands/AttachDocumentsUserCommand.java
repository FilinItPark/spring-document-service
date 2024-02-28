package ru.flanker.documentsservice.presentation.web.document.dto.commands;

import lombok.Data;

import java.util.List;

@Data
public class AttachDocumentsUserCommand {

    private Long userId;
    private List<Long> documentIds;
}
