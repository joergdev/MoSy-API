package de.joergdev.mosy.api.response.record;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaveResponse", propOrder = {"stateOK", "messages", "recordID"})
public class SaveResponse extends AbstractResponse
{
  @XmlElement(name = "recordID")
  private Integer recordID;

  public Integer getRecordID()
  {
    return recordID;
  }

  public void setRecordID(Integer recordID)
  {
    this.recordID = recordID;
  }
}