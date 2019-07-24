package com.github.joergdev.mosy.api.response.mockservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomRequestResponse", propOrder = {"stateOK", "messages", "record", "response"})
public class CustomRequestResponse extends AbstractResponse
{
  private boolean record;
  private String response;

  public boolean isRecord()
  {
    return record;
  }

  public void setRecord(boolean record)
  {
    this.record = record;
  }

  public String getResponse()
  {
    return response;
  }

  public void setResponse(String response)
  {
    this.response = response;
  }
}