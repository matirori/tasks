package com.crud.tasks.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Badges {
    private int votes;
    private AttachmentsByType attachmentsByType;
}
