package de.joergdev.mosy.api.response.recordconfig;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.response.AbstractResponse;

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