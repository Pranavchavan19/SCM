package com.scm.helpers;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllA
public class Message {

    private String content;
    private MessageType  type = MessageType.blue;

}
