package de.joergdev.mosy.api.response;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractResponse", propOrder = {"stateOK", "messages"})
public abstract class AbstractResponse
{
  @XmlElement(name = "stateOK")
  private boolean stateOK;

  @XmlElement(name = "messages")
  private final Collection<ResponseMessage> messages = new HashSet<>();

  public boolean isStateOK()
  {
    return stateOK;
  }

  public void setStateOK(boolean stateOK)
  {
    this.stateOK = stateOK;
  }

  public Collection<ResponseMessage> getMessages()
  {
    return messages;
  }

  public Collection<ResponseMessage> getMessagesForLevel(ResponseMessageLevel... level)
  {
    return messages.stream().filter(msg -> Arrays.asList(level).contains(msg.getResponseCode().level))
        .collect(Collectors.toList());
  }
}