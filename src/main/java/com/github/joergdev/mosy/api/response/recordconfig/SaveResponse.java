package com.github.joergdev.mosy.api.response.recordconfig;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaveResponse", propOrder = {"stateOK", "messages", "recordConfigID"})
public class SaveResponse extends AbstractResponse
{
  @XmlElement(name = "recordConfigID")
  private Integer recordConfigID;

  public Integer getRecordConfigID()
  {
    return recordConfigID;
  }

  public void setRecordConfigID(Integer recordConfigID)
  {
    this.recordConfigID = recordConfigID;
  }
}